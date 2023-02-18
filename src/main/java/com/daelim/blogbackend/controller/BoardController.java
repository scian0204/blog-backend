package com.daelim.blogbackend.controller;

import com.daelim.blogbackend.entity.Board;
import com.daelim.blogbackend.service.BoardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("")
    public Board insertBoard(@RequestBody Map<String,Object> boardObj) {
        return boardService.write(boardObj);
    }

    @GetMapping("")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PutMapping("")
    public void updateBoard(@RequestBody Map<String,Object> boardObj) {
        boardService.updateBoard(boardObj);
    }

    @GetMapping("/{idx}") // <- userId가 자동으로 들어감(@PathVariable)
    public Board viewBoard(@PathVariable int idx) {
        return boardService.viewBoard(idx);
    }


    @DeleteMapping("/{idx}")
    public void deleteBoard(@PathVariable int idx) {
        boardService.deleteBoard(idx);
    }
}
