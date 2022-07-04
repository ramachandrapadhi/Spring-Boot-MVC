package com.mess.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel {
	
	@Column(name="CREATE_AT" ,nullable = false,length = 30, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String creatAt;
	
	@Column(name="CREATE_BY" ,length = 70)
	private String creatBy;
	
	@Column(name="UPDATE_AT" ,nullable = false,length = 30, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String updatAt;
	
	@Column(name="UPDATE_BY",length = 70)
	private String updateBy;
}
