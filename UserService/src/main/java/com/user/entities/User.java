package com.user.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "User")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @Column(name = "Id")
    private String userId;

    private String name;

    private String email;
    private String about;

    @Transient
    private List<Rating> ratings=new ArrayList<>();

}
