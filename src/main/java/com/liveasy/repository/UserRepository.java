package com.liveasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.liveasy.model.User;


/*
 * Note: In a future update, it might be fruitful to move the DAO features out from REPO. 
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
	@Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User c SET c.address = :address WHERE c.id = :userId")
    int updateAddress(@Param("userId") int userId, @Param("address") String address);

	
}
