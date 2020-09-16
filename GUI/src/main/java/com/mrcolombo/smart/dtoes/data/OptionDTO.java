package com.mrcolombo.smart.dtoes.data;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OptionDTO {
    private String name;
    private String type; // 1Time 2Sensor
    private String ifType; // 0= 1< 2>
    private String sensorName;
    private String deviceName;
    private String date;
    private String time;
    private String data;
    private String description;

   

    public void updatedata(OptionDTO dTO){
        //TODO проверка изменений данных. если есть изменения, то поле равно измененному значению. иначе - оно равно пустой строке
        this.setName("");
        if ((dTO.getDeviceName() != "") && (!dTO.getDeviceName().equals(this.deviceName)))
        {
            this.deviceName = dTO.deviceName;
        }
        else
        {
            this.deviceName = "";
        }
        
        if ((dTO.getSensorName()!= "") && (!dTO.getSensorName().equals(this.sensorName)))
        {
            this.sensorName = dTO.sensorName;
        }
        else
        {
            this.sensorName = "";
        }
        
        if ((dTO.getData()!= "") && (!dTO.getData().equals(this.data)))
        {
            this.data = dTO.data;
        }
        else
        {
            this.data = "";
        }
        
        if ((dTO.getDescription()!= "") && (!dTO.getDescription().equals(this.description)))
        {
            this.description = dTO.description;
        }
        else
        {
            this.description = "";
        }
        
        //if ((dTO.getIfType()!= "") && (!dTO.getIfType().equals(this.getIfType())))
        //{
        //    this.setIfType(dTO.getIfType());
        //}
        //else
        //{
        //    this.setIfType("");
        //}
        
        //if ((dTO.getType()!= "") && (!dTO.getType().equals(this.getType())))
        //{
        //    this.setType(dTO.getType());
        //}
       // else
        //{
        //    this.setType("");
        //}
        
        if ((dTO.getDate()!= "") && (!dTO.getDate().equals(this.getDate())))
        {
            this.setDate(dTO.getDate());
        }
        else
        {
            this.setDate("");
        }
        
        if ((dTO.getTime()!= "") && (!dTO.getTime().equals(this.getTime())))
        {
            this.setTime(dTO.getTime());
        }
        else
        {
            this.setTime("");
        }
    }
    
    

    public String[] toRow() {
        String[] res = new String[8];
        res[0] = this.name;
        if (this.type.equals("0")) res[1] = "Sensor";
        if (this.type.equals("1")) res[1] = "Time";
        if (this.ifType.equals("0")) res[2] = "<";
        if (this.ifType.equals("1")) res[2] = "=";
        if (this.ifType.equals("2")) res[2] = ">";
        res[3] = this.sensorName;
        res[4] = this.date;
        res[5] = this.time;
        res[6] = this.data;
        res[7] = this.description;
        return res;
    }

}
