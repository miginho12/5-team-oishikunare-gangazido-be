package org.example.gangazido_be.pet.repository;

import org.example.gangazido_be.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {
	// @Where가 적용되어 있으므로, 삭제되지 않은 데이터만 조회됨
	Optional<Pet> findByUserId(Integer userId);

	boolean existsByUserIdAndDeletedAtIsNull(Integer userId);

	@Query(value = "SELECT * FROM pet WHERE user_id = :userId", nativeQuery = true)
	Optional<Pet> findByUserIdIncludingDeleted(@Param("userId") Integer userId);
}
