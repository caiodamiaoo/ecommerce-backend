package com.flong.ecommerce.user;

import com.flong.ecommerce.role.Role;
import com.flong.ecommerce.role.RoleService;
import com.flong.ecommerce.userrole.UserRole;
import com.flong.ecommerce.userrole.UserRoleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserRoleService userRoleService;

    @Transactional
    public Optional<User> createUser(String name, String email, String password, String roleName) {
        Role role = roleService.findByName(roleName);
        User user = new User(name, email, password, roleName, LocalDateTime.now(), LocalDateTime.now());
        userRoleService.save(new UserRole(user, role));
        return Optional.of(userRepository.save(user));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
