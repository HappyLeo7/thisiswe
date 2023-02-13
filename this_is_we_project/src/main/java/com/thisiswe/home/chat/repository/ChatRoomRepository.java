package com.thisiswe.home.chat.repository;

import com.thisiswe.home.chat.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomRepository extends JpaRepository<Room, Long> {

}
