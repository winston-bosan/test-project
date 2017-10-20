package com.liveasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.liveasy.model.House;

@Repository("houseRepository")
public interface HouseRepository extends JpaRepository<House, Integer> {
	
	/*
	@Modifying
	@Transactional
	@Query("UPDATE House c SET c.address = :address WHERE c.id = :houseId")
	public void updateFirstname(@Param("address") String address, @Param("houseId") int houseId);
	*/
	
}
