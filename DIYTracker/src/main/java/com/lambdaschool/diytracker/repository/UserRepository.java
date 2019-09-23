package com.lambdaschool.diytracker.repository;

import com.lambdaschool.diytracker.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
