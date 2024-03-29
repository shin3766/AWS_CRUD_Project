package com.example.aws_crud_practice.board.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateBoardRequestDto {
    String title;
    String writer;
    String contents;
    String password;

    public UpdateBoardRequestDto(String title, String writer, String contents, String password) {
        this.title = title;
        this.writer = writer;
        this.contents = contents;
        this.password = password;
    }
}
