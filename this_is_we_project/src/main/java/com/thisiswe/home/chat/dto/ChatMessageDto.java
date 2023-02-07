package com.thisiswe.home.chat.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto {
    private String chatNickname;
    private String message;
    private String roomId;
    private String createdAt;


    public Object getRoomId() {
        return null;

    }


}
