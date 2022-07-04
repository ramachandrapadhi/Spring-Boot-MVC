package com.mess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mess.model.MonthlyBill;
import com.mess.service.MBillServices;

@Controller
@RequestMapping("mspend")
public class MonthlySpendController {

	@Autowired
	private MBillServices service;
	
	@GetMapping(path="/mSeteled")
	public String monthIndex(Model model) {
		
		model.addAttribute("mSpendList", getAll());
		return "mSeteled";
	}

	@PostMapping(path = "/addmspend")
	public String postMSpend(@ModelAttribute MonthlyBill mmodel, Model model){
		
		MonthlyBill mmodell = service.postData(mmodel);
		
		
		model.addAttribute("toast", mmodell!=null ?"Added Succssfully " : "Error while Add");
		model.addAttribute("mSpendList", getAll());
		
		return "mSeteled";
	}
	
	private List<MonthlyBill> getAll(){
		return service.getDataAll();
	}
	
	
}
