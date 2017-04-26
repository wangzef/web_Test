package com.bbs.entity;

public class Typ {
		private int t_id;
		private String t_type;
		
		public Typ() {
			super();
		}
		public Typ(int t_id, String t_type) {
			super();
			this.t_id = t_id;
			this.t_type = t_type;
		}
		public int getT_id() {
			return t_id;
		}
		public void setT_id(int t_id) {
			this.t_id = t_id;
		}
		public String getT_type() {
			return t_type;
		}
		public void setT_type(String t_type) {
			this.t_type = t_type;
		}
		
}
