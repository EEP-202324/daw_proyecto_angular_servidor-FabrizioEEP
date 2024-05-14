package com.example.pabellon;

import java.sql.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pabellon")
public class PabellonController {
	
	@GetMapping("/{requestId}")
	private ResponseEntity<Pabellon> findById() {
        Pabellon pabellon = new Pabellon(99, "Pabellon A", "Ubicación A", 100, FuncionalidadTipo.AUDITORIO, true, "ruta/photo", new Date(System.currentTimeMillis()));
		return ResponseEntity.ok(pabellon);
		}
}
