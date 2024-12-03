package com.elan.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elan.user.repo.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
