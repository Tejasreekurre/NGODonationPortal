package com.cg.ndp.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ndp.entity.DonorEntity;
//import com.cg.ndp.model.DonorModel;

@Repository
public interface DonorRepo extends JpaRepository<DonorEntity, Integer>{


	
}