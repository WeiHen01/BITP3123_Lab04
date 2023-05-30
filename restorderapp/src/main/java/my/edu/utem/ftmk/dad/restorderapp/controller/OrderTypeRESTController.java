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

import my.edu.utem.ftmk.dad.restorderapp.model.OrderType;
import my.edu.utem.ftmk.dad.restorderapp.repository.OrderTypeRepository;

/*
 * This REST Controller request REST web service in PROVIDER site
 * 
 * Only code segment from Line 44 to 96 is where program code for Lab Week 11 is implemented 
 * @Author Ng Wei Hen
 * 
 */

@RestController
@RequestMapping("/api/ordertypes")
public class OrderTypeRESTController {

	@Autowired
	private OrderTypeRepository orderTypeRepository;
	
	// delete order type record based on Id
	@DeleteMapping("{orderTypeId}")
	public ResponseEntity<HttpStatus> deleteOrderType(@PathVariable long orderTypeId)
	{
		orderTypeRepository.deleteById(orderTypeId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/*
	 * Lab Week 11 Task 2 - Find Order Type by Name
	 * This method find order type data according to the order type's name.
	 * 
	 * @param orderType
	 * @return A list of order types record.
	 */
	@RequestMapping("/find/name")
	public List<OrderType> findOrderType (@RequestBody OrderType orderType)
	{
		List<OrderType> orderTypes = orderTypeRepository.findByNameContaining(orderType.getName());
		return orderTypes;
	}
	
	/*
	 * Lab Week 11 Task 3 - Find Order Type by Code
	 * This method find order type data according to the order type's partial code.
	 * 
	 * @param partCode
	 * @return A list of order types record.
	 */
	@RequestMapping("/find/code/{partCode}")
	public List<OrderType> findOrderType(@PathVariable String partCode)
	{
		List<OrderType> orderTypes = orderTypeRepository.findByCodeStartingWith(partCode);
		return orderTypes;
	}
	
	/*
	 * Lab Week 11 Task 4 - Count Order Type Data
	 * This method count number of order type data.
	 * 
	 * @return A long data type of number
	 */
	@RequestMapping("/count")
	public long countOrderType()
	{
		long number = orderTypeRepository.count();
		return number;
	}
	
	/*
	 * Lab Week 11 Task 5 - Retrieve a sorted Order Type Data
	 *  This method retrieves a list of order type data sorted in ascending order.
	 * 
	 * @param orderType
	 * @return A list of order type data
	 */
	@GetMapping("/asc")
	public List<OrderType> findSortedOrderTypeName()
	{
		return orderTypeRepository.findByOrderByNameAsc();
	}
		
	// retrieve all order types detail
	@GetMapping
	public List<OrderType> getOrderTypes()
	{
		return orderTypeRepository.findAll();
		
	}
	
	// retrieve product detail based on product ID
	@GetMapping("{orderTypeId}")
	public OrderType getOrderType(@PathVariable long orderTypeId)
	{
		OrderType orderType = orderTypeRepository.findById(orderTypeId).get();
		
		return orderType;
	}
	
	// insert records for order type
	@PostMapping
	public OrderType insertOrderType(@RequestBody OrderType orderType)
	{
		return orderTypeRepository.save(orderType);
	}
	
	// update records for order type
	@PutMapping
	public OrderType updateOrderType(@RequestBody OrderType orderType)
	{
		return orderTypeRepository.save(orderType);
	}
	
}