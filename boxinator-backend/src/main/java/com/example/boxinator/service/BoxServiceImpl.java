package com.example.boxinator.service;

import org.modelmapper.ModelMapper;
import com.example.boxinator.dto.BoxDto;
import com.example.boxinator.entity.Box;
import com.example.boxinator.exception.ArgumentException;
import com.example.boxinator.exception.DataConstraintViolationException;
import com.example.boxinator.exception.DataDuplicateException;
import com.example.boxinator.exception.DataNotFoundException;
import com.example.boxinator.repository.BoxRepository;
import com.example.boxinator.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoxServiceImpl implements BoxService{

    ModelMapper mapper;
    BoxRepository repository;

    @Autowired
    public BoxServiceImpl(ModelMapper mapper, BoxRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

//    @Override
//    public BoxDto findById(Integer id) throws DataNotFoundException {
//        if (id == null || id == 0) throw new ArgumentException("Box Id should not be null or 0");
//        Box result = repository.findById(id).orElseThrow(() -> new DataNotFoundException("Box not found"));
//        return mapper.map(result, BoxDto.class);
//    }


    @Override
    public List<BoxDto> findAll() {
        List<Box> list=new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(list::add);
        return list.stream().map(category ->mapper.map(category, BoxDto.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public BoxDto create(BoxDto dto) throws  DataNotFoundException {
        if (dto == null) throw new ArgumentException("Box data should not be null");
        if (dto.getId() != null) throw new ArgumentException("id should be null");

        Box entity = mapper.map(dto, Box.class);
      entity.setShippingCost( entity.calcCost());
        Box result = repository.save(entity);

        return mapper.map(result, BoxDto.class);
    }

//    @Override
//    @Transactional(rollbackFor = {Exception.class})
//    public BoxDto update(BoxDto dto) throws DataNotFoundException {
//        System.out.println("dto = " + dto);
//        if (dto == null) throw new ArgumentException("Box data should not be null");
//        if (dto.getId() == null) throw new ArgumentException("id should not be null");
//
//        Box entity = mapper.map(dto, Box.class);
//        Box result = repository.save(entity);
//
//        return mapper.map(result, BoxDto.class);
//    }

//    @Override
//    public void delete(Integer id) throws DataNotFoundException {
//        repository.delete(mapper.map(findById(id), Box.class));
//    }
}
