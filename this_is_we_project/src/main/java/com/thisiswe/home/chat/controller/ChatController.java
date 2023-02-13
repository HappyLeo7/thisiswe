package com.thisiswe.home.chat.controller;

import com.thisiswe.home.chat.model.Room;
import com.thisiswe.home.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ChatController {
//    List<Room> roomList = new ArrayList<Room>();    //roomlist를 메모리에 저장?
    static int roomNumber = 0;                   //

    private final ChatService chatService;

    @RequestMapping("/chat")
    public ModelAndView chat() {
        //ModelAndView클래스
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatroom/chat");
        return mv;
    }


    //방 페이지
    @RequestMapping("/room")
    public ModelAndView room() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chatroom/room");//어디 페이지로 보낼것인지 set
//        List<Room> rooms = chatService.getAllChatRooms();
//        mv.addObject("roomList", rooms);
        return mv;
    }

    //방 생성하기
    @RequestMapping("/createRoom")
    public @ResponseBody List<Room> createRoom(@RequestParam HashMap<Object, Object> params){ //@ResponseBody가 붙어 있음 스트링값을 그대로 반환합니다.
        String roomName = (String) params.get("roomName");
        System.out.println("채팅방 이름 : " + roomName);
//        if(roomName != null && !roomName.trim().equals("")) {
//            Room room = new Room();
//            room.setRoomNumber(++roomNumber);
//            room.setRoomName(roomName);
//            roomList.add(room);
//        }
        chatService.createChattingRoom(roomName);
        List<Room> roomList = chatService.getAllChatRooms();
        return roomList;
    }

    //방 정보 가져오기
    @RequestMapping("/getRoom")
    public @ResponseBody List<Room> getRoom(@RequestParam HashMap<Object, Object> params){

        return chatService.getAllChatRooms();
    }

    //채팅방으로 이동
    @RequestMapping("/moveChating")
    public ModelAndView chating(@RequestParam HashMap<Object ,Object> params) {
        ModelAndView mv = new ModelAndView();
        String roomName = (String) params.get("roomName");
        String roomNumber = (String) params.get("roomNumber");
        System.out.println(roomName);

        mv.setViewName("chatroom/chat");
        mv.addObject("roomName", roomName);
        mv.addObject("roomNumber", roomNumber);
        mv.addObject("chatList", chatService.getMessages(roomName));
//        List<Room> new_list = roomList.stream().filter(o->o.getRoomNumber()==roomNumber).collect(Collectors.toList());
//        if(new_list != null && new_list.size() > 0) {
//            mv.addObject("roomName", params.get("roomName"));
//            mv.addObject("roomNumber", params.get("roomNumber"));
//            mv.setViewName("chatroom/chat");
//
//        }else {
//            mv.setViewName("chatroom/room");
//        }
        return mv;
    }
}
