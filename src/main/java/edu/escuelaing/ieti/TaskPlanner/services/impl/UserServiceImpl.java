package edu.escuelaing.ieti.TaskPlanner.services.impl;

import edu.escuelaing.ieti.TaskPlanner.model.User;
import edu.escuelaing.ieti.TaskPlanner.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        this.users = new ArrayList<User>();
        users.add(new User("1","Carlos Murillo","12345","carlos@mail.co"));
        users.add(new User("2","Pepito Perez","12345","pepito@mail.co"));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User getById(String userId) {
        for(User usr : users){
            if(usr.getId().equals(userId)){
                return usr;
            }
        }
        return null;
    }

    @Override
    public User create(User user) {
        users.add(user);
        return user;
    }

    @Override
    public User update(User user) {
        for(User usr : users){
            if(usr.getId().equals(user.getId())){
                usr.setEmail(user.getEmail());
                usr.setName(user.getName());
                usr.setPassword(user.getPassword());
                return usr;
            }
        }
        return null;
    }

    @Override
    public void remove(String userId) {
        for(int i=0;i<users.size();i++){
            if(users.get(i).getId().equals(userId)){
                users.remove(i);
                return;
            }
        }
    }
}
