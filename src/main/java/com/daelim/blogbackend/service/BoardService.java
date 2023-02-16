package com.daelim.blogbackend.service;

import com.daelim.blogbackend.dto.BoardDTO;
import com.daelim.blogbackend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired()
    BoardRepository boardRepository;

    public BoardDTO insertBoard(BoardDTO board) {
        return boardRepository.insertBoard(board);
    }

    public List<BoardDTO> getAllBoards() {
        return boardRepository.getAllBoards();
    }

    public BoardDTO viewBoard(int index) {
        return boardRepository.viewBoard(index);
    }

    public void updateBoard(int index, BoardDTO board) {
        boardRepository.updateBoard(index, board);
    }

    public void deleteBoard(int index) {
        boardRepository.deleteBoard(index);
    }
}
