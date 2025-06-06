package org.example.gangazido_be.user.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements Serializable {
	// serialVersionUID 추가 - 직렬화 버전 관리를 위해 필수적
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// pk 컬럼명은 따로 지정해주는게 더 명확(같긴 하지만)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false, unique = true, length = 20)
	private String nickname;

	@Column(name = "profile_image")
	private String profileImage;

	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime deletedAt;

	@Builder
	protected User(String email, String password, String nickname, String profileImage) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.profileImage = profileImage;
	}

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
		updatedAt = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedAt = LocalDateTime.now();
	}

	@Override
	public String toString() {        // 제리 작성
		return "User{" +
			"id=" + id +
			", email='" + email + '\'' +
			", nickname='" + nickname + '\'' +
			", profileImage='" + profileImage + '\'' +
			", createdAt=" + createdAt +
			", updatedAt=" + updatedAt +
			", deletedAt=" + deletedAt +
			'}';
	}
}
