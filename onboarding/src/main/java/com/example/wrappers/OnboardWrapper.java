package com.example.wrappers;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OnboardWrapper {

    private String userId;
    private String role;
    private String onboardName;
    private String onboardEmail;
    private String panId;
    private Date dateOfBirth;
    private Date dateOfIncorporation;
    private String accountHolderName;
    private String accountNumber;
    private String ifscCode;
}