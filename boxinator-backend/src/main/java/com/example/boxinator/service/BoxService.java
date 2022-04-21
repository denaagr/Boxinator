package com.example.boxinator.service;

import com.example.boxinator.dto.BoxDto;
import com.example.boxinator.exception.DataConstraintViolationException;
import com.example.boxinator.exception.DataDuplicateException;
import com.example.boxinator.exception.DataNotFoundException;

import java.util.List;

public interface BoxService {

    List<BoxDto> findAll();

    BoxDto create(BoxDto dto) throws DataDuplicateException, DataNotFoundException;




    //    BoxDto findById(Integer id) throws DataNotFoundException;

  //  BoxDto update(BoxDto dto) throws DataNotFoundException;

   // void delete(Integer id) throws DataNotFoundException, DataConstraintViolationException;

}
