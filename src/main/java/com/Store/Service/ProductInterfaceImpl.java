package com.Store.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Store.Repository.Productrepo;
import com.Store.models.Category;
import com.Store.models.Product;

@Service
public class ProductInterfaceImpl implements ProductInterface {

	@Autowired
	private Productrepo repo;

	@Override
	public List<Product> getProducts() {
		return repo.findAll();
	}

	@Override
	public List<Product> addProducts(Product products) {
		try {
			repo.save(products);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repo.findAll();
	}



	@Override
	public List<Product> deleteProducts(int pid) {
		if (repo.findById(pid).isPresent() == false) {
			return null;
		} else {
			repo.deleteById(pid);
			return repo.findAll();
		}

	}

	@Override
	public List<Product> updateProducts(String pname, int pid) {
		if (repo.findById(pid).get() != null && repo.findById(pid).isPresent()) {
			Product prod = repo.findById(pid).get();
			prod.setPname(pname);
			repo.save(prod);
			return repo.findAll();

		} else {
			return null;
		}

	}

	@Override
	public Optional<Product> getIdByProduct(int pid) {
		// TODO Auto-generated method stub
		return repo.findById(pid);
	}

	@Override
	public List<Product> getProducts(Integer page, Integer Size) {
		
		Pageable p1 = PageRequest.of(page, Size);
		
		Page<Product> lp = this.repo.findAll(p1); 
		
		List<Product> prod = lp.getContent();
		
		return prod;
	}

	
	
	
}
