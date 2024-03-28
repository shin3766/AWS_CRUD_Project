package com.example.aws_crud_practice.board.service;

import com.example.aws_crud_practice.board.dto.request.CreateBoardRequestDto;
import com.example.aws_crud_practice.board.dto.request.UpdateBoardRequestDto;
import com.example.aws_crud_practice.board.dto.response.CreateBoardResponseDto;
import com.example.aws_crud_practice.board.dto.response.GetAllBoardResponseDto;
import com.example.aws_crud_practice.board.dto.response.GetBoardResponseDto;
import com.example.aws_crud_practice.board.dto.response.UpdateBoardResponseDto;
import com.example.aws_crud_practice.board.entity.Board;
import com.example.aws_crud_practice.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public GetBoardResponseDto getBoard(Long boardId) {
        Board board = findBoardById(boardId);

        return GetBoardResponseDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .writer(board.getWriter())
                .contents(board.getContents())
                .build();
    }

    private Board findBoardById(Long boardId) {

        return boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID입니다."));
    }

    public UpdateBoardResponseDto updateBoard(Long boardId, UpdateBoardRequestDto req) {
        Board board = findBoardById(boardId);
        board.update(req);
        boardRepository.save(board);
        return UpdateBoardResponseDto.builder()
                .title(req.getTitle())
                .writer(req.getWriter())
                .contents(req.getContents())
                .build();
    }

    public List<GetAllBoardResponseDto> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards.stream()
                .map(board -> new GetAllBoardResponseDto(board.getTitle(), board.getWriter()))
                .collect(Collectors.toList());
    }
}
