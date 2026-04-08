package com.phaiecobyte.portfolio_api.security.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRes {
    private String username;
    private String email;
}
