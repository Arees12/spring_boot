package com.isgm.intern_training1.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isgm.intern_training1.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
}
