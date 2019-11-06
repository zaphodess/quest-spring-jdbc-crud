package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.School;

import java.util.List;

public class SchoolRepository implements CrudRepository<School> {

    private final static String DB_URL = "jdbc:mysql://localhost:3306/spring_jdbc_quest?serverTimezone=GMT";
    private final static String DB_USER = "h4rryp0tt3r";
    private final static String DB_PASSWORD = "Horcrux4life!";

    @Override
    public School save(School entity) {

        // TODO Create
        return null;
    }

    @Override
    public School findById(Long id) {

        // TODO Read one
        return null;
    }

    @Override
    public List<School> findAll() {

        // TODO Read all
        return null;
    }

    @Override
    public School update(School entity) {

        // TODO Update
        return null;
    }

    @Override
    public void deleteById(Long id) {

        // TODO Delete
    }
}
