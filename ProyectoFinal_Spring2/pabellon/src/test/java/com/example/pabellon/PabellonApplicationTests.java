package com.example.pabellon;

import static org.assertj.core.api.Assertions.assertThat;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

}
