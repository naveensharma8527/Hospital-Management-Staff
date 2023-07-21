package com.astroTalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationProviderStaff implements AuthenticationProvider {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    StaffMemberUserDetailsService staffMemberUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(authentication == null){
            throw new BadCredentialsException("Bad request");
        }
        UserDetails userDetails = staffMemberUserDetailsService.loadUserByUsername(authentication.getName());
        boolean checkPass =  passwordEncoder.matches(authentication.getCredentials().toString() ,userDetails.getPassword() );

        if(!checkPass){
            throw new BadCredentialsException("Bad request");
        }

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),null);
    }

    @Override
    public boolean supports(Class<?> authentication) {

        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
