package com.microService.products;

public class MeterReadData {
	private Long id;
	private Long value;
	private String readType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "MeterReadData [id=" + id + ", value=" + value + ", readType=" + readType + "]";
	}
	public String getReadType() {
		return readType;
	}
	public void setReadType(String readType) {
		this.readType = readType;
	}

}
