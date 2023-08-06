package com.burakcanciftci.erpweekeight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ErpWeekEightApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpWeekEightApplication.class, args);
	}

}
