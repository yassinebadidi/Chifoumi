package service;

import dao.UserDao;
import dao.UserJdbcDao;
import model.User;

public class UserService {
    private final UserDao userDao = new UserJdbcDao();

    public UserService() {
    }

    public boolean Isloged(String username, String password){
        User userFound = userDao.findByUsername(username);
        if(userFound != null){
            return userFound.getPassword().equals(password);
        }
        return false;
    }

    public boolean IsInDataBase(String username){
        User userFound = userDao.findByUsername(username);
        return userFound != null; // diff de null return true, egale null false
    }

    public boolean userCreat(String username, String password){
        User newUser = new User(username,password);
        return userDao.create(newUser);
    }
}
