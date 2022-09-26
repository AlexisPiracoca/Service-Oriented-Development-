package usta.jwt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String user;
    private String pwd;
    private String token;
}
