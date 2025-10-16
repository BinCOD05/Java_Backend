package spring.web.CustomException;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomExcpetion extends RuntimeException{
	public CustomExcpetion(String ms) {
		super(ms);
	}
}
