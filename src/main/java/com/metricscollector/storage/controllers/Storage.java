package com.metricscollector.storage.controllers;

import com.metricscollector.storage.dtos.StorageDto;
import com.metricscollector.storage.services.StorageService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Storage {

    private final StorageService service;

    @Autowired
    public Storage(StorageService service) {
        this.service = service;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "method gets a metric  ")
    public StorageDto getOne(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PostMapping("/ingest")
    @ApiOperation(value = "method creates a metric  ")
    @ResponseStatus(HttpStatus.CREATED)
    public StorageDto add(@RequestBody @Validated StorageDto dto) {
        return service.add(dto);
    }

    //adding this  method because i think that page use is better here
    @GetMapping("/get/pageable/")
    @ApiOperation(value = "method returns all metrics in pageable format ")
    public Page<StorageDto> getAllPageable(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                   @RequestParam(value = "size", required = false, defaultValue = "20") int size,
                                   Pageable pageable) {
        return service.getAllPageable(pageable, page, size);
    }

    @GetMapping("/get")
    @ApiOperation(value = "method returns all metrics  ")
    public List<StorageDto> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "method clears all metrics  ")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(){
        service.delete();
    }


}
