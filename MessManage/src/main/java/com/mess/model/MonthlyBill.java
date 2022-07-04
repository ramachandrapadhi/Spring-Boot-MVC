package com.mess.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode( callSuper = false)
@Entity
@Table(name="monthly_cost")
public class MonthlyBill extends BaseModel{
	
	@Id
	@Column(name="ID", length = 70, nullable = false,updatable = false)
	private String id;
	
	@Column(name="ROOM_RENT",nullable = false, columnDefinition="Decimal(10,2) default '0.00'")
	private Double roomRent;
	
	@Column(name="WATER_BILL",nullable = false, columnDefinition="Decimal(10,2) default '0.00'")
	private Double waterBill;
	
	@Column(name="ELECTRICITY_BILL",nullable = false,columnDefinition="Decimal(10,2) default '0.00'")
	private Double elecBill;
	
	@Column(name="MESS_BILL",nullable = false, columnDefinition="Decimal(10,2) default '0.00'")
	private Double messBill;
	
	@Column(name="PERR_HEAD",nullable = false, columnDefinition="Decimal(10,2) default '0.00'")
	private Double perHead;
	


}
