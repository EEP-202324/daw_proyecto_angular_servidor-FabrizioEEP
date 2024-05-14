package com.example.pabellon;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

@JsonTest
public class PabellonJsonTest {
	@Autowired
    private JacksonTester<Pabellon> json;

    @Test
    void pabellonSerializationTest() throws IOException {
        Pabellon pabellon = new Pabellon(1, "amount", "ubicacion", 100, FuncionalidadTipo.AUDITORIO, true, "foto",  new Date(System.currentTimeMillis()));
        assertThat(json.write(pabellon)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(pabellon)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(pabellon)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        assertThat(json.write(pabellon)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(pabellon)).extractingJsonPathNumberValue("@.amount")
             .isEqualTo(123.45);
    }
}

/* package example.cashcard;


class CashCardJsonTest {

    
} */