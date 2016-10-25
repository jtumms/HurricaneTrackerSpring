package com.example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zach on 10/21/16.
 */
public interface HurricaneRepository extends CrudRepository<Hurricane, Integer> {
    List<Hurricane> findByCategory(Hurricane.Category category);
    List<Hurricane> findByLocation(String location);
    List<Hurricane> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String search, String search1);
    List<Hurricane> findByOrderByDateDesc();

    Hurricane findFirstByLocation(String location);
    int countByCategory(Hurricane.Category category);

}