package com.Store.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Store.models.Product;

public interface Productrepo extends JpaRepository<Product, Integer> {

//	public List<Product> findById(int pid);
}
