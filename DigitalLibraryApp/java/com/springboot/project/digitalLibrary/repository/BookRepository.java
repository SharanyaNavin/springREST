package com.springboot.project.digitalLibrary.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.project.digitalLibrary.entity.Book;
import com.springboot.project.digitalLibrary.entity.Card;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
