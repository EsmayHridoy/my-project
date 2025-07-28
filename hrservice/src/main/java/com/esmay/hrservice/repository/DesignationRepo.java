package com.esmay.hrservice.repository;

import com.esmay.hrservice.model.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface DesignationRepo extends JpaRepository<Designation,Integer> {
    Optional<Designation> findById(Integer id);
    Optional<Designation>findByName(String name);
}
