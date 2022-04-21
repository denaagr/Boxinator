package com.example.boxinator.repository;

import com.example.boxinator.entity.Box;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BoxRepository extends CrudRepository<Box, Integer> {


}
