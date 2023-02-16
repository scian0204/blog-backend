package com.daelim.blogbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BoardDTO {
    int index;
    String userid;
    String title;
    String text;
}
