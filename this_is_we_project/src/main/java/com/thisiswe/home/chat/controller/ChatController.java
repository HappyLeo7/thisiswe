package com.thisiswe.home.chat.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.thisiswe.home.chat.dto.ChatMessageDto;
import com.thisiswe.home.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private ChatService chatService;

    //websocket 메시징 처리
    @MessageMapping({"/chat/message"})
    public void message(ChatMessageDto message, @Header("pk") Long pk) throws JsonProcessingException{
        chatService.save(message, pk);
    }

    //이전 채팅 기록 조회
    @GetMapping("/chat/message/{roomId}")
    @ResponseBody
    public List<ChatMessageDto> getMessage(@PathVariable String roomId) {
        return chatService.getMessages(roomId);
    }

    //채팅방에 파일 넣을 때 url 빼오기
    //채팅방에 참여한 사용자 정보 조회
    //유저 정보 상세 조회

    //*추가기능 : 파일보내기

}
