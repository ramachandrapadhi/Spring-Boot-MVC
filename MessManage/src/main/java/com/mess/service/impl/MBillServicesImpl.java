package com.mess.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mess.model.MonthlyBill;
import com.mess.repo.MonthlySpendReposetory;
import com.mess.service.MBillServices;
import com.mess.util.GenUtil;

@Service
public class MBillServicesImpl implements MBillServices {

	@Autowired
	private MonthlySpendReposetory repo;

	@Override
	public MonthlyBill postData(MonthlyBill mmodel) {
		mmodel.setId(GenUtil.generateId());
		mmodel.setPerHead(getPerHead(mmodel));
		GenUtil.setCreate(mmodel);
		mmodel = repo.save(mmodel);
		return mmodel;
	}

	@Override
	public List<MonthlyBill> getDataAll() {
		return repo.findAll(Sort.by(Sort.Direction.DESC, "creatAt"))
				.stream().peek(m-> m.setCreatAt(dateFormart(m.getCreatAt()))).collect(Collectors.toList());
	}

	private Double getPerHead(MonthlyBill bill) {
		double rent = bill.getRoomRent();
		double ele = bill.getElecBill();
		double water = bill.getWaterBill();
		double mess = bill.getMessBill();
		return (rent + ele + water + mess) / 3;
	}
	
	private String dateFormart(String dd) {
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
		Date date =null;
		try {
			date = dt.parse(dd);
			System.out.println(dt1.format(date));
			return dt1.format(date);
		} catch (ParseException e) {
			return  dd;
		} 
	}
	
	

}
