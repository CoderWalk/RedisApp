package com.mypack.config;

import com.mypack.entity.UserInfo;
import com.mypack.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    UserInfoRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        java.util.Optional<UserInfo> userInfo =repository.findByName(username);
        return userInfo.map(UserInfoUserDetails::new)
                .orElseThrow(()-> new RuntimeException("user not found with name: "+username));
    }
}
