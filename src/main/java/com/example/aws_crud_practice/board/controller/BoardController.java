package com.example.aws_crud_practice.board.controller;

import com.example.aws_crud_practice.board.dto.request.CreateBoardRequestDto;
import com.example.aws_crud_practice.board.dto.response.CreateBoardResponseDto;
import com.example.aws_crud_practice.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping("/v1")
public class BoardController {

    private final BoardService boardService;


    @PostMapping("/boards")
    public ResponseEntity<?> createBoard(@RequestBody CreateBoardRequestDto req) {

        CreateBoardResponseDto res = boardService.createBoard(req);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping()
    public ResponseEntity<?> getBoard() {
        return ResponseEntity.ok().body(null);
    }

    @PatchMapping
    public ResponseEntity<?> updateBoard() {
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBoard() {
        return ResponseEntity.ok().body(null);
    }
}
