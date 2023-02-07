package com.thisiswe.home.chat.service;

import com.thisiswe.home.chat.dto.ChatMessageDto;
import com.thisiswe.home.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatMessageRepository chatMessageRepository;


    public void save(ChatMessageDto messageDto, Long pk) {
//        User user = userRepository.findbyId(pk).orElseThrow(
//                () -> new NullPointerException("존재하지 않는 사용자입니다.")
//        );
        LocalDateTime createdAt = LocalDateTime.now();
        String formatDate = createdAt.format(DateTimeFormatter.ofPattern("dd,MM,yyy,HH,mm,ss", Locale.KOREA));
        Long enterUserCnt = chatMessageRepository.getUserCnt(messageDto.getRoomid());

        messageDto.
    }

    public List<ChatMessageDto> getMessages(String roomId) {
    }
}
