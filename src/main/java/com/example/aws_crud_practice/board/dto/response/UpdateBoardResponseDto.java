package com.example.aws_crud_practice.board.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateBoardResponseDto {
    String title;
    String writer;
    String contents;

    public UpdateBoardResponseDto(String title, String writer, String contents) {
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }
}
