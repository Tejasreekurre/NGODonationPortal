package com.cg.ndp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ndp.entity.DonationEntity;

@Repository
public interface DonationRepo extends JpaRepository<DonationEntity, Integer> {

}
