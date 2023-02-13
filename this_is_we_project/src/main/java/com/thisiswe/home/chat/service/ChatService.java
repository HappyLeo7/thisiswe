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

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository chatRoomRepository;

    public void saveMessage(JSONObject obj) {
        String clubName = (String) obj.get("roomNumber");
        String userNickname = (String) obj.get("userName");
        String getMessage = (String) obj.get("msg");
        String imageUrl = "sssss";

        Message message = new Message(clubName, userNickname, getMessage, imageUrl);

        chatMessageRepository.save(message);
        System.out.println(message);
    }

    public List<MessageResponseDto> getMessages(String roomName) {
        List<Message> messages = chatMessageRepository.findAllByClubName(roomName);
        List<MessageResponseDto> messageResponseDtos = null;
        for (Message message : messages) {
            messageResponseDtos.add(new MessageResponseDto(message.getUserNickname(), message.getMessage(), message.getImageUrl()));
        }
        return messageResponseDtos;
    }

    public List<Room> getAllChatRooms() {

        return chatRoomRepository.findAll();
    }

    public void createChattingRoom(String roomName) {
        chatRoomRepository.save(new Room(roomName));

    }
}
