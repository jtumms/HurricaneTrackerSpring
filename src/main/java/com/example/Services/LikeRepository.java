package com.example.Services;

import com.example.Entitities.Hurricane;
import com.example.Entitities.Like;
import com.example.Entitities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by john.tumminelli on 10/28/16.
 */
public interface LikeRepository extends CrudRepository<Like, Integer> {
    Like findFirstByUserAndHurricane(User user, Hurricane hurricane);
    List<Like> findByUser(User user);
}
