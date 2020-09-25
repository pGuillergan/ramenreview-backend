package com.example.ramenreview.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ramenreview.model.RamenReviews;

public interface RamenReviewsRepository extends JpaRepository<RamenReviews, Integer>{
	
	String value_addRamenReview = "INSERT INTO ratings( "
			+ "ramen_brand, "
			+ "ramen_variety, "
			+ "ramen_style, "
			+ "ramen_country, "
			+ "ramen_stars, "
			+ "ramen_top_ten ) "
			+ "VALUES ( "
			+ ":ramen_brand, "
			+ ":ramen_variety, "
			+ ":ramen_style, "
			+ ":ramen_country, "
			+ ":ramen_stars, "
			+ ":ramen_top_ten )";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_addRamenReview, nativeQuery = true)
	public void addRamenReview( @Param("ramen_brand")String ramen_brand, 
			@Param("ramen_variety")String ramen_variety,
			@Param("ramen_style")String ramen_style,
			@Param("ramen_country")String ramen_country,
			@Param("ramen_stars")double ramen_stars,
			@Param("ramen_top_ten")String ramen_top_ten);
	
	String value_updateRamenReview = "UPDATE ratings SET "
			+ "ramen_brand = :ramen_brand, "
			+ "ramen_variety = :ramen_variety, "
			+ "ramen_style = :ramen_style, "
			+ "ramen_country = :ramen_country, "
			+ "ramen_stars = :ramen_stars, "
			+ "ramen_top_ten = :ramen_top_ten WHERE ratings.ramen_review_number = :id ";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_updateRamenReview, nativeQuery = true)
	public void updateRamenReview( @Param("ramen_brand")String ramen_brand, 
			@Param("ramen_variety")String ramen_variety,
			@Param("ramen_style")String ramen_style,
			@Param("ramen_country")String ramen_country,
			@Param("ramen_stars")double ramen_stars,
			@Param("ramen_top_ten")String ramen_top_ten , 
			@Param("id")int id);
	
	
	String value_deleteRamenReview = "DELETE FROM ratings WHERE ramen_review_number =:id ";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_deleteRamenReview, nativeQuery = true)
	public void deleteRamenReview(@Param("id")  int id);
	
	
	/* Search repository */
	
	String value_searchbyBrand = "SELECT * FROM ratings WHERE lower(ramen_brand) = lower(:brand)";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_searchbyBrand, nativeQuery = true)
	public List<RamenReviews> searchByBrand( @Param("brand") String brand);
	
	
	String value_searchByVariety = "SELECT * FROM ratings WHERE lower(ramen_variety) "
			+ "LIKE lower( CONCAT('%', :variety, '%') )";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_searchByVariety, nativeQuery = true)
	public List<RamenReviews> searchByVariety( @Param("variety") String variety);
	
	
	String value_searchByStyle = "SELECT * FROM ratings WHERE lower(ramen_style) = lower(:style)";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_searchByStyle, nativeQuery = true)
	public List<RamenReviews> searchByStyle(@Param("style")String style);
	
	
	String value_searchByCountry = "SELECT * FROM ratings WHERE lower(ramen_country) = lower(:country)";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_searchByCountry, nativeQuery = true)
	public List<RamenReviews> searchByCountry(@Param("country")String country);
	
	
	String value_searchByStars = "SELECT * FROM ratings WHERE ramen_stars = :stars";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_searchByStars, nativeQuery = true)
	public List<RamenReviews> searchByStars(@Param("stars")int stars);
	
	String value_searchByStarsGreater = "SELECT * FROM ratings WHERE ramen_stars >= :stars";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_searchByStarsGreater, nativeQuery = true)
	public List<RamenReviews> searchByStarsGreater(@Param("stars")int stars);
	
	String value_getTopTen = "SELECT * FROM ratings WHERE "
			+ "ramen_top_ten IS NOT NULL ORDER BY ramen_top_ten ASC";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_getTopTen, nativeQuery = true)
	public List<RamenReviews> getTopTen();
	
	/* Initialization population routes */
	
	String value_fetchBrandList = "SELECT DISTINCT ramen_brand FROM ratings "
			+ "WHERE ramen_brand IS NOT NULL "
			+ "ORDER BY ramen_brand ASC;";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_fetchBrandList, nativeQuery = true)
	public List<String> fetchBrandList();
	
	String value_fetchStyleList = "SELECT DISTINCT ramen_style FROM ratings "
			+ "WHERE ramen_style IS NOT NULL "
			+ "ORDER BY ramen_style ASC;";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_fetchStyleList, nativeQuery = true)
	public List<String> fetchStyleList();
	
	String value_fetchCountryList = "SELECT DISTINCT ramen_country FROM ratings "
			+ "WHERE ramen_country IS NOT NULL "
			+ "ORDER BY ramen_country ASC;";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_fetchCountryList, nativeQuery = true)
	public List<String> fetchCountryList();
	
	String value_fetchStarsList = "SELECT DISTINCT ramen_stars FROM ratings "
			+ "WHERE ramen_stars IS NOT NULL "
			+ "ORDER BY ramen_stars ASC;";
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value =  value_fetchStarsList, nativeQuery = true)
	public List<String> fetchStarsList();
}







