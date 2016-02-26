package com.chni.lidong.androidtestdemo.db.entity;

import java.math.BigDecimal;

public class MyProduct {
	/** 商品id */
	private Long pruId;
	/** 商品全名 */
	private String fullName;
	/** 销售价 */
	private BigDecimal price;
	/** 市场价 */
	private BigDecimal marketPrice;
	/** 展示图片 */
	private String image;
	
	private Integer totalpage;

	private Long monthSales;



	public Long getPruId() {
		return pruId;
	}

	public void setPruId(Long pruId) {
		this.pruId = pruId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}

	public Long getMonthSales() {
		return monthSales;
	}

	public void setMonthSales(Long monthSales) {
		this.monthSales = monthSales;
	}

	
	
	

}
