package com.example.amsarticleapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;







import org.springframework.data.mongodb.repository.Query;

import com.example.amsarticleapi.entity.Category;



public interface CategoryRepository extends MongoRepository<Category,Integer>{

	@Query("{categoryId:?0}")
	Category findCategoryByCategoryid(int id);

	
//	@Query(value="{categoryid:'?0'}")
//	CategoryService findItemBycategoryid(String name);
    
//    @Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
//    List<CategoryService> findAll(String category);
    
 // public long count();
}
