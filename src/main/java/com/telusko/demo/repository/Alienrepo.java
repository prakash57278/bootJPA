package com.telusko.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.telusko.demo.model.Alien;

public interface Alienrepo extends CrudRepository<Alien, Integer> {

    List<Alien> findByTech(String string);

    List<Alien> findByAidGreaterThan(int aid);

    @Query("from Alien where tech=?1 order by aname")
    List<Alien> findByTechSorted(String string);
}

