package spring.web.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.*;

@Configuration
public class ModelMapperConfig {
	
	@Bean 
	public ModelMapper modelMapper() {
		return new ModelMapper() ; 
	}
}
