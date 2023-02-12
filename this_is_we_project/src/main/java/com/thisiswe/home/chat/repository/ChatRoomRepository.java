package com.thisiswe.home.chat.repository;

import com.thisiswe.home.chat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<Room, Long> {

}
