package com.thisiswe.home.chat.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MessageResponseDto {
    private String userNickname;
    private String message;
    private String imageUrl;

    public MessageResponseDto(String userNickname, String message, String imageUrl){
        this.userNickname = userNickname;
        this.message = message ;
        this.imageUrl = imageUrl;

    }
}
