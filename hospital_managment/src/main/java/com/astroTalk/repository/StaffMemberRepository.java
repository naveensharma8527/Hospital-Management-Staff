package com.astroTalk.repository;

import com.astroTalk.entity.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StaffMemberRepository extends JpaRepository<StaffMember,Integer> {
    public Optional<StaffMember> findByUsername(String username);
}
