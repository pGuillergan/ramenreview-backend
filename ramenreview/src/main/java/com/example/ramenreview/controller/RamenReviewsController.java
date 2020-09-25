package com.example.ramenreview.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ramenreview.model.RamenReviews;
import com.example.ramenreview.service.RamenReviewsService;

@RestController
public class RamenReviewsController {

	@Autowired
	RamenReviewsService rrs;
	
	@GetMapping("/get_ramen_reviews")
	public List<RamenReviews> getAllReviews(){
		return rrs.findAll();
	}
	
	@PostMapping("/add_ramen_review")
	public void addRamenReview(@RequestBody RamenReviews rr) {
		rrs.addRamenReview(rr);
	}
	
	@PatchMapping("/update_ramen_review/{id}")
	public void updateRamenReview(@RequestBody RamenReviews rr, @PathVariable("id") int id) {
		rrs.updateRamenReview(rr, id);
	}
	
	@DeleteMapping("/delete_ramen_review/{id}")
	public void deleteRamenReview(@PathVariable("id") int id) {
		rrs.deleteRamenReview(id);
	}
	
	/* Search routes */
	
	@GetMapping("/search_by_brand/{brand}")
	public List<RamenReviews> searchByBrand(@PathVariable("brand")String brand){
		return rrs.searchByBrand(brand);
	}
	
	@GetMapping("/search_by_variety/{variety}")
	public List<RamenReviews> searchByVariety(@PathVariable("variety")String variety){
		return rrs.searchByVariety(variety);
	}
	
	@GetMapping("/search_by_style/{style}")
	public List<RamenReviews> searchByStyle(@PathVariable("style") String style){
		return rrs.searchByStyle(style);
	}
	
	@GetMapping("/search_by_country/{country}")
	public List<RamenReviews> searchByCountry(@PathVariable("country") String country){
		return rrs.searchByCountry(country);
	}
	
	@GetMapping("/search_by_stars/{stars}")
	public List<RamenReviews> searchByStars(@PathVariable("stars") int stars){
		return rrs.searchByStars(stars);
	}
	
	@GetMapping("/search_by_stars_greater/{stars}")
	public List<RamenReviews> searchByStarsGreater(@PathVariable("stars") int stars){
		return rrs.searchByStarsGreater(stars);
	}
	
	@GetMapping("/get_top_ten")
	public List<RamenReviews> searchByStarsGreater(){
		return rrs.getTopTen();
	}
	
	/* Initialization population routes */
	
	@GetMapping("/get_brands_list")
	public List<String> fetchBrandList(){
		return rrs.fetchBrandList();
	}
	
	@GetMapping("/get_style_list")
	public List<String> fetchStyleList(){
		return rrs.fetchStyleList();
	}
	
	@GetMapping("/get_country_list")
	public List<String> fetchCountryList(){
		return rrs.fetchCountryList();
	}
	
	@GetMapping("/get_stars_list")
	public List<String> fetchStarsList(){
		return rrs.fetchStarsList();
	}
	
	
	
}










