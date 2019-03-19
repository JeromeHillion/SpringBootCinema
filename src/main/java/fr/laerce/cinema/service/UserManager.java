package fr.laerce.cinema.service;


import fr.laerce.cinema.dao.UserDao;
import fr.laerce.cinema.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
public class UserManager {


    private UserDao userDao;

    public UserManager(UserDao userDao){
        this.userDao = userDao;
        assert(userDao !=null);
    }


    public User getbyId(long id) {return userDao.findById(id).get();
    }
    public Set<User> getAll(){return userDao.findAllByGivenname();
    }


    public Long save (User user){
    userDao.save(user);
    return user.getId();
    }

    public User remove(User user){
    userDao.delete(user);
    return   user;
    }

  /*  public Long login(User user){
        userDao.login()
    }*/
}

