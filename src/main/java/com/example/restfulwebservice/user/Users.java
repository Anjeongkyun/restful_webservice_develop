package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;


//@JsonFilter("UserInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue
    private Integer userId;

    @Size(min=2, message = "Name은 2글자 이상 입력해주세요.")
    private String userName;
    @Past
    private Date joinDate;
    private String userPassword;
    private String uesrSsn;
}
