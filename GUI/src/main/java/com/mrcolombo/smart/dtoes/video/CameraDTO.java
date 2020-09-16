package com.mrcolombo.smart.dtoes.video;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CameraDTO {

    private String name;
    private String url;
    private String title;
    private String path;
    private List<String> files = new ArrayList<>();
    
    


    public void updatedata(CameraDTO dTO){
        this.setName("");
        
         if ((!"".equals(dTO.getPath())) && (!dTO.getPath().equals(this.getPath())))
        {
            this.setPath(dTO.getPath());
        }
        else
        {
            this.setPath("");
        }
         
          if ((!"".equals(dTO.getTitle())) && (!dTO.getTitle().equals(this.getTitle())))
        {
            this.setTitle(dTO.getTitle());
        }
        else
        {
            this.setTitle("");
        }
          
           if ((!"".equals(dTO.getUrl())) && (!dTO.getUrl().equals(this.getUrl())))
        {
            this.setUrl(dTO.getUrl());
        }
        else
        {
            this.setUrl("");
        }
       
    }
    
    public String[] toRow() {
        String[] res = new String[4];
        res[0] = this.name;
        res[1] = this.url;
        res[2] = this.title;
        res[3] = this.path;
        return res;
    }

}
