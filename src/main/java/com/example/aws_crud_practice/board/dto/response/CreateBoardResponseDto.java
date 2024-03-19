package com.example.aws_crud_practice.board.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateBoardResponseDto {
    String title;
    String writer;
    String contents;

    public CreateBoardResponseDto(String title, String writer, String contents) {
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }
}
