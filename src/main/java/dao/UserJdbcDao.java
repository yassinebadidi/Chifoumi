package dao;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserJdbcDao implements UserDao {
    @Override
    public boolean create(User user) {

        String NewUsername = user.getUsername();
        String NewPassword = user.getPassword();
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection connection = ConnectionManager.getInstance()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,NewUsername);
            preparedStatement.setString(2,NewPassword);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(Long aLong) {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public User findByUsername(String username) {
        Connection connection = ConnectionManager.getInstance();
        String query = "SELECT id, username, password FROM users WHERE username =?";
        User userFound = null;

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1,username);
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()) {
                userFound = new User(
                        result.getInt("id"),
                        result.getString("username"),
                        result.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userFound;
    }
}
