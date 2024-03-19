package com.example.aws_crud_practice.board.repository;

import com.example.aws_crud_practice.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board> findById(Long BoardId);
}
