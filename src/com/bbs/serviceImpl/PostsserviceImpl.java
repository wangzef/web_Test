package com.bbs.serviceImpl;

import java.util.List;

import com.bbs.dao.Postsdao;
import com.bbs.daoImpl.PostsdaoImpl;
import com.bbs.entity.Posts;
import com.bbs.service.Postsservice;

public class PostsserviceImpl implements Postsservice {
	private Postsdao pss=new PostsdaoImpl();

	@Override
	public List<Posts> showpostsbyt_idservice(int t_id) {
		// TODO 自动生成的方法存根
		return pss.showpostsbyt_iddao(t_id);
	}

	@Override
	public List<Posts> showallpostsservice() {
		// TODO 自动生成的方法存根
		return pss.showallpostsdao();
	}

	@Override
	public List<Posts> showpostsbyp_idservice(int p_id) {
		// TODO 自动生成的方法存根
		return pss.showpostsbyp_iddao(p_id);
	}

	@Override
	public boolean updatep_ntimeservice(String p_ntime, int p_id) {
		// TODO 自动生成的方法存根
		return pss.updatep_ntimedao(p_ntime, p_id);
	}

	@Override
	public List<Posts> showpostbyt_idservice(int t_id) {
		// TODO 自动生成的方法存根
		return pss.showpostbyt_iddao(t_id);
	}

	@Override
	public boolean addpostsdao(Posts posts) {
		// TODO 自动生成的方法存根
		return pss.addpostsdao(posts);
	}

	@Override
	public boolean deletepostsbyp_idservice(int p_id) {
		// TODO 自动生成的方法存根
		return pss.deletepostsbyp_iddao(p_id);
	}

	@Override
	public boolean updatep_stateservice(int p_state, int p_id) {
		// TODO 自动生成的方法存根
		return pss.updatep_statedao(p_state, p_id);
	}

	@Override
	public boolean updatep_titlebyp_idservice(String p_title, int p_id) {
		// TODO 自动生成的方法存根
		return pss.updatep_titlebyp_iddao(p_title, p_id);
	}
	

}
