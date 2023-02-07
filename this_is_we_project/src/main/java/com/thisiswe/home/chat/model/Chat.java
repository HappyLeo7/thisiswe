package com.thisiswe.home.chat.model;

import javax.persistence.*;

@Entity
@Table(name = "we_chat")
public class Chat {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "chat_id")
    private Long id;

    @JoinColumn(name = "chatroom_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom chatRoom;

    @Column(name="user_id")
    private String userId;

    @Column(name = "chat_message")
    private String message;

    @Column(name = "chat_time")
    private String createdAt;

}
