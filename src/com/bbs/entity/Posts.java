package com.bbs.entity;

public class Posts {
         private int p_id;
         private String p_title;
         private String p_content;
         private int p_state;
         private String p_time;
         private String p_ntime;
         private int t_id;
         private int u_id;
         
         
		public Posts() {
			super();
		}
		public Posts(int p_id, String p_title, String p_content, int p_state,
				String p_time, String p_ntime, int t_id, int u_id) {
			super();
			this.p_id = p_id;
			this.p_title = p_title;
			this.p_content = p_content;
			this.p_state = p_state;
			this.p_time = p_time;
			this.p_ntime = p_ntime;
			this.t_id = t_id;
			this.u_id = u_id;
		}
		public int getP_id() {
			return p_id;
		}
		public void setP_id(int p_id) {
			this.p_id = p_id;
		}
		public String getP_title() {
			return p_title;
		}
		public void setP_title(String p_title) {
			this.p_title = p_title;
		}
		public String getP_content() {
			return p_content;
		}
		public void setP_content(String p_content) {
			this.p_content = p_content;
		}
		public int getP_state() {
			return p_state;
		}
		public void setP_state(int p_state) {
			this.p_state = p_state;
		}
		public String getP_time() {
			return p_time;
		}
		public void setP_time(String p_time) {
			this.p_time = p_time;
		}
		public String getP_ntime() {
			return p_ntime;
		}
		public void setP_ntime(String p_ntime) {
			this.p_ntime = p_ntime;
		}
		public int getT_id() {
			return t_id;
		}
		public void setT_id(int t_id) {
			this.t_id = t_id;
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
         
		
         
}
