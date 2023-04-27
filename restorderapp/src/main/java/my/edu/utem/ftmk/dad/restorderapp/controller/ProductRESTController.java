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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;
import my.edu.utem.ftmk.dad.restorderapp.repository.ProductRepository;

@RestController
@RequestMapping("/api/products")
public class ProductRESTController {
	
	@Autowired
	private ProductRepository productRepository;

	//For class Product
	
	//find the product where name is "Mc Chicken"
	@GetMapping("/findbyname")
	public Iterable<Product> SearchProductByName() 
	{
		return productRepository.findByName("Mc Chicken");
	}
	
	//find the product details based on name and price given
	@GetMapping("/{name}/{price}")
	public List<Product> SearchProductByNameAndPrice(@PathVariable String name, @PathVariable double price) 
	{
		return productRepository.findByNameAndPrice(name, price);

	}
	
	//retrieve all product details
	@GetMapping
	public List<Product> getProduct()
	{
		return productRepository.findAll();
	}
	
	//adding records for new product
	@PostMapping
	public Product insertProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}
	
	//update details for a certain product
	@PutMapping
	public Product updateProduct(@RequestBody Product product)
	{
		return productRepository.save(product);
	}
	
	//delete record based on Product Type ID
	@DeleteMapping("{productTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable int productId)
	{
		productRepository.deleteById(productId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}