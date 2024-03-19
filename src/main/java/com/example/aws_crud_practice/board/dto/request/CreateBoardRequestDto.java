package com.example.aws_crud_practice.board.dto.request;

import lombok.Getter;

@Getter
public class CreateBoardRequestDto {
    String title;
    String writer;
    String contents;
}
