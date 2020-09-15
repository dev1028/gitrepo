package com.yedam.hairshop.members;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor

public class MembersVO {
	private String mem_no;
	private String mem_email;
	private String mem_pw;
	private String mem_name;
	private String mem_phone;
	private String mem_birth;
	private String mem_sex;
	private String mem_addr;
	private String mem_city;
	private String mem_country;
	private String mem_townshop;
	private String mem_latitude_longitude;
	private String mem_saved_money;
	private String mem_city_latitude_longitude;
	private String mem_hair_length;
	private String mem_hair_status;
	
}
