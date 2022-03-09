package org.sid.lightecom.web;

import java.util.List;

import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Product;
import org.sid.lightecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produit")
@CrossOrigin("*")

public class AddproductController {
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public AddproductController(ProductRepository productRepository){
	this.productRepository=productRepository;

	}
	

	@PostMapping(value="/add") 
	public Product save(@RequestBody Product o){
		 return productRepository.save(o);
	}
	

	

	

}
