/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mrcolombo.smart.provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrcolombo.smart.MainFrame;
import com.mrcolombo.smart.configuration.GeneralOptions;
import com.mrcolombo.smart.dtoes.video.CameraDTO;
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
public class CameraProvider {

    final HttpMethod GET = HttpMethod.GET;
    final HttpMethod POST = HttpMethod.POST;
    final HttpMethod PUT = HttpMethod.PUT;
    final HttpMethod DELETE = HttpMethod.DELETE;
    RequestEntity<?> request;
    ResponseEntity<String> responseS;
    RestTemplate restTemplate = new RestTemplate();
  public List<CameraDTO> fromServer() throws IOException, URISyntaxException{
    //System.out.println("Hello Camera!!!!!");
                        Headers headers = new Headers();
                    headers.add("Authorization", MainFrame.token);
                        request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNCAMERA));
                        responseS = restTemplate.exchange(request, String.class);
                        //System.out.println(responseS.getBody().length());
                        ObjectMapper mapper = new ObjectMapper();
                        return Arrays.asList(mapper.readValue(responseS.getBody(), CameraDTO[].class));
}
  
    public CameraDTO fromServerByName(String name) throws IOException, URISyntaxException{
    //System.out.println("Hello Camera!!!!!");
                        Headers headers = new Headers();
                    headers.add("Authorization", MainFrame.token);
                        request = new RequestEntity(headers, GET , new URI(GeneralOptions.URL+GeneralOptions.URNCAMERA+"?name="+name));
                        responseS = restTemplate.exchange(request, String.class);
                        //System.out.println(responseS.getBody().length());
                        ObjectMapper mapper = new ObjectMapper();
                        return mapper.readValue(responseS.getBody(), CameraDTO[].class)[0];
}
    
    public void add(CameraDTO dTO){
        try {
            //TODO
            //System.out.println("for add dto data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, POST , new URI(GeneralOptions.URL+GeneralOptions.URNCAMERA));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CameraProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteByName(String camera) throws IOException, URISyntaxException{
        //System.out.println("Hello Camera!!!!!");
        Headers headers = new Headers();
        headers.add("Authorization", MainFrame.token);
        request = new RequestEntity(headers, DELETE , new URI(GeneralOptions.URL+GeneralOptions.URNCAMERA+"?name="+camera));
        restTemplate.exchange(request, String.class);
}

public void update(String name, CameraDTO dTO){
        try {
            //TODO
            //System.out.println("for update dto name =>" + name + " => data => " + dTO.toString());
            Headers headers = new Headers();
            headers.add("Authorization", MainFrame.token);
            request = new RequestEntity(dTO, PUT , new URI(GeneralOptions.URL+GeneralOptions.URNCAMERA+"?name="+name));
            responseS = restTemplate.exchange(request, String.class);
        } catch (URISyntaxException ex) {
            Logger.getLogger(CameraProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void load(JTable jTable, String token){
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
