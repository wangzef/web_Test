package com.bbs.entity;

public class Users {
         private int u_id;
         private String u_name;
         private String u_pwd;
         private String u_sex;
         private String u_photo;
         private String u_year;
         private String u_major;
         private String u_regtime;
         private int u_state;
         private int u_limits;
         
		public Users() {
			super();
		}
		public Users(int u_id, String u_name, String u_pwd, String u_sex,
				String u_photo, String u_year, String u_major,
				String u_regtime, int u_state, int u_limits) {
			super();
			this.u_id = u_id;
			this.u_name = u_name;
			this.u_pwd = u_pwd;
			this.u_sex = u_sex;
			this.u_photo = u_photo;
			this.u_year = u_year;
			this.u_major = u_major;
			this.u_regtime = u_regtime;
			this.u_state = u_state;
			this.u_limits = u_limits;
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		public String getU_name() {
			return u_name;
		}
		public void setU_name(String u_name) {
			this.u_name = u_name;
		}
		public String getU_pwd() {
			return u_pwd;
		}
		public void setU_pwd(String u_pwd) {
			this.u_pwd = u_pwd;
		}
		public String getU_sex() {
			return u_sex;
		}
		public void setU_sex(String u_sex) {
			this.u_sex = u_sex;
		}
		public String getU_photo() {
			return u_photo;
		}
		public void setU_photo(String u_photo) {
			this.u_photo = u_photo;
		}
		public String getU_year() {
			return u_year;
		}
		public void setU_year(String u_year) {
			this.u_year = u_year;
		}
		public String getU_major() {
			return u_major;
		}
		public void setU_major(String u_major) {
			this.u_major = u_major;
		}
		public String getU_regtime() {
			return u_regtime;
		}
		public void setU_regtime(String u_regtime) {
			this.u_regtime = u_regtime;
		}
		public int getU_state() {
			return u_state;
		}
		public void setU_state(int u_state) {
			this.u_state = u_state;
		}
		public int getU_limits() {
			return u_limits;
		}
		public void setU_limits(int u_limits) {
			this.u_limits = u_limits;
		}
         
       
    
}
