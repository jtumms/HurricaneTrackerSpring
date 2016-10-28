package com.example.Services;

import com.example.Entitities.Hurricane;
import com.example.Entitities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by zach on 10/21/16.
 */
public interface HurricaneRepository extends CrudRepository<Hurricane, Integer> {
    public List<Hurricane> findByUser(User user);
    public List<Hurricane> findByCategory(Hurricane.Category category);
    public List<Hurricane> findByLocation(String location);
    public List<Hurricane> findByNameContainingIgnoreCaseOrLocationContainingIgnoreCase(String search, String search1);
    public List<Hurricane> findByOrderByDateDesc();


    Hurricane findFirstByLocation(String location);
    int countByCategory(Hurricane.Category category);

}