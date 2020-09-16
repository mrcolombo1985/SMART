/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcolombo.smart.provider.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrcolombo.smart.MainFrame;
import com.mrcolombo.smart.configuration.GeneralOptions;
import com.mrcolombo.smart.dtoes.data.OptionDTO;
import com.mrcolombo.smart.dtoes.video.CameraDTO;
import com.sun.net.httpserver.Headers;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
public class OptionProvider {

    final HttpMethod GET = HttpMethod.GET;
    final HttpMethod POST = HttpMethod.POST;
    final HttpMethod PUT = HttpMethod.PUT;
    final HttpMethod DELETE = HttpMethod.DELETE;
    RequestEntity<?> request;
    RequestEntity<OptionDTO> requestO;
    ResponseEntity<String> responseS;
    ResponseEntity<OptionDTO> responseO;
    RestTemplate restTemplate = new RestTemplate();
    public List<OptionDTO> fromServer() throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION));
        responseS = restTemplate.exchange(request, String.class);
        //System.out.println(responseS.getBody().length());
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(responseS.getBody(), OptionDTO[].class));
}
    
    public void update(String name, OptionDTO dTO){
        try {
            //TODO
            //System.out.println("for update dto name =>" + name + " => data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, PUT , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION+"?name="+name));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(OptionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void add(OptionDTO dTO){
        try {
            //TODO
            //System.out.println("for add dto data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, POST , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(OptionProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
     public List<OptionDTO> fromServerByDeviceName(String device) throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION+"?device.nameDevice="+device));
        responseS = restTemplate.exchange(request, String.class);
        //System.out.println(responseS.getBody().length());
        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(responseS.getBody(), OptionDTO[].class));
}
     
     public OptionDTO fromServerByName(String option) throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION+"?nameOption="+option));
        responseS = restTemplate.exchange(request, String.class);
        //System.out.println(responseS.getBody());
         ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(responseS.getBody(), OptionDTO[].class)[0];
}
     
     public void deleteByName(String option) throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, DELETE , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION+"?option="+option));
        restTemplate.exchange(request, String.class);
}
     
     public void deleteByDevice(String device) throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, DELETE , new URI(GeneralOptions.URL+GeneralOptions.URNOPTION+"?device="+device));
        restTemplate.exchange(request, String.class);
}
     
    public void load(JTable jTable, String device){
    try {
                        DefaultTableModel model;
                        model = (DefaultTableModel) jTable.getModel();
                        model.setRowCount (0);
                        jTable.setToolTipText(device);
                        try {
                            if (device.equals("")){
                                //System.out.println("!!!! null");
                                fromServer().forEach(x->{
                                            
                                String[] row = x.toRow();
                            model.addRow(row);
                            });
                            }
                            if (!device.equals("")){
                                //System.out.println("!!!! not null  " + device); 
                                fromServerByDeviceName(device).forEach(x->{
                 
                                String[] row = x.toRow();
                            model.addRow(row);
                            });
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } catch (URISyntaxException ex) {
                        Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }  
    }
}
