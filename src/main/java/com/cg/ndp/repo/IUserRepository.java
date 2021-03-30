package com.cg.ndp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ndp.entity.UserEntity;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity,Integer>{

}