package com.flong.ecommerce.user;

import com.flong.ecommerce.authentication.RegisterResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public RegisterResponseDTO toRegisterResponseDTO(User user) {
        return new RegisterResponseDTO(user.getUsername(), user.getEmail());
    }
}
