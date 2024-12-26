package com.sankeerth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankeerth.model.Laptops;
@Repository

public interface LaptopsRepo extends JpaRepository<Laptops, Integer> {

}
