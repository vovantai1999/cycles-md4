package com.cg.service.user;

import com.cg.model.User;
import com.cg.model.UserPrinciple;
import com.cg.model.dto.UserDTO;
import com.cg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public Optional<UserDTO> findUserDTOByUsername(String username) {
        return userRepository.findUserDTOByUsername(username);
    }

    @Override
    public Optional<UserDTO> findUserById(Long id) {
        return userRepository.findUserById(id);
    }


    @Override
    public List<UserDTO> findAllUserDTOByDeletedIsFailse() {
        return userRepository.findAllUserDTOByDeletedIsFalse();
    }

    @Override
    public List<UserDTO> findUserDTOByRoleIdAndDeletedIsFalse(Long id) {
        return userRepository.findUserDTOByRoleIdAndDeletedIsFalse(id);
    }


    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        return UserPrinciple.build(userOptional.get());
    }
    @Override
    public void softDelete(User user) {

    }

}

