package br.com.alura.forum.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Luciano
 * <br> Classe que permite a aplicacao ser chamada por outras origem
 * <br> Exemplo http://localhost:3000 
 */

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST", "PUT",
				"DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}

}
