package com.microservices.dts.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "Meter")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Meter implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "meterId_Sequence")
	@SequenceGenerator(name = "meterId_Sequence", sequenceName = "MeterId_SEQ")
	private Long id;
	@Column(name="UDC_ID")
	private String meterUdcId;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

	public String getMeterUdcId() {
		return meterUdcId;
	}

	public void setMeterUdcId(String meterUdcId) {
		this.meterUdcId = meterUdcId;
	}

	
}
