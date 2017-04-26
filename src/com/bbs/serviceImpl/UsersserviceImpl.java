package com.bbs.serviceImpl;

import java.util.List;

import com.bbs.dao.Usersdao;
import com.bbs.daoImpl.UsersdaoImpl;
import com.bbs.entity.Users;
import com.bbs.service.Usersservice;

public class UsersserviceImpl implements Usersservice {
    private Usersdao ud=new UsersdaoImpl();
	@Override
	public boolean Loginservice(Users users,int u_limits) {
		return ud.Logindao(users,u_limits);
	}

	@Override
	public boolean Regservice(Users users) {
		return ud.Regdao(users);
	}

	@Override
	public boolean selectSameservice(String u_name) {
		return ud.selectSamedao(u_name);
	}

	@Override
	public Users selectnamebyu_idservice(int u_id) {
		return ud.selectnamebyu_iddao(u_id);
	}

	@Override
	public Users selectusersbyu_nameservice(String u_name) {
		return ud.selectusersbyu_namedao(u_name);
	}

	@Override
	public List<Users> showallusersservice() {
		return ud.showallusersdao();
	}

	@Override
	public boolean updateu_statebyu_idservice(int u_id, int u_state) {
		return ud.updateu_statebyu_iddao(u_id, u_state);
	}

	@Override
	public boolean updatemsgby_nameservice(String name, String pwd, String sex,
			String major, String year, String photo, String u_name) {
		return ud.updatemsgby_namedao(name, pwd, sex, major, year, photo, u_name);
	}

}
