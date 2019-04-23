package com.ats.application.network.webclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.bind.JAXBException;

import com.ats.application.network.webclient.ui.WebClientUI;
import com.ats.application.network.webclient.xsd.WebClientXSDDTO;
import com.ats.application.network.webclient.xsd.WebClientXSDDTO.FileConfig;
import com.ats.application.network.webclient.xsd.XSDUnMarshal;

public class WebClient {

	public static void main(String[] args) {
		WebClientXSDDTO xsdDTO = null;
		WebClient clientTool = null;

		clientTool = new WebClient();
		try {
			xsdDTO = clientTool.readConfigFileAndParse();
			int runMode = Integer.parseInt(xsdDTO.getRunMode());
			if (xsdDTO != null) {
				clientTool.checkFilesAndFolders(xsdDTO);
				if (runMode == 1) {
					WebClientUI clientUI = null;
					clientUI = new WebClientUI(xsdDTO);
					clientUI.setVisible(true);
				} else {
					System.out.println("Web client");
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (JAXBException e) {
			System.out.println(e);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * This method will check for folders and file exist
	 * 
	 * @param xsdDTO
	 * @throws FileNotFoundException
	 */
	private void checkFilesAndFolders(WebClientXSDDTO xsdDTO) throws FileNotFoundException {
		FileConfig fileConfig = xsdDTO.getFileConfig();
		if (fileConfig != null) {
			String strInputPath = fileConfig.getInputFilePath();
			checkAndCreate(strInputPath, false);
			String strOutputPath = fileConfig.getOutputFilePath();
			checkAndCreate(strOutputPath, false);
			String strCertFile = fileConfig.getCertificatePath();
			checkAndCreate(strCertFile, true);

		}
	}

	/**
	 * Create folder if not exist
	 * 
	 * @param strInputPath
	 * @throws FileNotFoundException
	 */
	private void checkAndCreate(String strInputPath, boolean read) throws FileNotFoundException {
		File f = new File(strInputPath);
		if (!read) {
			if (!f.exists())
				f.mkdirs();
		} else {
			if (!(f.exists() && f.canRead()))
				throw new FileNotFoundException("Certificate file not found or failed to read");
		}
	}

	/**
	 * This method will read config file and map to DTO
	 * 
	 * @return
	 * @throws JAXBException
	 * @throws FileNotFoundException
	 */
	private WebClientXSDDTO readConfigFileAndParse() throws JAXBException, FileNotFoundException {
		InputStream configStream = null;
		File configFile = null;
		configFile = new File("Config.xml");
		try {
			configStream = new FileInputStream(configFile);
			if (configFile.canRead()) {
				XSDUnMarshal xsdUnMarshal = new XSDUnMarshal();
				return xsdUnMarshal.mapXMLToClientDTO(configStream);
			}

		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Config file not found. Please check file Config.xml");
		} catch (JAXBException e) {
			throw new JAXBException("Config file cannot read and map. Please check file Config.xml");
		} finally {
			if (configStream != null) {
				try {
					configStream.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		return null;
	}

}
