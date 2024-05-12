package com.training.repository;

import com.training.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO _user (user_id, email, first_name, last_name, username) VALUES (:userId, :email, :firstName, :lastName, :username)", nativeQuery = true)
    int createUserWithCustomQuery(Long userId, String email, String firstName, String lastName, String username);

}
