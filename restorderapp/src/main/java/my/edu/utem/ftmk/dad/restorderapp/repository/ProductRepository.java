package my.edu.utem.ftmk.dad.restorderapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.restorderapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByName(String name);
	
	List<Product> findByNameAndPrice(String name, double price);
	
	//List<Product> findByType(int productTypeId);
	
	//@Query("select name and price from product u, productType s where u.productTypeId = s.productTypeId and u.productTypeId = :productTypeId")
	//Product findByProductType(@Param("productTypeId") String productTypeId);

}