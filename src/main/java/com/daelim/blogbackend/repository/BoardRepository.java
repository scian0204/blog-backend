package com.daelim.blogbackend.repository;

import com.daelim.blogbackend.dto.BoardDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardRepository{
    //db 연동 코드

    //일단 ArrayList로 대체
    static public ArrayList<BoardDTO> boards;

    static {
        boards = new ArrayList<>();
        boards.add(new BoardDTO(0, "admin", "first board", "1111"));
    }

    public BoardDTO insertBoard(BoardDTO board) {
        boards.add(board);
        return board;
    }

    public List<BoardDTO> getAllBoards() {
        return boards;
    }

    public BoardDTO viewBoard(int index) {
        return boards.stream()
                .filter(boardDTO -> boardDTO.getIndex() == index)
                .findAny()
                .orElse(new BoardDTO(0, "admin", "", ""));
    }

    public void updateBoard(int index, BoardDTO board) {
        boards.stream()
                .filter(boardDTO -> boardDTO.getIndex() == (index))
                .findAny()
                .orElse(new BoardDTO(0, "admin", "", ""))
                .setTitle(board.getTitle());
        boards.stream()
                .filter(boardDTO -> boardDTO.getIndex() == (index))
                .findAny()
                .orElse(new BoardDTO(0, "admin", "", ""))
                .setText(board.getText());
    }

    public void deleteBoard(int index) {
        boards.removeIf(boardDTO -> boardDTO.getIndex() == (index));

    }
}
