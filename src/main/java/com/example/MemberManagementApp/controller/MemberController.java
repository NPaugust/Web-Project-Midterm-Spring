package com.example.MemberManagementApp.controller;

import com.example.MemberManagementApp.model.Member;
import com.example.MemberManagementApp.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.apache.tomcat.jni.Mmap.delete;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository repository;


    @GetMapping
    public String getMembers(Model model){
        List<Member> members = new ArrayList<>();
        Iterable<Member> foundMembers = repository.findAll();
        foundMembers.forEach(members::add);

        model.addAttribute("members", members);
        model.addAttribute("member", new Member());
        return "members_page";
    }

    @GetMapping("/{id}")
    Optional<Member> getMemberById(@PathVariable String id){
        return repository.findById(id);
    }

    @PostMapping("/addMember")
    String postMember(@ModelAttribute Member member){
        System.out.println("member received is: " + member);
        repository.save(member);

        return "redirect:/members";
    }

    @PutMapping("/{id}")
    ResponseEntity<Member> updateMemberById(@PathVariable String id,
                                            @RequestBody Member member){
        return (repository.existsById(id)) ?
                new ResponseEntity<>(repository.save(member), HttpStatus.OK):
                new ResponseEntity<>(repository.save(member), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteMember/{memberId}")
    public ResponseEntity<Long> deleteMember(@PathVariable(value = "id") Long memberID) {
        return ResponseEntity.ok(memberID);
    }
    }

