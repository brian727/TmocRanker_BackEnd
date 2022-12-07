package com.brian.TmocRanker.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateTmockerRequest {

    @NotNull(message = "Tmocker ID is required")
    private Long tmocker_id;
    private String firstname;
    private String lastname;
    private String email;
    private int zipcode;
}
