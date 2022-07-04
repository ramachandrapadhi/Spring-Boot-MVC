package com.mess.service;

import java.util.List;

import com.mess.model.MonthlyBill;

public interface MBillServices {
	
	MonthlyBill postData(MonthlyBill mmodel);
	List<MonthlyBill> getDataAll();
//	Double getTotal();

}
