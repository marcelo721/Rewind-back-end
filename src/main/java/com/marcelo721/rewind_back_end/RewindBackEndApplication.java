package com.marcelo721.rewind_back_end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@EnableCaching
@SpringBootApplication
public class RewindBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewindBackEndApplication.class, args);
	}
}
