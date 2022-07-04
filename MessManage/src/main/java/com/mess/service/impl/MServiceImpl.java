package com.mess.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mess.model.MModel;
import com.mess.model.SearchModel;
import com.mess.repo.MReposetory;
import com.mess.service.MServices;
import com.mess.util.GenUtil;

@Service
public class MServiceImpl implements MServices {
	
	@Autowired
	private MReposetory repo;
	
	private Double totalAmmount = 0.0;

	@Override
	public MModel postData(MModel mmodel) {
		GenUtil.setCreate(mmodel);
		mmodel = repo.save(mmodel);
		return mmodel;
	}

	@Override
	public List<MModel> getDataAll(SearchModel model) {
		String fromDate = model.getFromDate();
		String toDate = model.getToDate();
		String name = model.getName();
		totalAmmount = 0.0;
		
		StringBuilder sb = null;
		sb = new StringBuilder(fromDate);
		sb.append(" ");
		sb.append("23:59:59");
		fromDate = sb.toString();
		
		sb = new StringBuilder(toDate);
		sb.append(" ");
		sb.append("23:59:59");
		toDate = sb.toString();
 		
		if(name.isBlank() ) {
			List<MModel> list = repo.getByDate(fromDate,toDate);
			list.forEach(e-> totalAmmount+=e.getAmt());
			return list.stream().peek(m-> m.setCreatAt(dateFormart(m.getCreatAt()))).collect(Collectors.toList());
		}else {
			List<MModel> list = repo.getByDate(fromDate,toDate,name);
			list.forEach(e-> totalAmmount+=e.getAmt());
			
			return 
					list.stream()
					.peek(m-> m.setCreatAt(dateFormart(m.getCreatAt()))).collect(Collectors.toList());
		}
	}
	
	private String dateFormart(String dd) {
		System.out.println(dd);
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
		Date date =null;;
		try {
			date = dt.parse(dd);
			System.out.println(dt1.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return dt1.format(date);
	}
	
	
	public Double getTotal() {
		
		System.out.println(totalAmmount);
		return totalAmmount;
	}
	
	

}
