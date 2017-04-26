package com.bbs.entity;

public class Diss {
          private int d_id;
          private String d_content;
          private String d_time;
          private int u_id;
          private int p_id;
          
          
		public Diss() {
			super();
		}
		public Diss(int d_id, String d_content, String d_time, int u_id,
				int p_id) {
			super();
			this.d_id = d_id;
			this.d_content = d_content;
			this.d_time = d_time;
			this.u_id = u_id;
			this.p_id = p_id;
		}
		public int getD_id() {
			return d_id;
		}
		public void setD_id(int d_id) {
			this.d_id = d_id;
		}
		public String getD_content() {
			return d_content;
		}
		public void setD_content(String d_content) {
			this.d_content = d_content;
		}
		public String getD_time() {
			return d_time;
		}
		public void setD_time(String d_time) {
			this.d_time = d_time;
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		public int getP_id() {
			return p_id;
		}
		public void setP_id(int p_id) {
			this.p_id = p_id;
		}
          
}
