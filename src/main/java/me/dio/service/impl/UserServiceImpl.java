package me.dio.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository UserRepository;

    public UserServiceImpl(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public User findById(Long id) {
        return UserRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    
    @Override
    public User create(User userToCreate) {
        if (UserRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account already exists.");
        }
        return UserRepository.save(userToCreate);
    }

}
