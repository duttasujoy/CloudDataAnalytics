package com.microservices.dts.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "MeterData")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class MeterIntervalData implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "meterDataId_Sequence")
	@SequenceGenerator(name = "meterDataId_Sequence", sequenceName = "MeterDataId_SEQ")
	private Long id;

	@Column(name="Meter_Udc_Id")
	private String meterUdcId;
	
	@Column(name="Channel_Id")
	private String channelId;
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Meter_Read_Date")
	private Date meterReadDate;
	
	@Column(name="Interval_Read_Data")
	private Double intervalReadData;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMeterUdcId() {
		return meterUdcId;
	}

	public void setMeterUdcId(String meterUdcId) {
		this.meterUdcId = meterUdcId;
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

	public Double getIntervalReadData() {
		return intervalReadData;
	}

	public void setIntervalReadData(Double intervalReadData) {
		this.intervalReadData = intervalReadData;
	}

	@Override
	public String toString() {
		return "MeterIntervalData [id=" + id + ",\n meterUdcId=" + meterUdcId + ",\n channelId=" + channelId
				+ ",\n meterReadDate=" + meterReadDate + ",\n intervalReadData=" + intervalReadData + "]";
	}
	
}
