package com.wlopera.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wlopera.rest.domain.WSChampionship;
import com.wlopera.rest.domain.WSChampionshipList;

@Service("WSChampionshipService")
public class WSChampionshipServiceImpl implements WSChampionshipService {

	protected static Logger logger = Logger.getLogger(WSChampionshipServiceImpl.class);

	private WSChampionshipList dataList;

	public WSChampionshipServiceImpl() {
		Integer years[] = { 2014, 2010, 2006, 2002, 1998, 1994, 1990, 1986, 1932, 1978, 1974, 1970, 1966, 1962, 1958,
				1954, 1950, 1938, 1934, 1930 };

		String winners[] = { "Alemania", "España", "Italia", "Brasil", "Francia", "Brasil", "Alemania", "Argentina",
				"Italia", "Argentina", "Alemania", "Brasil", "Inglaterra", "Brasil", "Brasil", "Alemania", "Uruguay",
				"Italia", "Italia", "Uruguay" };

		String lossers[] = { "Argentina", "Holanda", "Francia", "Alemania", "Brasil", "Italia", "Argentina", "Alemania",
				"Alemania", "Holanda", "Holanda", "Italia", "Alemania", "Checoslovaquia", "Suecia", "Hungria", "Brasil",
				"Hungria", "Checoslovaquia", "Argentina" };

		String results[] = { "1-0", "1-0", "1-1", "2-0", "3-0",
				"0-0 -- Brasil ganó 3-2 por penales después de tiempo suplementario.", "1-0", "3-2", "3-1", "3-1",
				"2-1", "4-1", "4-2", "3-1", "5-2", "3-2", "2-1 -- Maracanazo", "4-2", "2-1", "4-2" };

		dataList = new WSChampionshipList();
		List<WSChampionship> data = new ArrayList<WSChampionship>();

		WSChampionship value;

		logger.info("###=> Iniciando Servicio WSChampionService - data DUMMY");

		for (int i = 0; i < years.length; i++) {
			value = new WSChampionship(i, years[i], winners[i], lossers[i], results[i]);
			data.add(value);
		}

		dataList.setData(data);
		logger.info("###=> Service data: " + dataList.toString());
	}

	/**
	 * Permite consultar toda la lista de campeonatos mundiales
	 * 
	 * @return lista de campeonatos
	 */
	@Override
	public List<WSChampionship> getAll() {
		logger.info("###=> Consulta de la lista de campeonatos mundiales");

		return dataList.getData();
	}

	/**
	 * Permite consultar un campeonato por id
	 * 
	 * @param id
	 * @return Campeonato mundial requerido
	 */
	@Override
	public WSChampionship getById(Integer id) {
		logger.info("###=> Consulta un campeonato mundial por identificador");
		if (null != dataList) {
			for (WSChampionship value : dataList.getData()) {
				if (id == value.getId()) {
					return value;
				}
			}
		}
		logger.info("###=> No hay datos disponibles");
		return null;
	}

	/**
	 * Permite consultar los datos generales
	 * 
	 * @return data
	 */
	@Override
	public WSChampionshipList getWSChampionshipList() {
		return dataList;
	}
}
