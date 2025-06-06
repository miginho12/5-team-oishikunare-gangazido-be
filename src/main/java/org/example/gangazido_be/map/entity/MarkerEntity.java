package org.example.gangazido_be.map.entity;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity	// 이 클래스는 DB 테이블과 매핑되는 클래스
@Getter
@Setter
@NoArgsConstructor
@Table(name = "marker") //테이블명 명시
public class MarkerEntity {
	@Id	// PK 지정
	@GeneratedValue(generator = "UUID")	// UUID 자동 생성 방식 설정
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")	// Hibernate에서 UUID를 생성할 전략 지정
	@Column(name = "id", updatable = false, nullable = false, columnDefinition = "BINARY(16)")	// DB에 16진수 Binary로 저장 성능 향상
	private UUID id;  // 마커 ID (Primary Key)

	@Column(nullable = false)
	private Integer user_id;  // 마커를 등록한 사용자 ID

	@Column(nullable = false)
	private int type;  // 마커 타입 (0: 댕플, 1: 들개, 2: 빙판길, 3: 염화칼슘, 4: 공사중)

	@Column(nullable = false)
	private Double latitude;  // 위도 좌표

	@Column(nullable = false)
	private Double longitude;  // 경도 좌표

	@Column(name = "created_at", nullable = false, updatable = false)
	private LocalDateTime createdAt = LocalDateTime.now();

	@Column(name = "deleted_at")
	private LocalDateTime deletedAt;

	public MarkerEntity(UUID id, Integer user_id, int type, double latitude, double longitude) {
		this.id = id;
		this.user_id = user_id;
		this.type = type;
		this.latitude = latitude;    // 제리추가
		this.longitude = longitude;
		this.createdAt = LocalDateTime.now(); // 현재 시간 저장
	}

	// 유저 ID 반환 메서드 추가, 서비스에서 본인 마커 확인 로직
	public Integer getUserId() {
		return user_id;
	}
}
