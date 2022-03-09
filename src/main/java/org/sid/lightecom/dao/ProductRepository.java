package org.sid.lightecom.dao;

import java.util.List;

import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	@RestResource(path = "/Name")
	public List<Product> findByNameContains(@Param("mc") String mc);

	@RestResource(path = "/byNameproduit")
	public Page<Product> findByNameContains(@Param("mc") String mc, Pageable pageable);

	public Page<Product> findByOrderByCurentprixAsc(Pageable pageable);

	public Page<Product> findByCategory(Category category, Pageable pageable);
	
	public List<Product> findTop20ByOrderByIdDesc();

}