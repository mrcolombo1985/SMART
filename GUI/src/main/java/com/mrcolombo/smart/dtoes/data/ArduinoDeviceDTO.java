package com.mrcolombo.smart.dtoes.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ArduinoDeviceDTO {
    private String name;
    private String description;
    private String token;
    private String ip;

    
    
    public void updatedata(ArduinoDeviceDTO dTO){
        this.setName("");
        
         if ((!"".equals(dTO.getDescription())) && (!dTO.getDescription().equals(this.getDescription())))
        {
            this.setDescription(dTO.getDescription());
        }
        else
        {
            this.setDescription("");
        }
         
          if ((!"".equals(dTO.getToken())) && (!dTO.getToken().equals(this.getToken())))
        {
            this.setToken(dTO.getToken());
        }
        else
        {
            this.setToken("");
        }
          
           if ((!"".equals(dTO.getIp())) && (!dTO.getIp().equals(this.getIp())))
        {
            this.setIp(dTO.getIp());
        }
        else
        {
            this.setIp("");
        }
       
    }

    public String[] toRow() {
        String[] res = new String[4];
        res[0] = this.name;
        res[1] = this.description;
        res[2] = this.token;
        res[3] = this.ip;
        return res;
    }
}
