package com.daelim.blogbackend.controller;

import com.daelim.blogbackend.entity.Board;
import com.daelim.blogbackend.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/boards")
public class BoardController {
    @Autowired
    BoardService boardService;

    @PostMapping("/write")
    public void insertBoard(@RequestBody Map<String,Object> boardObj, MultipartFile file) throws Exception {
        boardService.write(boardObj, file); //하단 insertBoard2랑 비교 확인
    }

//    @PostMapping("/write") //return 값이 String
//    public String insertBoard2(@RequestBody Map<String,Object> boardObj, MultipartFile file) throws Exception {
//       return boardService.write2(boardObj, file);
//    }

    @GetMapping("/list")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }

    @PutMapping("/update")
    public void updateBoard(@RequestBody Map<String,Object> boardObj, HttpSession session) throws Exception {
        boardService.updateBoard(boardObj, session);
    }

    @GetMapping("/{idx}") // <- idx가 자동으로 들어감(@PathVariable)
    public Board viewBoard(@PathVariable int idx) {
        return boardService.viewBoard(idx);
    }

    @PostMapping("/delete") //POST 형식
    public String deleteBoardPost(@RequestBody Map<String,Object> boardObj, HttpSession session) throws Exception {
        return boardService.deleteBoardPost(boardObj, session);
    }
}
