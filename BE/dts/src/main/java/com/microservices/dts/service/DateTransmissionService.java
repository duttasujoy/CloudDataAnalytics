package com.microservices.dts.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.dts.pojo.MeterReadData;
import com.microservices.dts.entities.MeterIntervalData;
import com.microservices.dts.repository.MeterDataRepository;

@Service
public class DateTransmissionService {
	@Autowired
	private MeterDataRepository meterDataRepo;
	public void transfer(MeterReadData data)
	{
		MeterIntervalData meterData = new MeterIntervalData();
		meterData.setChannelId(data.getChannelId());
		meterData.setMeterUdcId(data.getMeterId());
		meterData.setMeterReadDate(new Date(data.getMeterReadDate().getTime()));
		meterData.setIntervalReadData(data.getIntervalData());
		meterDataRepo.save(meterData);
	}

}
