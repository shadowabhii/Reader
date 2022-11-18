package com.digital.reader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReaderBookBuy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private int pId;
	private String paymentid;
	private String readerName;
	private String readerEmailId;
	private int bId;
	private double price;
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(String paymentid) {
		this.paymentid = paymentid;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public String getReaderEmailId() {
		return readerEmailId;
	}
	public void setReaderEmailId(String readerEmailId) {
		this.readerEmailId = readerEmailId;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ReaderBookBuy(int pId, String paymentid, String readerName, String readerEmailId, int bId, double price) {
		super();
		this.pId = pId;
		this.paymentid = paymentid;
		this.readerName = readerName;
		this.readerEmailId = readerEmailId;
		this.bId = bId;
		this.price = price;
	}
	public ReaderBookBuy() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ReaderBookBuy [pId=" + pId + ", paymentid=" + paymentid + ", readerName=" + readerName
				+ ", readerEmailId=" + readerEmailId + ", bId=" + bId + ", price=" + price + "]";
	}
	
	
	
	}
	
	


