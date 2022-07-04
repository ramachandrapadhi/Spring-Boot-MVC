package com.mess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mess.model.MModel;
import com.mess.model.SearchModel;
import com.mess.service.MServices;

@Controller
public class MController {
	
	@Autowired
	private MServices service;	
	
	private Boolean showTable=false;
	private String message="";
	private Boolean toast = false;

	
	@GetMapping(path = "/")
	public String index(Model model) {
		return "welcome";
	}
	
	@PostMapping(path="/addData")
	public String  addData(@ModelAttribute MModel mmodel, Model model) {
		MModel mm = service.postData(mmodel);
		toast = true;
		message = mm != null ? "Sata Stored Successfully" :"Some error occored";
		model.addAttribute("toast",toast);
		model.addAttribute("message",message);
		
		return "welcome";
	}
	
	@GetMapping(path = "/getAll")
	public String getDataAll(Model model){
		return "getAll";
	}
	
	@PostMapping(path="/searchData")
	public String  searchData(@ModelAttribute SearchModel mmodel, Model model) {
		System.out.println(mmodel);
		List<MModel> list = service.getDataAll(mmodel) ;
		double total = service.getTotal();
		
		System.out.println(list);
		
		toast = true;
		showTable = true;
		message = list.size()>0? "Data Get Successfully" : "No Data Found";
		model.addAttribute("toast",toast);
		model.addAttribute("message",message);
		model.addAttribute("showTable",showTable);
		model.addAttribute("listData",list);
		model.addAttribute("total",total);
		
		return "getAll";
	}
	
	
}
