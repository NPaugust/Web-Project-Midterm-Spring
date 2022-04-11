package com.example.MemberManagementApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.sql.Delete;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.swing.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    private String memberId;
    private String name, surname;

    private String included;



    }


