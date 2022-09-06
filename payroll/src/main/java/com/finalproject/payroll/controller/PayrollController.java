package com.finalproject.payroll.controller;

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

import com.finalproject.payroll.entities.PayrollEntity;
import com.finalproject.payroll.repository.PayrollRepository;
import com.finalproject.payroll.response.Response;

@RestController
public class PayrollController {
	
	@Autowired
	private PayrollRepository payrollRepository;
	
	@RequestMapping(value = "/payroll", method = RequestMethod.GET)
	public List<PayrollEntity> Get() {
		return payrollRepository.findAll();
	}
	@RequestMapping(value = "/payroll", method =  RequestMethod.POST)
    public ResponseEntity<Response<PayrollEntity>> Post(@Valid @RequestBody PayrollEntity PayrollEntity, BindingResult result)
    {
    	Response<PayrollEntity> response = new Response<PayrollEntity>();    	
    	if (result.hasErrors()) {
    		result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
    		return ResponseEntity.badRequest().body(response);
    	}
    	payrollRepository.save(PayrollEntity);
    	response.setData(PayrollEntity);
        return ResponseEntity.ok(response);
    }
	@RequestMapping(value = "/payroll/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Response<PayrollEntity>> Put(@PathVariable(value = "id") long id, @Valid @RequestBody 
    													PayrollEntity newpayrollentity, BindingResult result)
    {
        Optional<PayrollEntity> oldPayroll = payrollRepository.findById(id);
    	Response<PayrollEntity> response = new Response<PayrollEntity>();    	
    	if (result.hasErrors()) {
    		result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
    		return ResponseEntity.badRequest().body(response);
    	}        	        
        if(oldPayroll.isPresent()){
        	PayrollEntity payroll = oldPayroll.get();
        	payroll.setNomeFuncionario(payroll.getNomeFuncionario());
        	payroll.setComissao(payroll.getComissao());
        	payroll.setHoras(payroll.getHoras());
        	payroll.setSalario(payroll.getSalario());
            response.setData(payroll);
            payrollRepository.save(payroll);
            return ResponseEntity.ok(response);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }    
    
    @RequestMapping(value = "/payroll/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<PayrollEntity> Payroll = payrollRepository.findById(id);
        if(Payroll.isPresent()){
            payrollRepository.delete(Payroll.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }    

}
