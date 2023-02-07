package com.thisiswe.home.chat;


import com.thisiswe.home.club.entity.ClubEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "we_chatroom")
public class ChatRoom {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chatroom_id")
    private int id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="club_num")
    private ClubEntity club;

    @Column(name = "chatroom_role")
    private int chatRole;



}
