package com.Store.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Store.Repository.Productrepo;
import com.Store.Service.ProductInterface;
import com.Store.models.Product;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductInterface service;

	@Autowired
	private Productrepo repo;

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(@RequestParam(value="pageNumber" ,defaultValue="3" , required = false) Integer page ,@RequestParam(value="pageSize" ,defaultValue="10" , required = false) Integer Size) {
		List<Product> product = service.getProducts(page,Size);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping("/products")
	public List<Product> addProducts(@RequestBody Product products) {
		return service.addProducts(products);
	}
	
	@PutMapping("/products")
	public List<Product> updateProducts(@RequestParam("name") String pname , @RequestParam("id") int pid){
		return service.updateProducts(pname, pid) ;
	}
	
	@DeleteMapping("/product/{id}")
	public List<Product> deleteProducts(@PathVariable("id") int pid){
		return service.deleteProducts(pid); 
	}
	
	@GetMapping("/products/{id}")
	public Optional<Product> getIdByProduct(@PathVariable("id") int pid){
		return service.getIdByProduct(pid);
	}
	
}
