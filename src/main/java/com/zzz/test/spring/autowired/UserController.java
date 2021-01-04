package com.zzz.test.spring.autowired;

public class UserController {

    @Autowired
    private UserService userService;


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
