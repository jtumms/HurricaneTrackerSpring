package com.example.Controllers;

import com.example.Entitities.Hurricane;
import com.example.Entitities.Like;
import com.example.Entitities.User;
import com.example.Services.HurricaneRepository;
import com.example.Services.LikeRepository;
import com.example.Services.UserRepository;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by john.tumminelli on 10/28/16.
 */
@RestController
public class HurricaneRestController {
    @Autowired
    HurricaneRepository hurricanes;

    @Autowired
    UserRepository users;

    @Autowired
    LikeRepository likes;

    @RequestMapping(path = "/hurricanes.json", method = RequestMethod.GET)
    public Iterable<Hurricane> gerHurricanes() {
        return hurricanes.findAll();
    }
    @RequestMapping(path = "/liked-hurricanes.json", method = RequestMethod.GET)
    public List<Hurricane> getLikedHurricanes(HttpSession session) {
        String name = (String) session.getAttribute("username");
        User user = users.findFirstByName(name);
        ArrayList<Hurricane> likedHurricanes = new ArrayList<>();
        for (Like like: likes.findByUser(user)) {
            likedHurricanes.add(like.hurricane);
        }
        return likedHurricanes;
    }
}
