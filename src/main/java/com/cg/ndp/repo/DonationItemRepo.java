package com.cg.ndp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ndp.entity.DonationItemEntity;

@Repository
public interface DonationItemRepo  extends JpaRepository<DonationItemEntity, Integer>{

}
