package com.Store.Service;

import java.util.List;
import java.util.Optional;

import com.Store.models.Category;


public interface CategoryService  {

	public List<Category> getCategories();
	public List<Category> addCategories(Category category);
	public List<Category> updateCategories(String Category , int id);
	public List<Category> deletecategories(int id);
	public Optional<Category> findById(int id);
	List<Category> getCategories(Integer pageNumber, Integer pageSize);
}
