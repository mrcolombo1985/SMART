package application.entities.video;

import application.dtoes.video.CameraDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Table(name = "camera")
@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CameraEntity {
    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "path")
    private String path;

    public CameraEntity(CameraDTO data) {
        this.name = data.getName();
        this.url = data.getUrl();
        this.title = data.getTitle();
        this.path = data.getPath();
    }

}
