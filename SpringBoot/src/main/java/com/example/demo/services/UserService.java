package com.example.demo.services;

import com.example.demo.dto.UserPatch;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepo userepo;


    public List<User> getAll() {

        List<User> userList = new ArrayList<>();

        userList.addAll(userepo.findAll());

        return userList;
    }


    public User createUser(User user) {
        return userepo.save(user);
    }

    public Optional<User> getUser(int id) {
        return userepo.findById(id);
    }


    public String deleteUser(int id) {
        try {
            userepo.deleteById(id);
            return "Deleted Successfully...!";
        } catch (Exception e) {
            return null;
        }
    }

    public User updateUser(User user) {
        return userepo.save(user);
    }

    public List<User> pagination(Integer page, Integer size) {
        PageRequest paging = PageRequest.of(page, size);
        return userepo.findAll(paging).getContent();
    }



    public void patchUser(int id, List<UserPatch> patch) {

        patch.forEach(o -> {
            if (o.getAction().equals("update")) {
                if (o.getPath().equals("name"))
                    userepo.findNameReplace(id, o.getValue());
                else if (o.getPath().equals("mail"))
                    userepo.findMailReplace(id, o.getValue());
                else if (o.getPath().equals("address"))
                    userepo.findAddressReplace(id, o.getValue());
                else if (o.getPath().equals("phone"))
                    userepo.findPhoneReplace(id, o.getValue());

    }
            else if (o.getAction().equals("delete")) {
                if (o.getPath().equals("name"))
                    userepo.findNameDelete(id);
                else if (o.getPath().equals("address"))
                    userepo.findAddressDelete(id);
                else if (o.getPath().equals("phone"))
                    userepo.findPhoneDelete(id);
            }
        });
    }
}