package com.fdmgroup;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {

	private InputStream input;

	public XMLReader(InputStream input) {
		
		this.input = input;
	}
	
	public BigDecimal getConversionRate(String countryCode) {

		String strAmount = "0";
		BigDecimal amount;

		Document w3cDocument = null;

		w3cDocument = createXMLDocument();

		NodeList list = w3cDocument.getElementsByTagName("Cube");
		
		strAmount = getRateFromNodeList(list, countryCode);

		amount = new BigDecimal(strAmount);

		return amount;
	}

	public Document createXMLDocument() {

		Document w3cDocument = null;

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			w3cDocument = documentBuilder.parse(input);

		} catch (IOException | SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}

		return w3cDocument;
	}

	public String getRateFromNodeList(NodeList list, String countryCode) {
		
		String strAmount = null;
		
		for (int i = 0; i < list.getLength(); i++) {

			Node node = list.item(i);

			if (node.hasAttributes()) {

				NamedNodeMap nodeAttributes = node.getAttributes();
				Node currencyAtt = nodeAttributes.getNamedItem("currency");

				if (currencyAtt == null)continue;

				if (currencyAtt.getNodeValue().equalsIgnoreCase(countryCode)) {
					strAmount = nodeAttributes.getNamedItem("rate").getNodeValue();
					break;
				}
			}
		}
		
		return strAmount;
	}

}
