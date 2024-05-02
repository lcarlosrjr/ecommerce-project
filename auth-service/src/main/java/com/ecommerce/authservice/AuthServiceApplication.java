package com.ecommerce.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);

//		//Generating a safe HS256 Secret key
//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//		String secretString = Encoders.BASE64.encode(key.getEncoded());
//		System.out.println("Secret key: " + secretString);
	}

}
