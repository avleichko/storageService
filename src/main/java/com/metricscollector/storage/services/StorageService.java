package com.metricscollector.storage.services;

import com.metricscollector.storage.dtos.StorageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StorageService {

     StorageDto getOne(Long Id);

     StorageDto add(StorageDto dto);


     Page<StorageDto> getAllPageable(Pageable pageable, int page, int size);
     List<StorageDto> getAll();
     void delete();

}
