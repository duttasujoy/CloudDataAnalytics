package com.microservice.dts.pojo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonAutoDetect
public class MeterReadData {
	private Long id;
	private String meterId;
	private String channelId;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy/MM/dd HH:mm")
	private Date meterReadDate;
	private Double intervalData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public Date getMeterReadDate() {
		return meterReadDate;
	}
	public void setMeterReadDate(Date meterReadDate) {
		this.meterReadDate = meterReadDate;
	}
	public Double getIntervalData() {
		return intervalData;
	}
	public void setIntervalData(Double intervalData) {
		this.intervalData = intervalData;
	}
	@Override
	public String toString() {
		return "MeterReadData [id=" + id + ", meterId=" + meterId + ", channelId=" + channelId + ", meterReadDate="
				+ meterReadDate + ", intervalData=" + intervalData + "]";
	}
}
