package com.green.chodoori.corporate.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.green.chodoori.main.domain.UserInfoDto;

import lombok.Builder;
import lombok.Data;

@SequenceGenerator(name = "company_detail_seq",allocationSize = 1)
@Data
@Entity//데이터베이스에 저장하기 위해 유저가 정의한 클래스
@Table(name="COMPANY_INTRO_DETAIL")//별도의 이름을 가진 데이터베이스 테이블과 매핑한다
@DynamicUpdate
public class CorporateDetailDto {
//	회사 상세보기 게시판
	public CorporateDetailDto() {
		super();
	}
	
	
	@Builder
	public CorporateDetailDto(UserInfoDto userid, String logo_img, Integer staff_number,
			WelfareDto welfare, String summary, String companayName,String salary) {
		super();
		this.userid = userid;
		this.logo_img = logo_img;
		this.staff_number = staff_number;
		this.welfare = welfare;
		this.summary = summary;
		this.companayName = companayName;
		this.salary = salary;
	}



	@Id @GeneratedValue(generator = "company_detail_seq") //primary key를 가지는 변수를 선언하는 것을 뜻한다. 
	private Long info_id;
	

	@OneToOne	//1:1관계
	@JoinColumn(name = "USER_ID")
	private UserInfoDto userid;
	
	private String logo_img;
	private Integer staff_number;
	@Embedded
	private WelfareDto welfare;
	private String summary;
	@Column(name = "COMPANY_NAME")
	private String companayName;
	
	private String salary;
	
}
