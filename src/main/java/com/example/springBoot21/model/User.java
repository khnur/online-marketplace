package com.example.springBoot21.model;

import jakarta.persistence.*;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@Data // Getter, Setter, toString, EqualsAndHashCode, RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private final Long id;
    @Column(nullable = false, length = 30)
    private String phone;
    @Column(nullable = false, length = 30)
    private String password;
    @Column(nullable = false, length = 30)
    private String firstName;
    @Column(nullable = false, length = 30)
    private String lastName;
    @Column(nullable = false, length = 60)
    private String address;
}
