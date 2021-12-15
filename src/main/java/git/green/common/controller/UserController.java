package git.green.common.controller;

/*
 * project:  common
 * author:   Administrator
 * created:  14/12/2021 2:52 PM
 */

import git.green.common.model.LoginData;
import git.green.common.model.User;
import git.green.common.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @ResponseBody
    @PostMapping("/auth/signin")
    public User signin(@RequestBody LoginData loginData){
        User user = null;
        System.out.println("req body: " + loginData);
        user = userRepository.findByUserNameAndPassword(loginData.getUsername(), loginData.getPassword());
        if(user==null){
            System.out.println("User not found!");
            return null;
        }
        System.out.println("User id:" +  user.getId() + ",name: " + user.getName());
        CommonController.currentUser = user;
        return user;
    }
}
