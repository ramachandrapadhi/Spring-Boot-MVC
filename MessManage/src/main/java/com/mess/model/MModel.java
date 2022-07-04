package com.mess.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name="mess_data")
public class MModel {
	
	@Id
	@Column(name="ID", length = 70, nullable = false,updatable = false)
	private String id;
	
	@Column(name="INV_NAME", length = 80,nullable = false)
	private String name;
	
	@Column(name="DESCRIPTION", columnDefinition = "TEXT")
	private String desc;
	
	@Column(name="AMMOUNT",nullable = false,length = 30, columnDefinition="Decimal(10,2) default '0.00'")
	private Double amt;
	
	@Column(name="CREATE_AT" ,nullable = false,length = 30, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String creatAt;
	
	@Column(name="CREATE_BY" ,length = 70)
	private String creatBy;
	
	@Column(name="UPDATE_AT" ,nullable = false,length = 30, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private String updatAt;
	
	@Column(name="UPDATE_BY",length = 70)
	private String updateBy;

}
