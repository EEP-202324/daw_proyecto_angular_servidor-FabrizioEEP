package com.example.pabellon;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.JSONArray;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
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
        assertThat(nombre).isEqualTo("pabellon1");
    }
    
    @Test
    void shouldNotReturnAPabellonWithAnUnknownId() {
      ResponseEntity<String> response = restTemplate.getForEntity("/pabellones/1000", String.class);

      assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
      assertThat(response.getBody()).isBlank();
    }
    
    @Test
	@DirtiesContext
    void shouldCreateANewPabellon() {
       Pabellon newPabellon = new Pabellon(101L, "pabellon3", "Paris", 100, true, "ruta/a/la/foto.jpg");
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
    
    @Test
    void shouldReturnAllPabellonesWhenListIsRequested() {
        ResponseEntity<String> response = restTemplate.getForEntity("/pabellones", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        int pabellonCount = documentContext.read("$.length()");
        assertThat(pabellonCount).isEqualTo(3);

        JSONArray ids = documentContext.read("$..id");
        assertThat(ids).containsExactlyInAnyOrder(99, 100, 1052);

        JSONArray nombres = documentContext.read("$..nombre");
        assertThat(nombres).containsExactlyInAnyOrder("pabellon1", "pabellon2", "pabellon3");
    }
    
    @Test
    void shouldReturnAPageOfPabellones() {
        ResponseEntity<String> response = restTemplate.getForEntity("/pabellones?page=0&size=1", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        JSONArray page = documentContext.read("$[*]");
        assertThat(page.size()).isEqualTo(1);
    }
    
    @Test
    void shouldReturnASortedPageOfPabellones() {
        ResponseEntity<String> response = restTemplate.getForEntity("/pabellones?page=0&size=1&sort=nombre,asc", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        JSONArray read = documentContext.read("$[*]");
        assertThat(read.size()).isEqualTo(1);

        String nombre = documentContext.read("$[0].nombre");
        assertThat(nombre).isEqualTo("pabellon1");
    }

//    @Test
//    void shouldReturnASortedPageOfPabellonWithNoParametersAndUseDefaultValues() {
//        ResponseEntity<String> response = restTemplate.getForEntity("/pabellones", String.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        DocumentContext documentContext = JsonPath.parse(response.getBody());
//        JSONArray page = documentContext.read("$[*]");
//        assertThat(page.size()).isEqualTo(3);
//
//        JSONArray nombres = documentContext.read("$..nombre");
//        assertThat(nombres).containsExactly("pabellon1", "pabellon2", "pabellon3");
//    }
//    
//    @Test
//    @DirtiesContext
//    void shouldUpdateAnExistingPabellon() {
//        Pabellon pabellonUpdate = new Pabellon(null, "pabellon4", "", 0, true, "");
//        HttpEntity<Pabellon> request = new HttpEntity<>(pabellonUpdate);
//        ResponseEntity<Void> response = restTemplate
//                .exchange("/pabellones/99", HttpMethod.PUT, request, Void.class);
//        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
//
//  	  ResponseEntity<String> getResponse = restTemplate
//  	          .getForEntity("/pabellones/99", String.class);
//  	  assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
//  	  DocumentContext documentContext = JsonPath.parse(getResponse.getBody());
//  	  Number id = documentContext.read("$.id");
//  	  String nombre = documentContext.read("$.nombre");
//  	  assertThat(id).isEqualTo(99);
//  	  assertThat(nombre).isEqualTo("pabellon4");
//    }
    
}
