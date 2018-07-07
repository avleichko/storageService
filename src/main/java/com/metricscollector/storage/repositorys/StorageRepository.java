package com.metricscollector.storage.repositorys;

import com.metricscollector.storage.dao.StorageDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageRepository extends JpaRepository<StorageDao, Long> {
}
