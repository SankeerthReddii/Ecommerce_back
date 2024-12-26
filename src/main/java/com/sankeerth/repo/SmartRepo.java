package com.sankeerth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankeerth.model.Smart;
@Repository
public interface SmartRepo extends JpaRepository<Smart, Integer> {

}
