package com.mrcolombo.smart.dtoes.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SensorDTO {
    private String name;
    private String description;
    private String address;
    private String arduino;
    private String pin;

    public void updatedata(SensorDTO dTO){
        this.setName("");
        
         if ((!"".equals(dTO.getDescription())) && (!dTO.getDescription().equals(this.getDescription())))
        {
            this.setDescription(dTO.getDescription());
        }
        else
        {
            this.setDescription("");
        }
         
          if ((!"".equals(dTO.getAddress())) && (!dTO.getAddress().equals(this.getAddress())))
        {
            this.setAddress(dTO.getAddress());
        }
        else
        {
            this.setAddress("");
        }
          
           if ((!"".equals(dTO.getArduino())) && (!dTO.getArduino().equals(this.getArduino())))
        {
            this.setArduino(dTO.getArduino());
        }
        else
        {
            this.setArduino("");
        }
           
            if ((!"".equals(dTO.getPin())) && (!dTO.getPin().equals(this.getPin())))
        {
            this.setPin(dTO.getPin());
        }
        else
        {
            this.setPin("");
        }
    }
    
    public String[] toRow() {
        String[] res = new String[5];
        res[0] = this.name; 
        res[1] = this.arduino;
        res[2] = this.address;
        res[3] = this.pin;
        res[4] = this.description;
        return res;
    }


}
