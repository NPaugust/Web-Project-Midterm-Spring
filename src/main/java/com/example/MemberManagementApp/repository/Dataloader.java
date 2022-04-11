package com.example.MemberManagementApp.repository;

import com.example.MemberManagementApp.model.Member;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
class DataLoader {
    private final MemberRepository repository;

    public DataLoader(MemberRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void loadData() {
        repository.saveAll(List.of(
                new Member("1", "Ruslan", "Isaev", "Present"),
                new Member("2", "Avgustine", "Chynarbekov", "Absent"),
                new Member("3", "Erkhan", "Adenov", "Present"),
                new Member("3", "Adil", "Ismailov", "Absent"),
                new Member("5","Abdulaaziz", "Talantbekov", "Present")
        ));
    }
}