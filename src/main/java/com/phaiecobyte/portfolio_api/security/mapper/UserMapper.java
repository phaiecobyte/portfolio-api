package com.phaiecobyte.portfolio_api.security.mapper;

import com.phaiecobyte.portfolio_api.security.dto.req.SignupReq;
import com.phaiecobyte.portfolio_api.security.dto.res.AuthRes;
import com.phaiecobyte.portfolio_api.security.model.TCoreUsr;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    TCoreUsr toEntity(SignupReq dto);
    AuthRes toRes(TCoreUsr entity);
    void updateEntity(@MappingTarget TCoreUsr entity, SignupReq req);
}
