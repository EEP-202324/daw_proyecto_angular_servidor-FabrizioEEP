package com.example.pabellon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PabellonRepository extends CrudRepository<Pabellon, Long>,
PagingAndSortingRepository<Pabellon, Long>{
}
