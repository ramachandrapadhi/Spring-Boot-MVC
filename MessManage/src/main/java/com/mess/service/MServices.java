package com.mess.service;

import java.util.List;

import com.mess.model.MModel;
import com.mess.model.SearchModel;

public interface MServices {
	
	MModel postData(MModel mmodel);
	List<MModel> getDataAll(SearchModel model);
	Double getTotal();

}
