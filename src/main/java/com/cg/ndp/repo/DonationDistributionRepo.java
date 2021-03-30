package com.cg.ndp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ndp.entity.DonationDistributionEntity;

@Repository
public interface DonationDistributionRepo extends JpaRepository<DonationDistributionEntity, Integer> {

}
