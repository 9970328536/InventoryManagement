package com.Project.InventoryManagment.Exception;



import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers {
 
	@ExceptionHandler(GivenIdNotFoundException.class)
	public ResponseEntity<Object> handleGivenIdNotFoundException() {
		return new ResponseEntity<Object>("Given Id Is Not Avilable.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<Object> hendleNoRecordFoundException(){
	return new ResponseEntity<Object>("Reorde is Not Avilable.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(GivenNameNotFoundException.class) 
	public ResponseEntity<Object> handleNameNotFoundException(){
		return new ResponseEntity<Object>("Name Not Avilabe.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PriceNotFoundException.class)
	public ResponseEntity<String> handlePriceNotFoundException(){
		return new ResponseEntity<String>("Price Not Found In Rcord", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<String> handleEmailNotFoundException(){
		return new ResponseEntity<String>("Email Not Found In Rcord", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ContactNotFoundException.class)
	public ResponseEntity<String> handleContactNotFoundException(){
		return new ResponseEntity<String>("Email Not Found In Rcord", HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<String> handleAddresssNotFoundException(){
		return new ResponseEntity<String>("Email Not Found In Rcord", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CostNotFoundException.class)
	public ResponseEntity<String> handleCostNotFoundException(){
		return new ResponseEntity<String>("Email Not Found In Rcord", HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(value= {MethodArgumentNotValidException.class })
	public ResponseEntity<Map<String, String> >handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
		
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	    	
	        String fieldName =  ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	        
	    });
	    return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecordAlreadyExistException.class)
	public ResponseEntity<Object> hendleRecordAlreadyExistException(){
	return new ResponseEntity<Object>("Reorde is Already Exist.", HttpStatus.FOUND);
	}
}

