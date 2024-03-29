package com.example.aws_crud_practice.board.entity;

import com.example.aws_crud_practice.board.dto.request.UpdateBoardRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private String title;

    @Column
    private String writer;

    @Column
    private String contents;

    @Column
    private String password;

    LocalDateTime createdAt;

    @Builder
    private Board(Long Id, String title, String password , String writer, String contents) {
        this.Id = Id;
        this.title = title;
        this.password = password;
        this.writer = writer;
        this.contents = contents;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String title, String writer, String contents) {
        if (!title.isEmpty()) {
            this.title = title;
        }
        if (!writer.isEmpty()) {
            this.writer = writer;
        }
        if (!contents.isEmpty()) {
            this.contents = contents;
        }
    }
}
