package com.astroTalk.service;


import com.astroTalk.entity.StaffMember;
import com.astroTalk.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StaffMemberUserDetailsService implements UserDetailsService{

    @Autowired
    private StaffMemberRepository staffMemberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(username);

        Optional<StaffMember> opt= staffMemberRepository.findByUsername(username);

        if(opt.isPresent()) {

            StaffMember staffMember= opt.get();

            List<GrantedAuthority> authorities= new ArrayList<>();
            //authorities.add(new SimpleGrantedAuthority(customer.getRole()));


            return new User(staffMember.getUsername(), staffMember.getPassword() , authorities);



        }else
            throw new BadCredentialsException("User Details not found with this username: "+username);





    }

}