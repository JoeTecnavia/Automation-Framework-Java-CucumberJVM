package com.simonkay.javaframework.utility.reporting;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.xml.sax.SAXException;

public class ReportEnvironmentHelper {
	
    @Autowired
    private Environment environment;
    
	private String allureEnvironmentXmlPath;
	private File xmlFile;
	private DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder dBuilder;
    private Document doc;
    private final NamedNodeMap  server;
    private final NamedNodeMap  browser;
    private final NamedNodeMap  execution;
    
    
	public ReportEnvironmentHelper() {
		allureEnvironmentXmlPath = "src/test/resources/AllureSettings/environment.xml";
		xmlFile = new File(allureEnvironmentXmlPath);
		try {
		dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();	
        
		} catch (SAXException | ParserConfigurationException | IOException e1) {
			e1.printStackTrace();
		}
        server = doc.getElementsByTagName("qa:environment").item(0).getAttributes();
        browser = doc.getElementsByTagName("parameter").item(1).getAttributes();
        execution = doc.getElementsByTagName("parameter").item(2).getAttributes();
	}
	
	private void addNewParamater(String name, String key, String value) {
		
	}
	

	private void modifyValue(String attributeName, String attributeValue) {
		
	}
	
	@Test
	public void tester() {
		ReportEnvironmentHelper reh = new ReportEnvironmentHelper();
		System.out.println(reh.server.getNamedItem("name"));
	}

}
