package com.example.pabellon;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pabellones")
public class PabellonController {

	private final PabellonRepository pabellonRepository;
	
	public PabellonController(PabellonRepository pabellonRepository) {
		this.pabellonRepository = pabellonRepository;
	}

	@GetMapping("/{requestedId}")
	public ResponseEntity<Pabellon> findById(@PathVariable Long requestedId) {
		Optional<Pabellon> pabellonOptional = pabellonRepository.findById(requestedId);
	    if (pabellonOptional.isPresent()) {
	        return ResponseEntity.ok(pabellonOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
