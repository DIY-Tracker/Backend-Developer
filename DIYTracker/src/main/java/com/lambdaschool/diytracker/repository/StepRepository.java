package com.lambdaschool.diytracker.repository;

import com.lambdaschool.diytracker.models.Step;
import org.springframework.data.repository.CrudRepository;

public interface StepRepository extends CrudRepository<Step, Long> {
}
