package com.ats.application.network.webclient.xsd;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XSDUnMarshal {

	/**
	 * Method will read the config file stream and parse to DTO
	 * 
	 * @param configStream
	 * @return
	 * @throws JAXBException
	 */
	public WebClientXSDDTO mapXMLToClientDTO(InputStream configStream) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(WebClientXSDDTO.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (WebClientXSDDTO) jaxbUnmarshaller.unmarshal(configStream);

	}

}
