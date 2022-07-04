package com.mess.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.mess.model.BaseModel;
import com.mess.model.MModel;

public interface GenUtil {
	public static String ADMIN = "SuperAdmin";

	public static void setCreate(MModel mmodel) {

		mmodel.setId(generateId());
		mmodel.setCreatAt(getTime());
		mmodel.setCreatBy(ADMIN);
		mmodel.setUpdatAt(getTime());
		mmodel.setUpdateBy(ADMIN);
	}

	public static String generateId() {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(15);
	}

	public static void setUpdate(MModel mmodel) {
		mmodel.setUpdatAt(getTime());
		mmodel.setUpdateBy(ADMIN);
	}
	private static String getTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	
	public static void setCreate(BaseModel model) {
		model.setCreatAt(getTime());
		model.setCreatBy(ADMIN);
		model.setUpdatAt(getTime());
		model.setUpdateBy(ADMIN);
	}
	
	
	
	

}
