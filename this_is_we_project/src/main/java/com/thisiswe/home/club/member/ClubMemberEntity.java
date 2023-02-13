package com.thisiswe.home.club.member;

import com.thisiswe.home.club.entity.ClubEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
public class ClubMemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "club_member_num")
	private Long clubMemberNum; //구성원 번호
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private ClubEntity userId; //유저ID
	
	@Column(name = "club_member_role")
	private Long clubMemberRole; //권한 1 2 3 
	
	@Column(name = "club_num")
	private Long clubNum; //모임 번호
	
	
}
