package com.example.pabellon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pabellon")
public class PabellonController {
	
	@GetMapping("/{requestId}")
	private ResponseEntity<String> findById() {
		return ResponseEntity.ok("{}");
		}
}
