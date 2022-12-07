package com.brian.TmocRanker.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class CreateTmockerRequest {
    @NotBlank(message = "Name needed")
    private String firstname;
    private String lastname;
    private String email;
    private int zipcode;
}
