package com.example.spring_security_test.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "board", schema = "test", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = false, length = 100, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    private String title;

    @Column(nullable = false, unique = false, columnDefinition = "VARCHAR(255) CHARACTER SET UTF8")
    @Lob
    private String content;

    @Column(nullable = false, unique = false)
    @ColumnDefault("0")
    private int viewCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private Users users;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @OrderBy("createdDate Desc")
    @JsonIgnoreProperties({"board", "users"})
    private List<Reply> replyList;

}
