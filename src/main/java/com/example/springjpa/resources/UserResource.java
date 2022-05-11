package com.example.springjpa.resources;

import com.example.springjpa.controller.UserController;
import com.example.springjpa.model.User;
import com.example.springjpa.model.UserDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(UserResource.USER_RESOURCE)
public class UserResource {
    public final static String USER_RESOURCE = "v0/users";
    UserController userController;

    @Autowired
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @GetMapping
    public List<UserDto> usersDto(){
        return userController.getAllUsers();
    }

    @GetMapping("{id}")
    public UserDto user(@PathVariable("id") int id){
        return userController.getUser(id);
    }

    @GetMapping("{id}/email")
    public Map<String,String> email(@PathVariable("id") int id){
        return Collections.singletonMap("email",userController.getUser(id).getEmail());
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userdto){
        userController.addUser(userdto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id){
        userController.deleteUser(id);
    }

    @PutMapping("{id}")
    public void putUser(@RequestBody UserDto userDto, @PathVariable("id") int id){
        userController.putUser(userDto, id);
    }

    @PatchMapping("{id}")
    public void patchUser(@PathVariable("id") int id, @RequestBody JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        userController.patchUser(id,patch);
    }
}
