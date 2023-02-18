package com.daelim.blogbackend.service;

import com.daelim.blogbackend.entity.Board;
import com.daelim.blogbackend.repository.BoardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardService{
    ObjectMapper objMpr = new ObjectMapper();
    @Autowired()
    BoardRepository boardRepository;

    public Board write(Map<String, Object> boardObj) {
        Board board = objMpr.convertValue(boardObj, Board.class);
        boardRepository.save(board);
        return board;
    }

    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    public Board viewBoard(Integer idx) {
        return boardRepository.findById(idx).get();
    }

    public void updateBoard(Map<String, Object> boardObj) {
        Board board = objMpr.convertValue(boardObj, Board.class);
        boardRepository.save(board);
    }

    public void deleteBoard(Integer idx) {
        boardRepository.deleteById(idx);
    }
}
