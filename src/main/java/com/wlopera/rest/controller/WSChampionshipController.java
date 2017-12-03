package com.wlopera.rest.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wlopera.rest.domain.WSChampionshipList;
import com.wlopera.rest.service.WSChampionshipService;

@Controller
public class WSChampionshipController {

	protected static Logger logger = Logger.getLogger(WSChampionshipController.class);

	@Resource(name = "WSChampionshipService")
	private WSChampionshipService service;

	@RequestMapping(value = "/getWSChampionshipList", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
	private @ResponseBody WSChampionshipList getWSChampionshipList() {
		logger.info("##=> llamada al servicio getWSChampionService");
		System.out.println("##=> llamada al servicio getWSChampionService");
		return service.getWSChampionshipList();
	}

}
