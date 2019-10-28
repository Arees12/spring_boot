package com.isgm.intern_training1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isgm.intern_training1.entities.City;

@Repository
public interface CityRepository extends CrudRepository<City, Integer>{
	
}
