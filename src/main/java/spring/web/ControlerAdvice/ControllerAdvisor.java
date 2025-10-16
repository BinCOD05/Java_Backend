package spring.web.ControlerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import spring.web.CustomException.CustomExcpetion;
import spring.web.model.ErrorResponseDTO;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler{
	@ExceptionHandler (CustomExcpetion.class)
	public ResponseEntity<Object> handleErr(CustomExcpetion ex , WebRequest res) {
			ErrorResponseDTO error = new ErrorResponseDTO() ; 
			error.setError(ex.getMessage());
			List<String> details = new ArrayList<>();
			details.add(" loi roi ");
			error.setDetails(details);
			return new ResponseEntity<Object>(error , HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	

}
