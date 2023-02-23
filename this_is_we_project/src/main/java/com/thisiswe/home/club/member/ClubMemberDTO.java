package com.thisiswe.home.club.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClubMemberDTO {

	/**유저ID */
	private String userID;
	/**권한 */
	private Long clubMemberRole;
	/**모임번호 */
	private Long clubNum;
}
