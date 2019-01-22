package com.cricbuzz.score.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="score")
public class ScorePojo {
	@Id
	private Integer runs;
	private Integer wickets;
	private String overs;
	private String bat1;
	private String bat2;
	private String country;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getRuns() {
		return runs;
	}
	public void setRuns(Integer runs) {
		this.runs = runs;
	}
	public Integer getWickets() {
		return wickets;
	}
	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}
	
	public String getOvers() {
		return overs;
	}
	public void setOvers(String overs) {
		this.overs = overs;
	}
	public String getBat1() {
		return bat1;
	}
	public void setBat1(String bat1) {
		this.bat1 = bat1;
	}
	public String getBat2() {
		return bat2;
	}
	public void setBat2(String bat2) {
		this.bat2 = bat2;
	}
	
	
	

}
