package com.example.pabellon;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@PostMapping
	private ResponseEntity<Void> createPabellon(@RequestBody Pabellon newPabellonRequest, UriComponentsBuilder ucb){
		Pabellon savedPabellon = pabellonRepository.save(newPabellonRequest);
		URI locationOfNewPabellon = ucb
				.path("pabellones/{id}")
				.buildAndExpand(savedPabellon.getId())
				.toUri();
		return ResponseEntity.created(locationOfNewPabellon).build();
	}
	
	@GetMapping
	private ResponseEntity<List<Pabellon>> findAll(Pageable pageable){
		Page<Pabellon> page = pabellonRepository.findAll(
				PageRequest.of(
						pageable.getPageNumber(),
						pageable.getPageSize(),
						pageable.getSortOr(Sort.by(Sort.Direction.ASC, "nombre"))
		));
		return ResponseEntity.ok(page.getContent());
	}
	
	@PutMapping("/{requestedId}")
	private ResponseEntity<Void> putPabellon(@PathVariable Long requestedId, @RequestBody Pabellon pabellonActualizado) {
	    Optional<Pabellon> optional = pabellonRepository.findById(requestedId);
	    if (optional.isPresent()) {
	        Pabellon pabellon = optional.get();
	        Pabellon updatePabellon = new Pabellon(
	            pabellon.getId(),
	            pabellonActualizado.getNombre(),
	            pabellonActualizado.getUbicacion(),
	            pabellonActualizado.getAforo(),
	            pabellonActualizado.isDisponibilidad(),
	            pabellonActualizado.getPhoto()
	        );
	        pabellonRepository.save(updatePabellon);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> deletePabellon(@PathVariable Long id) {
		pabellonRepository.deleteById(id);
	    return ResponseEntity.noContent().build();
	}


}
