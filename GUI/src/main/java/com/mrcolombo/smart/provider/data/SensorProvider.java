/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcolombo.smart.provider.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrcolombo.smart.MainFrame;
import com.mrcolombo.smart.configuration.GeneralOptions;
import com.mrcolombo.smart.dtoes.data.DeviceDTO;
import com.mrcolombo.smart.dtoes.data.SensorDTO;
import com.mrcolombo.smart.dtoes.data.ValueEntity;
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
public class SensorProvider {
    final HttpMethod GET = HttpMethod.GET;
    final HttpMethod POST = HttpMethod.POST;
    final HttpMethod PUT = HttpMethod.PUT;
    final HttpMethod DELETE = HttpMethod.DELETE;
    RequestEntity<?> request;
    ResponseEntity<String> responseS;
    RestTemplate restTemplate = new RestTemplate();
   
    public List<SensorDTO> fromServer() throws URISyntaxException, IOException{
        //System.out.println("Hello Sensor!!!!!");
                    Headers headers = new Headers();
                    headers.add("Authorization", MainFrame.token);
                    request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNSENSOR));
                    responseS = restTemplate.exchange(request, String.class);
                   //System.out.println(responseS.getBody().length());
                    ObjectMapper mapper = new ObjectMapper();
                    return Arrays.asList(mapper.readValue(responseS.getBody(), SensorDTO[].class));
    }
    
    public List<ValueEntity> fromServerValueBySensor(String mac) throws URISyntaxException, IOException{
                    Headers headers = new Headers();
                    headers.add("Authorization", MainFrame.token);
                    request = new RequestEntity(headers, GET , new URI(GeneralOptions.URLVALUE + "?sensor.macAddress=" + mac));
                    responseS = restTemplate.exchange(request, String.class);
                   System.out.println(responseS.getBody());
                    ObjectMapper mapper = new ObjectMapper();
                    return Arrays.asList(mapper.readValue(responseS.getBody(), ValueEntity[].class));
    }
    
    public SensorDTO fromServerByName(String name) throws URISyntaxException, IOException{
        //System.out.println("Hello Sensor!!!!!");
                    Headers headers = new Headers();
                    headers.add("Authorization", MainFrame.token);
                    request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNSENSOR+"?nameSensor="+name));
                    responseS = restTemplate.exchange(request, String.class);
                   //System.out.println(responseS.getBody().length());
                    ObjectMapper mapper = new ObjectMapper();
                    return mapper.readValue(responseS.getBody(), SensorDTO[].class)[0];
    }
    
    public void update(String name, SensorDTO dTO){
        try {
            //TODO
            //System.out.println("for update dto name =>" + name + " => data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, PUT , new URI(GeneralOptions.URL+GeneralOptions.URNDEVICE+"?name="+name));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(DeviceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void add(SensorDTO dTO){
        try {
            //TODO
            //System.out.println("for add dto data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, POST , new URI(GeneralOptions.URL+GeneralOptions.URNDEVICE));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(DeviceProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     public void deleteByName(String sensor) throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, DELETE , new URI(GeneralOptions.URL+GeneralOptions.URNDEVICE+"?name="+sensor));
        restTemplate.exchange(request, String.class);
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
