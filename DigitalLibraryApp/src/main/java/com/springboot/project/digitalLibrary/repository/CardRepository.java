package com.springboot.project.digitalLibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.project.digitalLibrary.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{

}
