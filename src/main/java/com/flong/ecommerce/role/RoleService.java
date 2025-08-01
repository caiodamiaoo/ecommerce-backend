package com.flong.ecommerce.role;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    public Role save(Role role) {
        return null;
    }

    public Role findById(Long id) {
        return null;
    }

    public void deleteById(Long id) {

    }
}
