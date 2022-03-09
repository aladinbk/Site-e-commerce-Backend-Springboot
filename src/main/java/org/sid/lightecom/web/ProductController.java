package org.sid.lightecom.web;

import java.util.List;

import org.sid.lightecom.entities.Product;
import org.sid.lightecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping("/{idCat}")
	public Page<Product> findByCategory(@PathVariable Long idCat, @RequestParam(required = false) String  sortedBy, 
			@RequestParam(required = false) String orderBy ) {
		
		
		return productService.findByCategory(idCat, sortedBy, orderBy);
	}
	
	
	@GetMapping("/last") 
	public List<Product> findLastProduct() {
		return productService.findLastProduct();
	}
	
	
	

}
