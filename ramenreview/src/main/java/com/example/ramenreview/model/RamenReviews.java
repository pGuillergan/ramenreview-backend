package com.example.ramenreview.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class RamenReviews implements Serializable{
	
	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "ramen_review_number")
	int ramen_review_number;
	
	@Column(name="ramen_brand")
	String ramen_brand;
	
	@Column(name="ramen_variety")
	String ramen_variety;
	
	@Column(name="ramen_style")
	String ramen_style;
	
	@Column(name = "ramen_country")
	String ramen_country;
	
	@Column(name = "ramen_stars")
	double ramen_stars;
	
	@Column(name = "ramen_top_ten")
	String ramen_top_ten;
	
	public RamenReviews() {}
	
	public RamenReviews(int ramen_review_number, 
			String ramen_brand, 
			String ramen_variety, 
			String ramen_style,
			String ramen_country, 
			double ramen_stars, 
			String ramen_top_ten) {
		this.ramen_review_number = ramen_review_number;
		this.ramen_brand = ramen_brand;
		this.ramen_variety = ramen_variety;
		this.ramen_style = ramen_style;
		this.ramen_country = ramen_country;
		this.ramen_stars = ramen_stars;
		this.ramen_top_ten = ramen_top_ten;
	}
	
	public RamenReviews( 
			String ramen_brand, 
			String ramen_variety, 
			String ramen_style,
			String ramen_country, 
			double ramen_stars, 
			String ramen_top_ten) {
		this.ramen_brand = ramen_brand;
		this.ramen_variety = ramen_variety;
		this.ramen_style = ramen_style;
		this.ramen_country = ramen_country;
		this.ramen_stars = ramen_stars;
		this.ramen_top_ten = ramen_top_ten;
	}
	
	public int getRamen_review_number() {
		return ramen_review_number;
	}
	public void setRamen_review_number(int ramen_review_number) {
		this.ramen_review_number = ramen_review_number;
	}
	public String getRamen_brand() {
		return ramen_brand;
	}
	public void setRamen_brand(String ramen_brand) {
		this.ramen_brand = ramen_brand;
	}
	public String getRamen_variety() {
		return ramen_variety;
	}
	public void setRamen_variety(String ramen_variety) {
		this.ramen_variety = ramen_variety;
	}
	public String getRamen_style() {
		return ramen_style;
	}
	public void setRamen_style(String ramen_style) {
		this.ramen_style = ramen_style;
	}
	public String getRamen_country() {
		return ramen_country;
	}
	public void setRamen_country(String ramen_country) {
		this.ramen_country = ramen_country;
	}
	public double getRamen_stars() {
		return ramen_stars;
	}
	public void setRamen_stars(double ramen_stars) {
		this.ramen_stars = ramen_stars;
	}
	public String getRamen_top_ten() {
		return ramen_top_ten;
	}
	public void setRamen_top_ten(String ramen_top_ten) {
		this.ramen_top_ten = ramen_top_ten;
	}
	
}
