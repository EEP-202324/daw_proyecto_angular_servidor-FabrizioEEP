package com.example.pabellon;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PabellonApplicationTests {

	@Autowired
    TestRestTemplate restTemplate;

    @Test
    void shouldReturnAPabellonWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/pabellones/99", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        
        Number id = documentContext.read("$.id");
        assertThat(id).isEqualTo(99);
        
        String nombre = documentContext.read("$.nombre");
        assertThat(nombre).isEqualTo("pabellon2");
    }
    
    @Test
    void shouldNotReturnAPabellonWithAnUnknownId() {
      ResponseEntity<String> response = restTemplate.getForEntity("/pabellones/1000", String.class);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
      assertThat(response.getBody()).isBlank();
    }
    
    @Test
    void shouldCreateANewPabellon() {
       Pabellon newPabellon = new Pabellon(null, "pabellon3", "Paris", 100, true, "ruta/a/la/foto.jpg");
       ResponseEntity<Void> createResponse = restTemplate.postForEntity("/pabellones", newPabellon, Void.class);
       assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
       
       URI locationOfNewPabellon = createResponse.getHeaders().getLocation();
       ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewPabellon, String.class);
       assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
       
       DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
       Number id = documentContext.read("$.id");
       String nombre = documentContext.read("$.nombre");
       String ubicacion = documentContext.read("$.ubicacion");
       Number aforo = documentContext.read("$.aforo");
       Boolean disponibilidad = documentContext.read("$.disponibilidad");
       String photo = documentContext.read("$.photo");

       assertThat(id).isNotNull();
       assertThat(nombre).isEqualTo("pabellon3");
       assertThat(ubicacion).isEqualTo("Paris");
       assertThat(aforo).isEqualTo(100);
       assertThat(disponibilidad).isTrue();
       assertThat(photo).isEqualTo("ruta/a/la/foto.jpg");

    }

}
