package com.mrcolombo.smart.dtoes.security;

import java.time.LocalDate;
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
public class UserDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String eMail;
    private String userName;
    private String confirmedPassword;
    private String encrytedPassword;
    private LocalDate dateOfBirth;

    
   
}

