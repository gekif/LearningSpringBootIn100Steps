package com.gekif.springboot.repository;

import com.gekif.springboot.jpa.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {



}
