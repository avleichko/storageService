package com.metricscollector.storage.services;

import com.metricscollector.storage.dao.StorageDao;
import com.metricscollector.storage.dtos.StorageDto;
import com.metricscollector.storage.repositorys.StorageRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    private final StorageRepository repository;
    private final ModelMapper modelMapper;

    @Autowired
    public StorageServiceImpl(StorageRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StorageDto getOne(Long id) {
        StorageDao one = repository.getOne(id);
        return modelMapper.map(one, StorageDto.class);
    }

    @Override
    public StorageDto add(StorageDto dto) {
        StorageDao dao = modelMapper.map(dto, StorageDao.class);
        StorageDao storageDao = repository.save(dao);
        return modelMapper.map(storageDao, StorageDto.class);
    }

    @Override
    public Page<StorageDto> getAllPageable(Pageable pageable, int page, int size) {
        log.info("trying to get page: {} with size {}", page, size);
        Page<StorageDao> all = repository.findAll(pageable);
        java.lang.reflect.Type targetListType = new TypeToken<Page<StorageDto>>() {
        }.getType();

        return modelMapper.map(all, targetListType);
    }

    @Override
    public List<StorageDto> getAll() {
        List<StorageDao> all = repository.findAll();
        java.lang.reflect.Type targetListType = new TypeToken<List<StorageDto>>() {
        }.getType();
        return modelMapper.map(all, targetListType);
    }

    @Override
    public void delete() {
        repository.deleteAll();
    }

}
