package org.sid.lightecom.services;

import java.util.List;

import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	// public Product chercher(Product product){
	// Product p =productRepository.findByName_product(product.getName_product());
	// return p;
	// }
	 
	
	public Page<Product> findByCategory(Long idCategory, String sortedBy, String orderBy) {

		Category category = new Category();
		category.setId(idCategory);

		if (sortedBy != null || !sortedBy.isEmpty()) {
			Sort sort;
			if (orderBy.equals("asc")) {
				sort = Sort.by(sortedBy).ascending();
			} else {
				sort = Sort.by(sortedBy).descending();
			}
			return productRepository.findByCategory(category, PageRequest.of(0, Integer.MAX_VALUE, sort));
		}

		return productRepository.findByCategory(category, PageRequest.of(0, Integer.MAX_VALUE));
	}

	public List<Product> findLastProduct() {
		return productRepository.findTop20ByOrderByIdDesc();
	}
}
