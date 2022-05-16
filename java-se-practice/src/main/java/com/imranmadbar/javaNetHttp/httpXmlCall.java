package com.imranmadbar.javaNetHttp;

import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class httpXmlCall {

    public static HttpURLConnection connection;
    public static OutputStream out;

    public httpXmlCall() {}
    
    public static void main(String[] args) throws Exception {

        String reqBody = readXMLData("src/main/resources/requestData.xml");
        
        
        String IP = "12.161.81.12";
        String Port = "693";

        httpXmlCall conn = new httpXmlCall();
        String resp = conn.httpUCIP(IP, Port, reqBody);
        System.out.println(resp);
//        try {
//            String prettyXml = XmlPrettyPrinter.prettyPrintByTransformer(resp, 4, false);
//            System.out.println(prettyXml);
//            XmlPrettyPrinter.writeToFile(prettyXml, "src/main/output.xml");
//        } catch (Exception e) {
//            System.out.println("Response: " + resp);
//        }
    }

    public String httpUCIP(String IP, String Port, String xmldata) {

        String retValue = "-1";
        try {
            String url = String.format("http://%s:%s/Air", IP, Port);

            URL u = new URL(url);
            URLConnection uc = u.openConnection();
            HttpURLConnection connection = (HttpURLConnection) uc;
            connection.setConnectTimeout(30000);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "text/xml");
            connection.setRequestProperty("Content-Length", "" + xmldata.length());
            connection.setRequestProperty("Host", "101.174.146.15:10011");
            connection.setRequestProperty("User-Agent", "UGw Server/5.0/1.0");
            connection.setRequestProperty("Authorization", "Basic YXBpaHViOkFwIUh1QAbDFOazIwQDI=");

            OutputStream out = connection.getOutputStream();
            Writer wout = new OutputStreamWriter(out);
            wout.write(xmldata);
            wout.flush();
            wout.close();

            StringBuilder response = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    connection.getInputStream(), StandardCharsets.UTF_8));
            String line;

            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            retValue = response.toString();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retValue;
    }



    public static String readXMLData(String filename) throws IOException {
        File xmlFile = new File(filename);
        Reader fileReader = new FileReader(xmlFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder xmlData = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            xmlData.append(line).append("\n");
        }
        return xmlData.toString();
    }

}

