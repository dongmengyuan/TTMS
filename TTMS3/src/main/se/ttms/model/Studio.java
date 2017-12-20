package main.se.ttms.model;

import java.io.Serializable;

public class Studio implements Serializable{
	private Integer studio_id;
	
	private String studio_name;
	
	private Integer studio_row_count;
	
	private Integer studio_col_count;
	
	private String studio_introduction;
	
	@Override
	public String toString() {
		return "Studio [studio_id=" + studio_id + ", studio_name=" + studio_name + ", studio_row_count="
				+ studio_row_count + ", studio_col_count=" + studio_col_count + ", studio_introduction="
				+ studio_introduction + ", studio_flag=" + studio_flag + "]";
	}

	private Integer studio_flag;

	public Integer getStudio_id() {
		return studio_id;
	}

	public void setStudio_id(Integer studio_id) {
		this.studio_id = studio_id;
	}

	public String getStudio_name() {
		return studio_name;
	}

	public void setStudio_name(String studio_name) {
		this.studio_name = studio_name;
	}

	public Integer getStudio_row_count() {
		return studio_row_count;
	}

	public void setStudio_row_count(Integer studio_row_count) {
		this.studio_row_count = studio_row_count;
	}

	public Integer getStudio_col_count() {
		return studio_col_count;
	}

	public void setStudio_col_count(Integer studio_col_count) {
		this.studio_col_count = studio_col_count;
	}

	public String getStudio_introduction() {
		return studio_introduction;
	}

	public void setStudio_introduction(String studio_introduction) {
		this.studio_introduction = studio_introduction;
	}

	public Integer getStudio_flag() {
		return studio_flag;
	}

	public void setStudio_flag(Integer studio_flag) {
		this.studio_flag = studio_flag;
	}
	
	
}
