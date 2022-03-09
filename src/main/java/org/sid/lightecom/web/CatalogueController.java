package org.sid.lightecom.web;

import org.sid.lightecom.dao.CategoryRepository;
import org.sid.lightecom.dao.ProductRepository;
import org.sid.lightecom.dao.UsersRepository;
import org.sid.lightecom.entities.Category;
import org.sid.lightecom.entities.Product;
import org.sid.lightecom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController 

public class CatalogueController {

private ProductRepository productRepository;
private CategoryRepository categoryRepository;

public CatalogueController(ProductRepository productRepository, CategoryRepository categoryRepository){
this.productRepository=productRepository;
this.categoryRepository=categoryRepository;
}


/*    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found for this id :: " + id));
        return ResponseEntity.ok().body(product);
    }*/
	
   
   
	@DeleteMapping(value="/deleteproduit/{id}")
	public void delete(@PathVariable(name="id") Long id) {
		productRepository.deleteById(id);
	} 

	  @PutMapping("/editproduit/{id}")
	    public Product save(@PathVariable Long id,@RequestBody Product c) {
		  c.setId(id);
		  return productRepository.save(c);
	    }
    @GetMapping("/categorie/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Category categorie = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("categorie not found for this id :: " + id));
        return ResponseEntity.ok().body(categorie);
    }
	@RequestMapping(value="/modcategorie/{id}",method=RequestMethod.PUT) 
	public Category save(@PathVariable Long id,  @RequestBody Category c){
	   c.setId(id);
		return categoryRepository.save(c);
	}
	@RequestMapping(value="/addcat",method=RequestMethod.POST) 
	public Category savecat(@RequestBody Category c){
		 return categoryRepository.save(c);
	}
	@DeleteMapping(value="/deletecat/{id}")
	public void deleteCat(@PathVariable(name="id") Long id) {
		categoryRepository.deleteById(id);
	}

    /* Web api REST Post UploadPhotoPourUnOffre dans un Dosier Offres et Enregistrer le nom du Photo Avec Spring DataRest */
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception {

        Product o=productRepository.findById(id).get();
        o.setPhotoName(file.getOriginalFilename());
        Files.write(Paths.get("images/"+o.getPhotoName()),file.getBytes());
        productRepository.save(o);

    }

    /* Web api REST Get getlesPhotosdesoffres*/
    @GetMapping(path="/photoOffres/{id}",produces = MediaType.IMAGE_PNG_VALUE)

    public byte[] getPhoto(@PathVariable("id") Long id) throws IOException {

        Product o=productRepository.findById(id).get();
        File serverFile = new File("images\\"+o.getPhotoName());
        System.out.println("serverFile : " + serverFile);
        return Files.readAllBytes(serverFile.toPath());

    }
    /* Web api REST Post UploadPhotoPourUnOffre dans un Dosier Offres et Enregistrer le nom du Photo Avec Spring DataRest */
    @PostMapping(path = "/uploadPhoto2/{id}")
    public void uploadPhoto2(MultipartFile file, @PathVariable Long id) throws Exception {

        Product o=productRepository.findById(id).get();
        o.setPhotoName2(file.getOriginalFilename());
        Files.write(Paths.get("images/"+o.getPhotoName2()),file.getBytes());
        productRepository.save(o);

    }
    /* Web api REST Get getlesPhotosdesoffres*/
    @GetMapping(path="/photoOffres2/{id}",produces = MediaType.IMAGE_PNG_VALUE)

    public byte[] getPhoto2(@PathVariable("id") Long id) throws IOException {

        Product o=productRepository.findById(id).get();
        File serverFile = new File("images\\"+o.getPhotoName2());
        System.out.println("serverFile : " + serverFile);
        return Files.readAllBytes(serverFile.toPath());

    }
    /* Web api REST Post UploadPhotoPourUnOffre dans un Dosier Offres et Enregistrer le nom du Photo Avec Spring DataRest */
    @PostMapping(path = "/uploadPhoto3/{id}")
    public void uploadPhoto3(MultipartFile file, @PathVariable Long id) throws Exception {

        Product o=productRepository.findById(id).get();
        o.setPhotoName3(file.getOriginalFilename());
        Files.write(Paths.get("images/"+o.getPhotoName3()),file.getBytes());
        productRepository.save(o);

    }
    /* Web api REST Get getlesPhotosdesoffres*/
    @GetMapping(path="/photoOffres3/{id}",produces = MediaType.IMAGE_PNG_VALUE)

    public byte[] getPhoto3(@PathVariable("id") Long id) throws IOException {

        Product o=productRepository.findById(id).get();
        File serverFile = new File("images\\"+o.getPhotoName3());
        System.out.println("serverFile : " + serverFile);
        return Files.readAllBytes(serverFile.toPath());

    }

}
