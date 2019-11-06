package com.microservices.dts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.dts.entities.MeterIntervalData;
@Repository
public interface MeterDataRepository extends JpaRepository<MeterIntervalData,Long>{
	public List<MeterIntervalData> findByMeterUdcId(String udcId);
}
