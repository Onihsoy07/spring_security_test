package com.example.ttestt.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

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

    @Column(nullable = false, unique = false, length = 100)
    private String title;

    @Column(nullable = false, unique = false)
    @Lob
    private String content;

    @Column(nullable = false, unique = false)
    @ColumnDefault("0")
    private int viewCount;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;

}
