package com.example.pabellon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pabellones")
public class PabellonController {
	
	@GetMapping("/{requestedId}")
	private ResponseEntity<Pabellon> findById(@PathVariable Long requestedId) {
		if(requestedId.equals(99L)) {
		Pabellon pabellon = new Pabellon(99L, "pabellon2", "", 0, FuncionalidadTipo.OTRO,true ,"");
		return ResponseEntity.ok(pabellon);
		} else {
		return ResponseEntity.notFound().build();
		}
	}
}
