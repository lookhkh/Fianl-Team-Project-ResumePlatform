package com.green.chodoori.resume.controller;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.chodoori.error.ResumeNotFoundError;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.main.service.ExtractSessionInfoService;
import com.green.chodoori.main.web.domain.SessionUserInfo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;
import com.green.chodoori.resume.domain.SharedMyResumeInfoDto;
import com.green.chodoori.resume.domain.SharedMyResumeInfoDtoRepo;
import com.green.chodoori.resume.service.ChangeUsersResumeStatusService;
import com.green.chodoori.util.mail.MailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/resume")
public class ResumeController {

	@Autowired
	ExtractSessionInfoService sessionExtractor;

	@Autowired
	UserInfoRepo userRepo;

	@Autowired
	ResumeDtoRepo resumeRepo;

	@Autowired
	SharedMyResumeInfoDtoRepo smRepo; // 공유 레포지토리 의존성 주입

	@Autowired
	MailService mail;

	@Autowired
	ChangeUsersResumeStatusService userStatusService;

	@GetMapping("/display")
	public String displayMyResume(HttpSession session, Model model) {

		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);

		Optional<ResumeDto> resume = resumeRepo.findById(sessionInfo.getId());

		if (resume.isPresent()) {

			String templateNumber = resume.get().getTemplate_kind();
			String template = "/resume/template/templateSample" + templateNumber;

			log.info("템플릿 종류 : {}", template);

			model.addAttribute("resume", resume.get());

			return template;

		} else {
			throw new ResumeNotFoundError("이력서가 존재하지 않습니다");
		}

	}

	@GetMapping("/remove")
	@Transactional
	public String removeMyResume(HttpSession session) {

		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);

		Optional<ResumeDto> resume = resumeRepo.findById(sessionInfo.getId());

		resumeRepo.delete(resume.get());

		userRepo.findById(sessionInfo.getId()).get().setCheck_detail(1);

		sessionInfo.setCheck(1);

		session.setAttribute("userInfo", sessionInfo);

		return "redirect:/resume/";
	}

	@GetMapping("/edit")
	@Transactional
	public String editMyResume(HttpSession session) {

		userStatusService.changeStatus(1, session);

		return "redirect:/resume/edit/template";

	}

	// 공유 버튼 누를시 공유 페이지 호출

	@GetMapping("/share")
	public String shareForm() {
		log.info("공유 페이지 호출");
		return "/resume/resumeShare";
	}

	@PostMapping("/share/mail")
	public String shareMyResumeByEmail(@RequestParam("to") String to, @RequestParam("what") String what,
			HttpSession session) throws UnsupportedEncodingException {

		SessionUserInfo sessionInfo = sessionExtractor.extractSessionUserInfo(session);
		// 현재 접속되어있는 세션?

		SharedMyResumeInfoDto myInfo = new SharedMyResumeInfoDto();
		// 유저 정보 DTO

		myInfo.setRegisterDate(new Date());
		// 현재 시간을 새로 넣고
		myInfo.setUserInfoDto(userRepo.getById(sessionInfo.getId()));
		// 유저 세션으로 id값을 불러와서
		mail.sendMailForSharingMyResume(to, what, sessionInfo.getId());
		// 잘 모르겠음

		smRepo.save(myInfo);
		// SharedMyResumeInfoDto 에 저장
		return "redirect:/resume?share=on";

		// 메일 보내기 기능 넣기.

		// id값과 registerDate 생성
	}

	@GetMapping("/share/mail/{userId}")
	public String displayMyResumeByEmail(@PathVariable String userId, Model model) throws UnsupportedEncodingException {
		System.out.println(userId);
		// 불러온 유저 아이디를 consol창을 통해 확인

		ResumeDto myInfo = resumeRepo.findById("test1234").get();
		// 테스트용 아이디를 불러옴
		String templateKind = "/resume/template/templateSample" + myInfo.getTemplate_kind();
		// 내 이력서를 저장한 템플릿 종류를 가져옴
		model.addAttribute("resume", myInfo);

		return templateKind;
	}

	//@Scheduled(cron = "0 0 * * * ?")//1시간마다 실행
	public void delete(@RequestParam Long id, @RequestBody SharedMyResumeInfoDto dto) {

		Optional<SharedMyResumeInfoDto> smdto = smRepo.findById(id);
		// 유저 id값으로 조회
		Calendar calender = Calendar.getInstance(); // 캘린더 객체 생성
		long todayMil = calender.getTimeInMillis(); // 현재시간
		long oneday = 24 * 60 * 60 * 1000; // 하루 단위
		Calendar idcal = Calendar.getInstance();

		smdto.ifPresent(userinfo -> {
			idcal.setTime(userinfo.getRegisterDate()); // 현재 시간과 id생성일의 기록된 시간
			long timediff = todayMil - idcal.getTimeInMillis();// 현재시간에서 regidate를 뺀 시간
			int daydiff = (int) (timediff / oneday);
			if (daydiff > 1) {
				smRepo.delete(userinfo);
				log.info("이력서 기간이 만료되어 삭제 되었습니다.");
			}
		});
	}

}
