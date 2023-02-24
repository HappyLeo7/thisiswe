package com.thisiswe.home.user.mypage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.thisiswe.home.club.board.dto.BoardDTO;
import com.thisiswe.home.club.board.dto.PageRequestDTO;
import com.thisiswe.home.club.board.entity.Board;
import com.thisiswe.home.club.board.repository.BoardRepository;
import com.thisiswe.home.user.entity.UserEntity;
import com.thisiswe.home.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MypageServiceImpl implements MypageService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final BoardRepository boardRepository;


	
//	 게시글 페이지 목록(list)
	@Override
	public MyPageResultDTO<BoardDTO, Board> getList(PageRequestDTO pageRequestDTO, String userId) {
		
	    UserEntity userEntity = userRepository.findByUserId(userId)
	            .orElseThrow(() -> new IllegalArgumentException("User not found"));

	    Function<Board, BoardDTO> func = board -> entityToBoardDTO(board, userEntity, board.getReplyCount());

	    Page<Board> result2 = boardRepository.findAllByUserId(userEntity, pageRequestDTO.getPageable(Sort.by("boardNum").descending()));

	    return new MyPageResultDTO<>(result2, func);
	}
	
	@Override
	public void getUserInfo(String username) {
		// TODO Auto-generated method stub

	}

	// 회원정보 수정 (페이지만들기 해야함)
	@Override
	public void modifyUserInfo(MultipartFile userImageFile, String userNickname, String userPassword, String userId) {
	    Optional<UserEntity> result = userRepository.findByUserId(userId);

	    if (result.isPresent()) {
	        UserEntity userEntity = result.get();
	        userEntity.changeNickName(userNickname);

	        String encodedPassword = passwordEncoder.encode(userPassword);
	        userEntity.changePassword(encodedPassword);

	        // 이미지 업로드
	        String uploadedImageUrl = null;
	        if (userImageFile != null) {
	            uploadedImageUrl = uploadImage(userImageFile);
	        } else {
	            uploadedImageUrl = userEntity.getUserImageUrl();
	        }
	        userEntity.changeImage(uploadedImageUrl);

	        userRepository.save(userEntity);
	    }
	}

	private String uploadImage(MultipartFile imageFile) {
		// 업로드한 이미지 파일의 이름을 가져옵니다.
        String fileName = imageFile.getOriginalFilename();
        
        // 이미지 파일을 저장할 경로를 지정합니다. 
        // System.getProperty("user.dir")은 현재 프로젝트의 경로를 가져옵니다. 
        // File.separator는 운영체제별로 디렉토리 구분자가 다르기 때문에 이에 맞게 구분자를 사용합니다.
        String savePath = System.getProperty("user.dir") + File.separator + "uploads";
        System.out.println("현재 프로젝트의 경로 : " + System.getProperty("user.dir"));
        
        // 이미지 파일을 저장할 디렉토리가 존재하지 않으면 새로 생성합니다.
        File saveDir = new File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }

        try {
            // 파일 저장
            byte[] bytes = imageFile.getBytes(); // 이미지 파일을 byte 형식으로 읽어옵니다.
            
            // 파일을 저장할 경로와 파일 이름을 지정합니다.
            // Paths.get() 메소드를 이용하여 경로를 지정합니다.
            Path path = Paths.get(savePath + File.separator + fileName);
            
            // Files.write() 메소드를 이용하여 byte 형식으로 읽어온 이미지 파일을 지정한 경로에 저장합니다.
            Files.write(path, bytes);

            // 업로드한 이미지 파일의 경로를 반환합니다. 
            // 이후에 해당 파일 경로를 이용하여 데이터베이스에 저장하거나 이미지를 미리보기 할 수 있습니다.
            return savePath + File.separator + fileName;
            
        } catch (IOException e) {
            log.error("Failed to upload image", e);
            throw new RuntimeException("Failed to upload image");
        }
    }



}
