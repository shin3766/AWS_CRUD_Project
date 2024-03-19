package com.example.aws_crud_practice.board.service;

import com.example.aws_crud_practice.board.dto.request.CreateBoardRequestDto;
import com.example.aws_crud_practice.board.dto.response.CreateBoardResponseDto;
import com.example.aws_crud_practice.board.entity.Board;
import com.example.aws_crud_practice.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public CreateBoardResponseDto createBoard(CreateBoardRequestDto req) {
        String title = req.getTitle();
        String writer = req.getWriter();
        String contents = req.getContents();

        Board board = Board.builder()
                .title(title)
                .writer(writer)
                .contents(contents)
                .build();

        boardRepository.save(board);

        return CreateBoardResponseDto.builder()
                .title(title)
                .writer(writer)
                .contents(contents)
                .build();
    }
}
