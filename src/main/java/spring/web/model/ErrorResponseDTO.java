package spring.web.model;

import java.util.*;

public class ErrorResponseDTO {
//		private String error ; 
		private String error ; 
		private List<String> details ;
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		public List<String> getDetails() {
			return details;
		}
		public void setDetails(List<String> details) {
			this.details = details;
		} 
		
}
