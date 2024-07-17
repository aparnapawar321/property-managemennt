package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity un = userConverter.convertDTOtoEntity(userDTO);
        UserEntity ue = userRepository.save(un);
        UserDTO ud = userConverter.convertEntitytoDTO(ue);
        return ud;
    }

    @Override
    public UserDTO login(String email, String password) {
        return null;
    }
}
