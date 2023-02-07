package com.thisiswe.home.chat.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@ToString
@Entity
@Table(name = "we_chat")
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "chat_id")
    private Long chatId;

    @JoinColumn(name = "chatroom_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chatRoomId;

    @Column(name="chat_nikname")
    private String chatNickname;

    @Column(name = "chat_message")
    private String chatMessage;

    @Column(name = "chat_time")
    private String createdAt;

}
