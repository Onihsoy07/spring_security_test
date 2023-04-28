package com.example.spring_security_test.data.entity;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users", schema = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "userId")})
public class Users extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long userId;

    @Column(nullable = false, unique = true, length = 30)
    private String username;

    @Column(nullable = false, unique = false, length = 200)
    private String password;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Board> boardList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Reply> replyList = new ArrayList<>();
}
