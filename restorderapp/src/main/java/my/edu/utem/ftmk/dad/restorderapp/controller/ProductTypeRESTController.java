package my.edu.utem.ftmk.dad.restorderapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.restorderapp.model.ProductType;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductTypeRepository;

@RestController
@RequestMapping("/api/producttypes")
public class ProductTypeRESTController {

	@Autowired
	private ProductTypeRepository productTypeRepository;

	//For class ProductType
	
	//retrieve all product details
	@GetMapping
	public List<ProductType> getProduct()
	{
		return productTypeRepository.findAll();
	}
	
	//retrieve product type detail based on productType ID
	@GetMapping("{productTypeId}")
	public ProductType getProductType(@PathVariable int productTypeId)
	{
		ProductType productType = productTypeRepository.findById(productTypeId).get();
		
		return productType;
	}	
	
	//adding records for new product type
	@PostMapping
	public ProductType insertProduct(@RequestBody ProductType productType)
	{
		return productTypeRepository.save(productType);
	}
	
	//update details for a certain product type
	@PutMapping
	public ProductType updateProduct(@RequestBody ProductType productType)
	{
		return productTypeRepository.save(productType);
	}
	
	//delete record based on Product Type ID
	@DeleteMapping("{productTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable int productTypeId)
	{
		productTypeRepository.deleteById(productTypeId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
	
}