package com.daelim.blogbackend.controller;

import com.daelim.blogbackend.dto.BoardDTO;
import com.daelim.blogbackend.service.BoardService;
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
    public BoardDTO insertBoard(@RequestBody Map<String,Object> boardObj) {
        int index = (Integer) boardObj.get("index");
        String userId = (String) boardObj.get("userId");
        String title = (String) boardObj.get("title");
        String text = (String) boardObj.get("text");

        return boardService.insertBoard(new BoardDTO(index, userId, title, text));
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
