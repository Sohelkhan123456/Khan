package com.Store.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Store.Service.CategoryServiceimpl;
import com.Store.models.Category;
import com.Store.models.Product;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryServiceimpl service;

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories(@RequestParam(value="pageNumber" ,defaultValue="0" , required = true) Integer pageNumber ,@RequestParam(value="pageSize" ,defaultValue="1" , required = false) Integer pageSize ) {
		List<Category> category = service.getCategories(pageNumber ,pageSize);
		return new ResponseEntity<>(category, HttpStatus.OK);
	}

	@PostMapping("/categories")
	public List<Category> addCategories(@RequestBody Category category) {
		return service.addCategories(category);
	}

	@PutMapping("/categories")
	public List<Category> updateCategories(@RequestParam("category") String Category, @RequestParam("id") int id) {
		return service.updateCategories(Category, id);
	}

	@DeleteMapping("/categories/{id}")
	public List<Category> deleteCategories(@PathVariable("id") int id) {
		return service.deletecategories(id);

	} 
	
	@GetMapping("/categories/{id}")
	public Optional<Category> findById(@PathVariable("id") int id){
		return service.findById(id);
	}
}
