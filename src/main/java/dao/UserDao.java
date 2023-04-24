package dao;

import model.User;

import java.sql.SQLException;

public interface UserDao extends GenericDao<User, Long>{

    User findByUsername(String username);
}
