package com.cg.ndp.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ndp.entity.AddressEntity;



@Repository
public interface AddRepo extends JpaRepository<AddressEntity,Integer>{



}
