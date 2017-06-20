package com.mindtree.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.exception.ServiceException;
import com.mindtree.model.Customer;
import com.mindtree.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@Api(value="/customers",description="This resource contains CRUD opeartions for Customer")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepo;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired	
	private MessageSource messageSource;

	@ApiOperation(notes="This will retrieve all Customer",value="Getting all cutomers")
	@RequestMapping(value = "/customers", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<Customer> getCustomers(Pageable page, @RequestParam("lastName") Optional<String> lastName) {
		if(logger.isDebugEnabled()){
			logger.debug("Enter to getcutomer method");
		}
		
		if (lastName.isPresent()) {
			logger.info("lastname ==" + lastName.get());
			return customerRepo.findByLastName(lastName.get()).get();
		}
		return customerRepo.findAll(page).getContent();
	}

	@ApiOperation(notes="This will retrieve customer based on id",value="Getting matching customer")
	@RequestMapping(value = "/customers/{id}", method = RequestMethod.GET,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public Customer getCustomer(@PathVariable("id") String id) {
		logger.info("Retrieve customer with id==" + id);
		Customer customer = customerRepo.findOne(id);
		Locale locale = LocaleContextHolder.getLocale();
		String errorMessage = messageSource.getMessage("error.bad.customer.id", null, locale);
		if (customer == null) {
			throw new ServiceException(404, errorMessage + id, null);
		}
		return customer;
	}

	@ApiOperation(notes="This will add a customer",value="Posting")
	@Transactional
	@RequestMapping(value = "/customers", method = RequestMethod.POST,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void addCustomers(@RequestBody Customer customer) {
		logger.info("Add customer");
		customerRepo.save(customer);
	}

	@ApiOperation(notes="This will update a customer",value="updating a customer")
	@RequestMapping(value = "/customers/{Id}", method = RequestMethod.PUT,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void updateCustomers(@RequestBody Customer customer,@PathVariable("Id") String id) {
		logger.info("Updated the customer with id==" + id);
		customer.setId(id);
		customerRepo.save(customer);
	}

	@ApiOperation(notes="This will remove a customer",value="removing a customer")
	@RequestMapping(value = "/customers/{Id}", method = RequestMethod.DELETE,produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public void deleteCustomers(@PathVariable("Id") String id) {
		logger.info("Deleted the customer with id==" + id);
		customerRepo.delete(id);
	}

}
