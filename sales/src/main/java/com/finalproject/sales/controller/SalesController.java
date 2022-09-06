package com.finalproject.sales.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.finalproject.sales.entities.Sales;
import com.finalproject.sales.repository.SalesRepository;
import com.finalproject.sales.response.Response;

@RestController
public class SalesController {
	@Autowired
    private SalesRepository salesRepository;
	
	 @RequestMapping(value = "/sales", method = RequestMethod.GET)
	    public List<Sales> Get() {
	        return salesRepository.findAll();
	    }
	
	 @RequestMapping(value = "/sales", method =  RequestMethod.POST)
	    public ResponseEntity<Response<Sales>> Post(@Valid @RequestBody Sales Sales, BindingResult result)
	    {
	    	Response<Sales> response = new Response<Sales>();    	
	    	if (result.hasErrors()) {
	    		result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
	    		return ResponseEntity.badRequest().body(response);
	    	}
	    	salesRepository.save(Sales);
	    	response.setData(Sales);
	        return ResponseEntity.ok(response);
	    }
	 @RequestMapping(value = "/sales/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<Response<Sales>> Put(@PathVariable(value = "id") long id, @Valid @RequestBody
			 								Sales newsales, BindingResult result)
	 {
		 Optional<Sales> oldSales = salesRepository.findById(id);
		 Response<Sales> response = new Response<Sales>();
		 if (result.hasErrors()) {
			 result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			 return ResponseEntity.badRequest().body(response);
		 }
		 if(oldSales.isPresent()){
	        	Sales sales = oldSales.get();
	        	sales.setCliente(newsales.getCliente());
	        	sales.setDataInstalacao(newsales.getDataInstalacao());
	        	sales.setDataPedido(newsales.getDataPedido());
	        	sales.setPreco(newsales.getPreco());
	        	sales.setVelocidade(newsales.getVelocidade());
	            response.setData(sales);
	            salesRepository.save(sales);
	            return ResponseEntity.ok(response);
	        }
		 else
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
	 @RequestMapping(value = "/sales/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	 {
		 Optional<Sales> Sales = salesRepository.findById(id);
		 if(Sales.isPresent()) {
			 salesRepository.delete(Sales.get());
			 return new ResponseEntity<>(HttpStatus.OK);
		 }
		 else
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	 }
}
