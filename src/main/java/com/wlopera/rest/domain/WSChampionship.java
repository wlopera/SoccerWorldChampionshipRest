package com.wlopera.rest.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WSChampionship")
public class WSChampionship implements Serializable {

	private static final long serialVersionUID = 6765681174847538161L;

	private Integer id;
	private int year;
	private String country;
	private String winner;
	private String losser;
	private String result;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getLosser() {
		return losser;
	}

	public void setLosser(String losser) {
		this.losser = losser;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public WSChampionship() {
		super();
	}

	public WSChampionship(Integer id, int year, String country, String winner, String losser, String result) {
		super();
		this.id = id;
		this.year = year;
		this.country = country;
		this.winner = winner;
		this.losser = losser;
		this.result = result;
	}

	@Override
	public String toString() {
		return "SoccerWorldChampionship [id=" + id + ", year=" + year + ", country=" + country + ", winner=" + winner
				+ ", losser=" + losser + ", result=" + result + "]";
	}

}
