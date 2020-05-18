package com.ssd.mdt.mdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MdtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MdtApplication.class, args);
	}

}
