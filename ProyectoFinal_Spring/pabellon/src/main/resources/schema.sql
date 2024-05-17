
CREATE TABLE pabellon
(
    id bigint generated always as (identity) primary key,
    nombre varchar(20),
	ubicacion varchar(20),
	aforo int,
	funcionalidad ENUM('Auditorio', 'Aula', 'Laboratorio'),
	disponibilidad boolean,
	photo varchar(100),
	fechaDisponibilidad Date
);
