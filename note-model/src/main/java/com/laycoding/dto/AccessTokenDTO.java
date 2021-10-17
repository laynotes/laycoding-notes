package com.laycoding.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class AccessTokenDTO implements Serializable {

    private Integer id;

    private String username;

    private String email;

    private String phone;

    private String avatar;

    private String refreshToken;

    private String token;
}
