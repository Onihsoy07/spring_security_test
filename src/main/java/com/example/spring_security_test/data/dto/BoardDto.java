package com.example.spring_security_test.data.dto;

import com.example.spring_security_test.data.entity.Reply;
import com.example.spring_security_test.data.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {

    private Long id;

    private String title;

    private String content;

    private int viewCount;

    private Users users;

    private List<Reply> replyList;

}
