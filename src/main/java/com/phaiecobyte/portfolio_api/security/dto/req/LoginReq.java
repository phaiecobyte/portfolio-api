package com.phaiecobyte.portfolio_api.security.dto.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginReq {
    @NotNull
    @NotBlank
    private String username;

    @NotBlank
    @NotNull
    private String password;
}
