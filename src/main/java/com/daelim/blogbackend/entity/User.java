package com.daelim.blogbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import java.sql.Timestamp;

@Data
@DynamicInsert
//@ToString
@Entity
public class User {
    @Id
    private String userId;
    private String userName;
    private String password;
    private Timestamp regDate;
}
