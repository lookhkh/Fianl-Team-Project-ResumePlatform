package com.green.chodoori.nonCorporate.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.chodoori.nonCorporate.domain.ResumeDto;
import com.green.chodoori.nonCorporate.domain.ResumeDtoRepo;

@Repository
public class ResumeRepository {
	
	@Autowired
	ResumeDtoRepo resumeRepo;
	
	public void saveResumeDto(ResumeDto dto) {
		resumeRepo.save(dto);
	}
	
	public void deleteResumeDto(ResumeDto dto) {
		resumeRepo.delete(dto);
	}
	
	public Optional<ResumeDto> findByIdForResume(String id) {
		return resumeRepo.findById(id);
	}
	



}
