package com.astroTalk.service;

import com.astroTalk.entity.StaffMember;
import com.astroTalk.repository.StaffMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffMemberServiceImpl implements StaffMemberService{

    @Autowired
    StaffMemberRepository staffMemberRepository;
    @Override
    public StaffMember addStaff(StaffMember staffMember) {
        return staffMemberRepository.save(staffMember);
    }
}
