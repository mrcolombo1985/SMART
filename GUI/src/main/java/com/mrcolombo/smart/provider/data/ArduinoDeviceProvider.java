/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcolombo.smart.provider.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrcolombo.smart.MainFrame;
import com.mrcolombo.smart.configuration.GeneralOptions;
import com.mrcolombo.smart.dtoes.data.ArduinoDeviceDTO;
import com.sun.net.httpserver.Headers;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author serg
 */
public class ArduinoDeviceProvider {
    final HttpMethod GET = HttpMethod.GET;
    final HttpMethod POST = HttpMethod.POST;
    final HttpMethod PUT = HttpMethod.PUT;
    final HttpMethod DELETE = HttpMethod.DELETE;
    RequestEntity<?> request;
    ResponseEntity<String> responseS;
    RestTemplate restTemplate = new RestTemplate();
public List<ArduinoDeviceDTO> fromServer() throws URISyntaxException, IOException{
    //System.out.println("Hello Arduino!!!!!");
    Headers headers = new Headers();
    headers.add("Authorization", MainFrame.token);
    request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNARDUINO));
    responseS = restTemplate.exchange(request, String.class);
    ObjectMapper mapper = new ObjectMapper();
    return Arrays.asList(mapper.readValue(responseS.getBody(), ArduinoDeviceDTO[].class));
}

public ArduinoDeviceDTO fromServerByName(String arduino){
        try {
            //System.out.println("Hello Arduino!!!!!");
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNARDUINO+"?name="+ arduino));
            responseS = restTemplate.exchange(request, String.class);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseS.getBody(), ArduinoDeviceDTO[].class)[0];
        } catch (URISyntaxException ex) {
            Logger.getLogger(ArduinoDeviceProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArduinoDeviceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}

public void deleteByName(String arduino) throws IOException, URISyntaxException{
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, DELETE , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION+"?name="+arduino));
        restTemplate.exchange(request, String.class);
}

public void update(String name, ArduinoDeviceDTO dTO){
        try {
            //TODO
            //System.out.println("for update dto name =>" + name + " => data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, PUT , new URI(GeneralOptions.URL+GeneralOptions.URNARDUINO+"?name="+name));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(OptionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

public void add(ArduinoDeviceDTO dTO){
        try {
            //TODO
            //System.out.println("for add dto data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, POST , new URI(GeneralOptions.URL+GeneralOptions.URNARDUINO));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(ArduinoDeviceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void load(JTable jTable){
    try {
                    DefaultTableModel model;
                    model = (DefaultTableModel) jTable.getModel();
                    try {
                        fromServer().forEach(x->{
                            //System.out.println(x.toString());
                            String[] row = x.toRow();
                            model.addRow(row);
                        });
                    } catch (IOException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (URISyntaxException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
}
