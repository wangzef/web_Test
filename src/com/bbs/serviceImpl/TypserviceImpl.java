package com.bbs.serviceImpl;

import java.util.List;

import com.bbs.dao.Typdao;
import com.bbs.daoImpl.TypdaoImpl;
import com.bbs.entity.Typ;
import com.bbs.service.Typservice;

public class TypserviceImpl implements Typservice {
    private Typdao td=new TypdaoImpl();
	@Override
	public List<Typ> showalltypeservice() {
		return td.showalltypedao();
	}
	@Override
	public List<Typ> showtypebyt_idservice(int t_id) {
		return td.showtypebyt_iddao(t_id);
	}

}
