package com.example.pabellon;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
public class PabellonJsonTest {
	
	@Autowired
	private JacksonTester<Pabellon> json;

	@Test
	void PabellonSerializationTest() throws IOException {
	    Pabellon pabellon = new Pabellon(99L, "pabellon1", "Londres", 100, FuncionalidadTipo.AUDITORIO, true, "foto");
	    assertThat(json.write(pabellon)).isStrictlyEqualToJson("expected.json");
	    assertThat(json.write(pabellon)).hasJsonPathNumberValue("@.id");
	    assertThat(json.write(pabellon)).extractingJsonPathNumberValue("@.id")
	            .isEqualTo(99);
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.nombre");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.nombre")
	            .isEqualTo("pabellon1");
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.ubicacion");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.ubicacion")
	            .isEqualTo("Londres");
	    assertThat(json.write(pabellon)).hasJsonPathNumberValue("@.aforo");
	    assertThat(json.write(pabellon)).extractingJsonPathNumberValue("@.aforo")
	            .isEqualTo(100);
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.funcionalidad");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.funcionalidad")
	            .isEqualTo("AUDITORIO");
	    assertThat(json.write(pabellon)).hasJsonPathBooleanValue("@.disponibilidad");
	    assertThat(json.write(pabellon)).extractingJsonPathBooleanValue("@.disponibilidad")
	            .isEqualTo(true);
	    assertThat(json.write(pabellon)).hasJsonPathStringValue("@.photo");
	    assertThat(json.write(pabellon)).extractingJsonPathStringValue("@.photo")
	            .isEqualTo("foto");
	}
    
    @Test
    void PabellonDeserializationTest() throws IOException {
       String expected = """
               {
	       		"id": 99,
	       		"nombre": "pabellon1",
	       		"ubicacion": "Londres",
	       		"aforo": 100,
	       		"funcionalidad": "AUDITORIO",
	       		"disponibilidad": true,
	       		"photo": "foto",
	       		"fecha": "2024-05-18T12:34:56Z"
       			}
               """;
       Pabellon expectedPabellon = new Pabellon(99L, "pabellon1", "Londres", 100, FuncionalidadTipo.AUDITORIO, true, "foto");

       assertThat(json.parse(expected)).isEqualTo(expectedPabellon);
       assertThat(json.parseObject(expected).getId()).isEqualTo(99);
       assertThat(json.parseObject(expected).getNombre()).isEqualTo("pabellon1");
       assertThat(json.parseObject(expected).getUbicacion()).isEqualTo("Londres");
       assertThat(json.parseObject(expected).getAforo()).isEqualTo(100);
       assertThat(json.parseObject(expected).getFuncionalidad()).isEqualTo(FuncionalidadTipo.AUDITORIO);
       assertThat(json.parseObject(expected).isDisponibilidad()).isEqualTo(true);
       assertThat(json.parseObject(expected).getPhoto()).isEqualTo("foto");
    }
  
}
