package com.example.aws_crud_practice.board.controller;

import com.example.aws_crud_practice.board.dto.request.CreateBoardRequestDto;
import com.example.aws_crud_practice.board.dto.request.UpdateBoardRequestDto;
import com.example.aws_crud_practice.board.dto.response.CreateBoardResponseDto;
import com.example.aws_crud_practice.board.dto.response.GetBoardResponseDto;
import com.example.aws_crud_practice.board.dto.response.UpdateBoardResponseDto;
import com.example.aws_crud_practice.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/v1/boards")
public class BoardController {

    private final BoardService boardService;


    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody CreateBoardRequestDto req) {

        CreateBoardResponseDto res = boardService.createBoard(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable Long boardId) {

        GetBoardResponseDto res = boardService.getBoard(boardId);

        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/")
    public ResponseEntity<?> getBoards(@PathVariable Long boardId) {

        return ResponseEntity.ok().body(null);
    }

    @PatchMapping("/{boardId}")
    public ResponseEntity<?> updateBoard(@PathVariable Long boardId,
                                         @RequestBody UpdateBoardRequestDto req) {

        UpdateBoardResponseDto res = boardService.updateBoard(boardId, req);

        return ResponseEntity.ok().body(res);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBoard() {
        return ResponseEntity.ok().body(null);
    }
}
