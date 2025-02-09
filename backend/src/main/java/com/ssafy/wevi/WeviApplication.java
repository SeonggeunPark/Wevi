package com.ssafy.wevi;

import com.ssafy.wevi.domain.schedule.Consultation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class WeviApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeviApplication.class, args);

		Consultation consultation = new Consultation();
		consultation.setStartTime(LocalDateTime.MIN);
		consultation.setEndTime(LocalDateTime.MIN);
		consultation.setTitle("d");
	}

}
