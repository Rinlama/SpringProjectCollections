package com.customer.crm;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerJPARepository extends JpaRepository<Customer, Integer>  {

	
}
