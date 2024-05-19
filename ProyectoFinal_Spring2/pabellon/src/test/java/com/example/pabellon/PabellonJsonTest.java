package com.example.pabellon;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
public class PabellonJsonTest {
	
	@Autowired
	private JacksonTester<Pabellon> json;
	
	@Autowired
	private JacksonTester<Pabellon[]> jsonList;
	
	private Pabellon[] pabellones;
	
	@BeforeEach
	void setUp() {
		pabellones = Arrays.array(
				new Pabellon(99L, "pabellon1", "Londres", 100, true, "ruta/a/la/foto.jpg"),
				new Pabellon(100L, "pabellon2", "Londres", 100, true, "ruta/a/la/foto.jpg"),
				new Pabellon(101L, "pabellon3", "Londres", 100, true, "ruta/a/la/foto.jpg"));
	}

	@Test
	void PabellonSerializationTest() throws IOException {
		Pabellon pabellon = pabellones[0];
	    assertThat(json.write(pabellon)).isStrictlyEqualToJson("single.json");
	    assertThat(json.write(pabellon)).hasJsonPathNumberValue("@.id");
	    assertThat(json.write(pabellon)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
	    
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.nombre");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.nombre").isEqualTo("pabellon1");
	    
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.ubicacion");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.ubicacion").isEqualTo("Londres");
	    
	    assertThat(json.write(pabellon)).hasJsonPathNumberValue("@.aforo");
	    assertThat(json.write(pabellon)).extractingJsonPathNumberValue("@.aforo").isEqualTo(100);
	
	    assertThat(json.write(pabellon)).hasJsonPathBooleanValue("@.disponibilidad");
	    assertThat(json.write(pabellon)).extractingJsonPathBooleanValue("@.disponibilidad").isEqualTo(true);
	    
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.photo");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.photo").isEqualTo("ruta/a/la/foto.jpg");
	}
    
    @Test
    void PabellonDeserializationTest() throws IOException {
       String expected = """
               {
	       		"id": 99,
	       		"nombre": "pabellon1",
	       		"ubicacion": "Londres",
	       		"aforo": 100,
	       		"disponibilidad": true,
	       		"photo": "ruta/a/la/foto.jpg"
       			}
               """;
       Pabellon expectedPabellon = new Pabellon(99L, "pabellon1", "Londres", 100, true, "ruta/a/la/foto.jpg");

       assertThat(json.parse(expected)).isEqualTo(expectedPabellon);
       assertThat(json.parseObject(expected).getId()).isEqualTo(99);
       assertThat(json.parseObject(expected).getNombre()).isEqualTo("pabellon1");
       assertThat(json.parseObject(expected).getUbicacion()).isEqualTo("Londres");
       assertThat(json.parseObject(expected).getAforo()).isEqualTo(100);
       assertThat(json.parseObject(expected).isDisponibilidad()).isEqualTo(true);
       assertThat(json.parseObject(expected).getPhoto()).isEqualTo("ruta/a/la/foto.jpg");
    }
    
    @Test
    void pabellonListSerializationTest() throws IOException {
       assertThat(jsonList.write(pabellones)).isStrictlyEqualToJson("list.json");
    }
    
    @Test
    void cashCardListDeserializationTest() throws IOException {
       String expected="""
             [
    {"id": 99, "nombre": "pabellon1", "ubicacion": "Londres", "aforo": 100, "disponibilidad": true, "photo": "ruta/a/la/foto.jpg"},
    {"id": 100, "nombre": "pabellon2", "ubicacion": "Londres", "aforo": 100, "disponibilidad": true, "photo": "ruta/a/la/foto.jpg"},
    {"id": 101, "nombre": "pabellon3", "ubicacion": "Londres", "aforo": 100, "disponibilidad": true, "photo": "ruta/a/la/foto.jpg"}
             ]
             """;
       assertThat(jsonList.parse(expected)).isEqualTo(pabellones);
    }
  
}
