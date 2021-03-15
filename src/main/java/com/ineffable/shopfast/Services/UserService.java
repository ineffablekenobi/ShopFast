package com.ineffable.shopfast.Services;

import com.ineffable.shopfast.Entities.User;
import com.ineffable.shopfast.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public void createUser(User user){
        userRepo.save(user);
    }

    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        Iterator<User> itr = userRepo.findAll().iterator();
        while (itr.hasNext()){
            list.add(itr.next());
        }
        return list;
    }

}
