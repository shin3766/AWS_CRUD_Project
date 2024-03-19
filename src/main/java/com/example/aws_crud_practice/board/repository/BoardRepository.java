package com.example.aws_crud_practice.board.repository;

import com.example.aws_crud_practice.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
