package com.example.Spring.Rest.Services;

import com.example.Spring.Rest.Exception.ResourceNotFoundException;
import com.example.Spring.Rest.Model.UserModel;
import com.example.Spring.Rest.dto.UserPatch;
import com.example.Spring.Rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    public List<UserModel> getAll(){
        return userRepository.findAll();
    }

    public UserModel getOneUser(String id) {
        Optional<UserModel> user = userRepository.findById(id);
        if(user.isPresent()){
           return user.get();
        }else {
            throw new ResourceNotFoundException("User not found for the with the id: "+id);
        }
    }

    public List<UserModel> pagination(Integer page, Integer size) {
        PageRequest paging = PageRequest.of(page, size);
        return userRepository.findAll(paging).getContent();
    }

    public UserModel create(UserModel user) {
        if (user.getAddress().isEmpty() || user.getMailId().isEmpty() || user.getName().isEmpty() || user.getPhone().isEmpty()){
            throw new IllegalArgumentException("fill all the fields");
        }else {
            return userRepository.save(user);
        }
    }

    public UserModel updateUser(UserModel user) {
            getOneUser(user.getId());
            return create(user);
    }

    public String deleteUser(String id) {
        getOneUser(id);
        userRepository.deleteById(id);
        return "Deleted Successfully..!";
    }

    public UserModel patchUser(String id, List<UserPatch> patch) {
        UserModel user = getOneUser(id);
        patch.forEach(val -> {
            if(val.getAction().equals("update")){
                switch (val.getPath()) {
                    case "name":
                        user.setName(val.getValue());
                        break;
                    case "mail":
                        user.setMailId(val.getValue());
                        break;
                    case "address":
                        user.setAddress(val.getValue());
                        break;
                    case "phone":
                        user.setPhone(val.getValue());
                        break;
                }
            } else if (val.getAction().equals("delete")){
                switch (val.getPath()) {
                    case "name":
                        user.setName(null);
                        break;
                    case "mail":
                        user.setMailId(null);
                        break;
                    case "address":
                        user.setAddress(null);
                        break;
                    case "phone":
                        user.setPhone(null);
                        break;
                }
            }
        });
        userRepository.save(user);
        return user;
    }


}
