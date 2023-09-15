package com.Store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Store.models.Category;

public interface Categoryrepo extends JpaRepository<Category, Integer> {
	
	public List<Category> getById(int id);
}
