package com.example.pabellon;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pabellones")
public class PabellonController {
	
	@Autowired
	private final PabellonRepository pabellonRepository;

	   private PabellonController(PabellonRepository pabellonRepository) {
	      this.pabellonRepository = pabellonRepository;
	   }
	
	@GetMapping("/{requestedId}")
	private ResponseEntity<Pabellon> findById(@PathVariable Long requestedId) {
		Optional<Pabellon> pabellonOptional = pabellonRepository.findById(requestedId);
		if(pabellonOptional.isPresent()) {
		return ResponseEntity.ok(pabellonOptional.get());
		} else {
		return ResponseEntity.notFound().build();
		}
	}
}
