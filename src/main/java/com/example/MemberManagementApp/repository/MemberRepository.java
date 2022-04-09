package com.example.MemberManagementApp.repository;

import com.example.MemberManagementApp.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {}
