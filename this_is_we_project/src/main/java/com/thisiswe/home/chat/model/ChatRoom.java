package com.thisiswe.home.chat.model;


import com.thisiswe.home.club.entity.ClubEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Builder
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "we_chatroom")
//TODO [Entity]채팅방
public class ChatRoom {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "chatroom_id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserEntity user;          //방장

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_num")
    private ClubEntity club;

}
