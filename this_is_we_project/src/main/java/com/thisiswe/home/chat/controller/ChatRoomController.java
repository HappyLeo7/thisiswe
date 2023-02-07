package com.thisiswe.home.chat.controller;


import com.thisiswe.home.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;

    //내 채팅방 목록 반환
//    @GetMapping("/rooms")
//    @ResponseBody
//    public ChatListMessageDto room(@AuthenticationPrincipa USerDetailsImpl uSerDetails){
//        UserEntity user = userDetails.getUser();
//        return chatRoomRepository.findAllRoom(user);
//    }

    //특정 채팅방 입장
    @PostMapping("/room/{postId}")
    @ResponseBody
    public String roomInfo(@PathVariable Long postId) {
        return String.valueOf(postId);
    }
}
