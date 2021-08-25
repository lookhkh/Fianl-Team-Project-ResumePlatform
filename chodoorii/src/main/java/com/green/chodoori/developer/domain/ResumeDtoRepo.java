package com.green.chodoori.developer.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDtoRepo extends JpaRepository<ResumeDto, String> {

	Page<ResumeDto> findByDisclosurestatus(Integer disclosurestatus, Pageable pageable);
}
