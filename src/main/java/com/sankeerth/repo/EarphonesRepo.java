package com.sankeerth.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankeerth.model.Earphones;
@Repository

public interface EarphonesRepo extends JpaRepository<Earphones, Integer> {

}
