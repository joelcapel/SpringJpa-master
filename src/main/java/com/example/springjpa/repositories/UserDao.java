package com.example.springjpa.repositories;

import com.example.springjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    List<User> findAll();

    Optional<User> findById(Integer integer);

    <S extends User> S save(S entity);

    void deleteById(Integer integer);

}
