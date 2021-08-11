package com.green.chodoori;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVo;
import com.green.chodoori.main.domain.CorporateSignUpMetaDataFormVoRepo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVo;
import com.green.chodoori.main.domain.IndividualSginUpMetadataFormVoRepo;
import com.green.chodoori.main.domain.UserInfoDto;
import com.green.chodoori.main.domain.UserInfoRepo;
import com.green.chodoori.resume.domain.ResumeDto;
import com.green.chodoori.resume.domain.ResumeDtoRepo;
import com.green.chodoori.resume.web.domain.IntroductionDto;
import com.green.chodoori.resume.web.domain.SkillSetDto;
import com.green.chodoori.util.signup.UserMetaDataSeparatorService;

@Rollback(value = false)

@SpringBootTest
public class JpaTest {

	@Autowired
	UserInfoRepo userRepo;
	
	@Autowired
	CorporateSignUpMetaDataFormVoRepo metaRepo;
	
	@Autowired
	IndividualSginUpMetadataFormVoRepo individualRepo;
	
	@Autowired
	UserMetaDataSeparatorService service;
	
	@Autowired
	ResumeDtoRepo resumeRepo;
	
	//@BeforeEach
	public void init() {
		UserInfoDto dto = new UserInfoDto();
		dto.setId("testId2");
		dto.setName("테스트");
		dto.setBirth("930507");
		dto.setCity("수원");
		dto.setContact_num("01099321967");
		dto.setEmail("lookhkh@gan.com");
		dto.setImgPath("hi");
		dto.setSort(0);
		dto.setPw("lookhkh");
		
		
		userRepo.save(dto);
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000000");
	}
	
	@Transactional
	//@Test
	public void userRepoTest() {
		
		
		
		Optional<UserInfoDto> test = userRepo.findById("testId1");
		System.out.println(test.toString());
	
	}
	
	//@Test
	public void 회사메타정보JPA테스트() {
		UserInfoDto dto = userRepo.findById("testId1").get();
		System.out.println(dto.toString());

		CorporateSignUpMetaDataFormVo meta = new CorporateSignUpMetaDataFormVo();
		meta.setUser_info_corp(dto);
		meta.setAddress("부평구 30동");
		meta.setBussinessNum("00000000");
		meta.setManagerContactNum("01099321967");
		meta.setManagerName("조현일");
		
		
		metaRepo.save(meta);
		
		CorporateSignUpMetaDataFormVo test = metaRepo.findById("testId1").get();
		System.out.println(test.toString());
		
	}
	@Transactional
	//@Test
	public void 메타데이터저장테스트() {
		
		MultiValueMap<String, String> qp = new LinkedMultiValueMap();
		
		UserInfoDto dto = userRepo.findById("testId1").get();
		
		
		qp.add("id", "testId1");
		qp.add("dbs", "maria");
		qp.add("language", "spring");
		qp.add("exp", "경력");
		qp.add("period", "4~7년");
		qp.add("framework", "NODE");
		
		
		IndividualSginUpMetadataFormVo vo =service.separatorForUserMetadata(qp);
		
		vo.setUser_info_ind(dto);
		
		individualRepo.save(vo);
		
		System.out.println(vo.toString());
		
		
		System.out.println("온라됨");
		
		
	}
	//@Test
	@Transactional
	public void hi() {
		String userId = "testId2";
		UserInfoDto dto = userRepo.findById(userId).get();
		CorporateSignUpMetaDataFormVo meta =new CorporateSignUpMetaDataFormVo();
		meta.setAddress("동산구:");
		meta.setBussinessNum("000");
		meta.setManagerContactNum("0000");
		meta.setManagerName("ㅈ현일");
		meta.setUser_info_corp(dto);
		
		metaRepo.save(meta);
		
	}
	
	@Test
	@Transactional
	public void 이력서관리테스트() {
		UserInfoDto user = userRepo.findById("kim123").get();
		ResumeDto dto = ResumeDto.builder()
				.user(user)
				.disclosurestatus(0)
				.template_kind("first")
				.portfolio_first_desc("tset")
				.portfolio_first_github("test")
				.portfolio_first_img("test")
				.portfolio_first_name("test")
				.intro_dto(new IntroductionDto("test_intro","test_header","test_img"))
				.skill_dto(new SkillSetDto("1","2","3","4",null,null,null,null))
				.build();
			

		resumeRepo.save(dto);
		
		ResumeDto resume = resumeRepo.findById(user.getId()).get();
		System.out.println(resume.toString());
		
	}
	
	
	
	
}
