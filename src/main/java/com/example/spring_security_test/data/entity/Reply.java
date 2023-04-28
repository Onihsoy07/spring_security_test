package com.example.spring_security_test.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "reply", schema = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Lob
    @Column(nullable = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_id")
    private Users users;


}
