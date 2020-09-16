package application.dtoes.video;

import application.entities.video.CameraEntity;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class CameraDTO {

    private String name;
    private String url;
    private String title;
    private String path;
    private List<String> files = new ArrayList<>();


    public CameraDTO(CameraEntity data) {
        File pathX;
        File[] filesX;
        this.name = data.getName();
        this.url = data.getUrl();
        this.title = data.getTitle();
        this.path = data.getPath();
        pathX = new File(this.path);
        if (!pathX.exists()) {
            pathX.mkdirs();
        }
        filesX = pathX.listFiles();
        if (filesX != null) {
            Arrays.sort(filesX, new FilesComparator());
            for (File x : filesX
            ) {
                files.add(x.getName());
            }
        }
    }

    private class FilesComparator implements Comparator<File> {
        public int compare(File f1, File f2) {
            if (f1.isDirectory() && f2.isFile()) {
                return -1;
            }
            if (f1.isFile() && f2.isDirectory()) {
                return 1;
            }
            return f1.compareTo(f2);
        }
    }
}
