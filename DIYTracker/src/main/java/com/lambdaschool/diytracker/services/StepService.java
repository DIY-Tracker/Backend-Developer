package com.lambdaschool.diytracker.services;

import com.lambdaschool.diytracker.models.Step;

import java.util.List;

public interface StepService {

    List<Step> findAll();

    Step findById(long id);

    Step save(Step step);

    void delete(long id);

    Step update(Step step, long id, boolean isOwner);

}
