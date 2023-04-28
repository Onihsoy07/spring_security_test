package com.example.spring_security_test.data.repository;

import com.example.spring_security_test.data.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    List<Reply> findByBoard_IdOrderByCreatedDateAsc(Long id);

}
