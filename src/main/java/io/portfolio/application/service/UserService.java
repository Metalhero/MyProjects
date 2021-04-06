package io.portfolio.application.service;

import io.portfolio.application.domain.Role;
import io.portfolio.application.domain.User;
import io.portfolio.application.repository.RoleRepository;
import io.portfolio.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    private String USER_ROLE="ROLE_USER";

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public void saveNewUser(User user) {
        Role userRole = roleRepository.findByRole(USER_ROLE);
        if (userRole != null)
            user.getRoles().add(userRole);
        else
            user.addRoles(USER_ROLE);

        this.save(user);
    }

    public String activateUser(String code){
        User user = userRepository.findByValidationCode(code);
        if (user == null) {
            return "noresult";
        }

        user.setActive(true);
        user.setValidationCode("");
        userRepository.save(user);
        return "ok";
    }

    public List<User> findAllByEmail(String email) {
        return userRepository.findAllByEmail(email);
    }

    public List<User> getStates() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
       return userRepository.findByUsername(username);
    }

}