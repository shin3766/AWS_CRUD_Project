package com.example.aws_crud_practice.board.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetAllBoardResponseDto {
    String title;
    String writer;

    public GetAllBoardResponseDto(String title, String writer) {
        this.title = title;
        this.writer = writer;
    }
}
