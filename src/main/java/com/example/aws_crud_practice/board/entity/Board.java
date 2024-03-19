package com.example.aws_crud_practice.board.entity;

import com.example.aws_crud_practice.board.dto.request.UpdateBoardRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Builder
    private Board(Long Id, String title, String writer, String contents) {
        this.Id = Id;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }

    public void update(UpdateBoardRequestDto req) {
        if (!req.getTitle().isEmpty()) this.title = req.getTitle();
        if (!req.getWriter().isEmpty()) this.writer = req.getWriter();
        if (!req.getContents().isEmpty()) this.contents = req.getContents();
    }
}
