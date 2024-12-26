package com.sankeerth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankeerth.model.Mobiles;
@Repository

public interface MobilesRepo extends JpaRepository<Mobiles, Integer> {

}
