package com.imranmadbar;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class WebServiceClient {

    public static void main(String[] args) throws IOException {
        String responseString = "";
        String outputString = "";
        String wsEndPoint = "http://ExampleURLForSMS.svc";
        URL url = new URL(wsEndPoint);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConn = (HttpURLConnection) connection;
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        String xmlInput =
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://xyz.org/\" xmlns:cbs=\"http://schemas.xyz.org/2004/07/EXAMPLE\">" +
                        "<soapenv:Header/>" +
                        "<soapenv:Body>" +
                        "<tem:QuickSMS>" +
                        "<tem:obj_QuickSMS>" +
                        "<cbs:loginId>123</cbs:loginId>" +
                        "<cbs:loginPassword>123</cbs:loginPassword>" +
                        "<cbs:Destination>123</cbs:Destination>" +
                        "<cbs:Mask>abc</cbs:Mask>" +
                        "<cbs:Message>I am testing SMS</cbs:Message>" +
                        "<cbs:UniCode>0</cbs:UniCode>" +
                        "<cbs:ShortCodePrefered>n</cbs:ShortCodePrefered>" +
                        "</tem:obj_QuickSMS>" +
                        "</tem:QuickSMS>" +
                        "</soapenv:Body>" +
                        "</soapenv:Envelope>";
        byte[] buffer = new byte[xmlInput.length()];
        buffer = xmlInput.getBytes();
        bout.write(buffer);
        byte[] b = bout.toByteArray();
        String SOAPAction = "http://xyz.org/abc/SMS";
        httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
        httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        httpConn.setRequestProperty("SOAPAction", SOAPAction);
        httpConn.setRequestMethod("POST");
        httpConn.setDoOutput(true);
        httpConn.setDoInput(true);
        OutputStream out = httpConn.getOutputStream();
        out.write(b);
        out.close();
        InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(), Charset.forName("UTF-8"));
        BufferedReader in = new BufferedReader(isr);
        while ((responseString = in.readLine()) != null) {
            outputString = outputString + responseString;
        }
        String formattedSOAPResponse = formatXML(outputString);
        System.out.println("Response: " + formattedSOAPResponse);
    }

    private static String formatXML(String unformattedXml) {
        try {
            Document document = parseXmlFile(unformattedXml);
            NodeList nodeList = document.getElementsByTagName("QuickSMSResult");
            return nodeList.item(0).getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Document parseXmlFile(String in) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(in));
            return db.parse(is);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            throw new RuntimeException(e);
        }
    }
}