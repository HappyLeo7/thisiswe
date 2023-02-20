package com.thisiswe.home.chat.service;

import com.thisiswe.home.chat.dto.MessageResponseDto;
import com.thisiswe.home.chat.model.Message;
import com.thisiswe.home.chat.model.Room;
import com.thisiswe.home.chat.repository.ChatMessageRepository;
import com.thisiswe.home.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    //메세지 저장
    public void saveMessage(JSONObject obj) {
        String clubName = (String) obj.get("roomName");
        String userNickname = (String) obj.get("userName");
        String getMessage = (String) obj.get("msg");
        String imageUrl = "sssss";

        Message message = new Message(clubName, userNickname, getMessage, imageUrl);

        chatMessageRepository.save(message);
        System.out.println(message);
    }
    //방에 들어올 시 메세지 조회
    public List<MessageResponseDto> getMessages(String roomName) {
        System.out.println("getmessage실행되긴함 ");
        List<Message> messages = chatMessageRepository.findAllByClubName(roomName);

        List<MessageResponseDto> messageResponseDtos = new ArrayList<>();
        for (Message message : messages) {
            messageResponseDtos.add(new MessageResponseDto(message.getUserNickname(), message.getMessage(), message.getImageUrl()));
        }
        return messageResponseDtos;
    }


    public List<Room> getAllChatRooms() {
        return chatRoomRepository.findAll();
    }

    //채팅방 생성
    public void createChattingRoom(String roomName) {
        chatRoomRepository.save(new Room(roomName));

    }

    //채팅방 삭제
    public void deleteChattingRoom(String roomName){
        chatRoomRepository.deleteByRoomName(roomName);
        System.out.println("방이 삭제되었습니다. 모임이름 : " + roomName);
//        chatMessageRepository.deleteAllByRoomName(roomName);
        System.out.println("메세지가 삭제되었습니다. 모임이름 : "+ roomName);
    }

}
