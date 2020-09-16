package com.mrcolombo.smart.dtoes.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeviceDTO {
    private String name;
    private String description;
    private String pin;
    private String arduino;


    public void updatedata(DeviceDTO dTO){
        this.setName("");
        
         if ((!"".equals(dTO.getDescription())) && (!dTO.getDescription().equals(this.getDescription())))
        {
            this.setDescription(dTO.getDescription());
        }
        else
        {
            this.setDescription("");
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
        String[] res = new String[4];
        res[0] = this.name;
        res[1] = this.description;
        res[3] = this.pin;
        res[2] = this.arduino;
        return res;
    }
    

    

}
