package com.wlopera.rest.service;

import java.util.List;

import com.wlopera.rest.domain.WSChampionship;
import com.wlopera.rest.domain.WSChampionshipList;

public interface WSChampionshipService {

	/**
	 * Permite consultar toda la lista de campeonatos mundiales
	 * 
	 * @return lista de campeonatos
	 */
	public List<WSChampionship> getAll();

	/**
	 * Permite consultar un campeonato por id
	 * 
	 * @param id
	 * @return Campeonato mundial requerido
	 */
	public WSChampionship getById(Integer id);

	/**
	 * Permite consultar los datos generales
	 * 
	 * @return data
	 */
	public WSChampionshipList getWSChampionshipList();

}
