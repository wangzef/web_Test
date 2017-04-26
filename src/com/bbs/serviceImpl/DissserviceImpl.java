package com.bbs.serviceImpl;

import java.util.List;

import com.bbs.dao.Dissdao;
import com.bbs.daoImpl.DissdaoImpl;
import com.bbs.entity.Diss;
import com.bbs.service.Dissservice;

public class DissserviceImpl implements Dissservice {
	Dissdao dd=new DissdaoImpl();
	
	@Override
	public List<Diss> showdissbyp_idservice(int p_id) {
		return dd.showdissbyp_iddao(p_id);
	}

	@Override
	public boolean adddissservice(Diss d) {
		return dd.adddissdao(d);
	}

	@Override
	public boolean admadddissservice(Diss d) {
		return dd.admadddissdao(d);
	}

}
