package com.green.chodoori.corporate.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.green.chodoori.main.domain.UserInfoDto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Entity//데이터베이스에 저장하기 위해 유저가 정의한 클래스
@Table(name="COMPANY_INTRO_DETAIL")//별도의 이름을 가진 데이터베이스 테이블과 매핑한다
public class CorporateDetailDto {
//	회사 상세보기 게시판
	public CorporateDetailDto() {
		super();
	}
	
	@Builder//복합객체의 생성 과정과 표현방법을 분리하여 동일한 생성 절차에서 서로 다른 표현결과를 만들수있게해주는 패턴
	public CorporateDetailDto(String cid, UserInfoDto userid, String userName, String logo_img, Integer staff_number,
			String weleare_first, String weleare_second, String weleare_third, String summary) {
		super();
		this.cid = cid;
		this.userid = userid;
		this.userName = userName;
		this.logo_img = logo_img;
		this.staff_number = staff_number;
		this.weleare_first = weleare_first;
		this.weleare_second = weleare_second;
		this.weleare_third = weleare_third;
		this.summary = summary;
	}
	
	@Id //primary key를 가지는 변수를 선언하는 것을 뜻한다. 
	private String cid;
	

	@MapsId
	@OneToOne	//1:1관계
	@JoinColumn(name = "USER_ID")
	private UserInfoDto userid;
	
	private String userName;
	private String logo_img;
	private Integer staff_number;
	private String weleare_first;
	private String weleare_second;
	private String weleare_third;
	private String summary;
	
}
