package com.phaiecobyte.portfolio_api.security.service;

import com.phaiecobyte.portfolio_api.exception.AppException;
import com.phaiecobyte.portfolio_api.security.dto.req.SignupReq;
import com.phaiecobyte.portfolio_api.security.dto.res.AuthRes;
import com.phaiecobyte.portfolio_api.security.mapper.UserMapper;
import com.phaiecobyte.portfolio_api.security.model.TCoreRole;
import com.phaiecobyte.portfolio_api.security.model.TCoreUsr;
import com.phaiecobyte.portfolio_api.security.repository.RoleRepository;
import com.phaiecobyte.portfolio_api.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SignupService {
        private final UserRepository userRepository;
        private final RoleRepository roleRepository;
        private final UserMapper userMapper;
        private final PasswordEncoder passwordEncoder;

        public AuthRes signUp(SignupReq req) throws AppException {
        TCoreUsr usr = userMapper.toEntity(req);
        if(userRepository.findByUsername(req.getUsername()).isPresent()){
            throw new AppException("Username is already exist");
        }

        usr.setUsername(req.getUsername());
        usr.setEmail(req.getEmail());
        usr.setPassword(passwordEncoder.encode(req.getPassword()));

        TCoreRole userRole = roleRepository.findByName("USER")
                .orElseThrow(()-> new AppException("Error: Default Role is not found...!"));

        usr.setRoles(Set.of(userRole));

        TCoreUsr saved = userRepository.save(usr);

        return userMapper.toRes(saved);
    }
}
