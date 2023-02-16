package com.daelim.blogbackend.controller;

import com.daelim.blogbackend.dto.BoardDTO;
import com.daelim.blogbackend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("")
    public BoardDTO insertBoard(@RequestBody BoardDTO board) {
        return boardService.insertBoard(board);
    }

    @GetMapping("")
    public List<BoardDTO> getAllBoards() {
        return boardService.getAllBoards();
    }

    @GetMapping("/{index}") // <- userId가 자동으로 들어감(@PathVariable)
    public BoardDTO viewBoard(@PathVariable int index) {
        return boardService.viewBoard(index);
    }

    @PutMapping("/{index}")
    public void updateBoard(@PathVariable int index, @RequestBody BoardDTO board) {
        boardService.updateBoard(index, board);
    }

    @DeleteMapping("/{index}")
    public void deleteBoard(@PathVariable int index) {
        boardService.deleteBoard(index);
    }
}
