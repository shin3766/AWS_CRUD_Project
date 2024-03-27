package com.example.aws_crud_practice.board.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetBoardResponseDto {
    Long id;
    String title;
    String writer;
    String contents;

    public GetBoardResponseDto(Long id, String title, String writer, String contents) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.contents = contents;
    }
}
