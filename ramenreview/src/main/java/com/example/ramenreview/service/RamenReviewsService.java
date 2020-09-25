package com.example.ramenreview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ramenreview.repository.RamenReviewsRepository;
import com.example.ramenreview.model.RamenReviews;

@Service
public class RamenReviewsService {

	@Autowired
	RamenReviewsRepository rrr;
	
	public List<RamenReviews> findAll(){
		return rrr.findAll();
	}
	
	public void addRamenReview(RamenReviews rr) {
		System.out.println(rr.getRamen_brand() + "|" 
				+ rr.getRamen_variety() + "|" 
				+ rr.getRamen_style() + "|" 
				+ rr.getRamen_country() + "|" 
				+ rr.getRamen_stars() + "|" 
				+ rr.getRamen_top_ten());
		rrr.addRamenReview(rr.getRamen_brand(), 
				rr.getRamen_variety(), 
				rr.getRamen_style(), 
				rr.getRamen_country(), 
				rr.getRamen_stars(), 
				rr.getRamen_top_ten());
	}
	
	public void updateRamenReview(RamenReviews rr, int id) {
		System.out.println(rr.getRamen_brand() + "|"
				+ rr.getRamen_variety() + "|" 
				+ rr.getRamen_style() + "|" 
				+ rr.getRamen_country() + "|" 
				+ rr.getRamen_stars() + "|" 
				+ rr.getRamen_top_ten());
		rrr.updateRamenReview(rr.getRamen_brand(), 
				rr.getRamen_variety(), 
				rr.getRamen_style(), 
				rr.getRamen_country(), 
				rr.getRamen_stars(), 
				rr.getRamen_top_ten(), id);
	}
	
	public void deleteRamenReview(int id) {
		rrr.deleteRamenReview(id);
	}
	
	/* Search services */
	
	public List<RamenReviews> searchByBrand(String brand) {
		return rrr.searchByBrand(brand);
	}
	
	public List<RamenReviews> searchByVariety(String variety) {
		return rrr.searchByVariety(variety);
	}
	
	public List<RamenReviews> searchByStyle(String style){
		return rrr.searchByStyle(style);
	}
	
	public List<RamenReviews> searchByCountry(String country){
		return rrr.searchByCountry(country);
	}
	
	public List<RamenReviews> searchByStars(int stars){
		return rrr.searchByStars(stars);
	}
	
	public List<RamenReviews> searchByStarsGreater(int stars){
		return rrr.searchByStarsGreater(stars);
	}
	
	public List<RamenReviews> getTopTen(){
		return rrr.getTopTen();
	}
	
	/* Initialization population service */
	
	public List<String> fetchBrandList(){
		return rrr.fetchBrandList();
	}
	
	public List<String> fetchStyleList(){
		return rrr.fetchStyleList();
	}
	
	public List<String> fetchCountryList(){
		return rrr.fetchCountryList();
	}
	
	public List<String> fetchStarsList(){
		return rrr.fetchStarsList();
	}
}



