package com.astroTalk.service;

import com.astroTalk.entity.StaffMember;
import com.astroTalk.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StaffMemberServiceImpl implements StaffMemberService{

    @Autowired
    StaffMemberRepository staffMemberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public StaffMember addStaff(StaffMember staffMember) {
        String hashedPassword = passwordEncoder.encode(staffMember.getPassword());
        staffMember.setPassword(hashedPassword);
        return staffMemberRepository.save(staffMember);
    }
}
