package com.sankeerth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankeerth.model.Pods;
@Repository
public interface PodsRepo extends JpaRepository<Pods, Integer> {

}
