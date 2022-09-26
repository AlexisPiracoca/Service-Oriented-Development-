package com.usta.jwtdemo.service;

import com.usta.jwtdemo.entity.Usuario;
import com.usta.jwtdemo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UsuarioRepository iUsuarioDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(@RequestBody String userName) throws UsernameNotFoundException {

        Usuario us = iUsuarioDao.findByUsername(userName);
        String username = us.getUsername();
        String passwo = us.getPassword();
        //Logic to get the user form the Database

        return new User(username,passwo,new ArrayList<>());
    }

}
