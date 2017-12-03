package com.wlopera.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WSChampionshipList")
public class WSChampionshipList {

	private List<WSChampionship> data;

	public List<WSChampionship> getData() {
		return data;
	}

	public void setData(List<WSChampionship> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SoccerWorldChampionshipList [data=" + data + "]";
	}

}
