package com.metricscollector.storage.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class StorageDao {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Id;
    private String metric;
    private Long value;
    private Date timestamp;

}
