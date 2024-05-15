package com.example.pabellon;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pabellon")
public class PabellonController {

	private final PabellonRepository pabellonRepository;
	
	public PabellonController(PabellonRepository pabellonRepository) {
		this.pabellonRepository = pabellonRepository;
	}

	@GetMapping("/{requestedId}")
	private ResponseEntity<Pabellon> findById(@PathVariable Long requestedId) {
		if (requestedId.equals(99L)) {
			Pabellon pabellon = new Pabellon(99L, "Pabellon A", "Ubicación A", 100, FuncionalidadTipo.AUDITORIO, true,
					"ruta/photo", new Date(System.currentTimeMillis()));
			return ResponseEntity.ok(pabellon);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
