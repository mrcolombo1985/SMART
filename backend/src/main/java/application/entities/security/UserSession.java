package application.entities.security;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Slf4j
@Getter
@Entity
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user_session")
public class UserSession {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String userName;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "isValid", nullable = false)
    private Boolean isValid;

    @Column(name = "ip", nullable = false)
    private String ip;

    @Column(name = "useragent", nullable = false)
    private String userAgent;

    @Column(name = "datebegin", nullable = false)
    private LocalDate localDateBegin;

    @Column(name = "timebegin", nullable = false)
    private LocalTime localTimeBegin;

    @Column(name = "dateend", nullable = true)
    private LocalDate localDateEnd;

    @Column(name = "timeend", nullable = true)
    private LocalTime localTimeEnd;

}
