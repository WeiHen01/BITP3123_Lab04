package my.edu.utem.ftmk.dad.restorderapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;

@Repository
public interface OrderTypeRepository extends JpaRepository<OrderType, Long> {

	/*
	 * Lab 11 - Task 2.1 for Find Ordertype by Name
	 * This define a new abstract method named findByNameContaining()
	 * 
	 * @Param partCode
	 * @Return A list of order type data with successfully
	 */
	public abstract List<OrderType> findByNameContaining (String partName);
	
	/*
	 * Lab 11 - Task 3.1
	 * This define a new abstract method named findByCodeStartingWith()
	 * 
	 * @Param partCode
	 * @Return A list of order type data
	 */
	public abstract List<OrderType> findByCodeStartingWith(String partCode);
	
	/*
	 * Lab 11 - Task 5.1
	 * This define a new abstract method named findByOrderByNameAsc()
	 * @Return A list of order type data
	 */
	public abstract List<OrderType> findByOrderByNameAsc();
	
	/*
	 * Lab 11 - Task 8.1
	 * This creates a custom query
	 */
	@Query(value = "select * from OrderType where code like '%PU%'",
			nativeQuery = true)
	public List<Object[]> selectCustomByCode();
}
