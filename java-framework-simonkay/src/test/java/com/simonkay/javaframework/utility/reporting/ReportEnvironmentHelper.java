package com.simonkay.javaframework.utility.reporting;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReportEnvironmentHelper {
	
	private String allureEnvironmentXmlPath;
	private File xmlFile;
	private DocumentBuilderFactory dbFactory;
    private DocumentBuilder dBuilder;
    private Document doc;
    
 
	public ReportEnvironmentHelper() {
		this.allureEnvironmentXmlPath = "src/test/resources/allure_settings/environment.xml";
		xmlFile = new File(this.allureEnvironmentXmlPath);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(xmlFile);
		NodeList nodeList = doc.getElementsByTagName("parameter");
		Element browser = (Element) nodeList.item(1);
		Element execution = (Element) nodeList.item(2);
		Element server = (Element) nodeList.item(0);
		System.out.println(browser.getElementsByTagName("name").item(0).getTextContent());
		System.out.println(browser.getElementsByTagName("value").item(0).getTextContent());
		System.out.println(execution.getElementsByTagName("name").item(0).getTextContent());
		System.out.println(execution.getElementsByTagName("value").item(0).getTextContent());
		System.out.println(server.getElementsByTagName("name").item(0).getTextContent());
		System.out.println(server.getElementsByTagName("value").item(0).getTextContent());
		browser.setAttribute("attrib", "attrib_value"); 

		
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		

	}
	
	private void addNewParamater(String name, String key, String value) {
		
	}
	

	private void modifyValue(String attributeName, String attributeValue) {
		
	}
	
	@Test
	public void tester() {
		ReportEnvironmentHelper reh = new ReportEnvironmentHelper();
	}

}
