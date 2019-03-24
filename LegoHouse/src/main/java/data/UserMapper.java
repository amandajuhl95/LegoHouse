/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
class UserMapper
{

    private DatabaseConnector dbc;

    public UserMapper(DatabaseConnector dbc) throws DataException
    {
        this.dbc = dbc;
    }

    public User userLogin(String email, String password) throws DataException
    {
        try
        {
            dbc.open();
            String query
                    = "SELECT * "
                    + "FROM user "
                    + "WHERE email = ? AND password = ?;";

            PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();

            if (rs.next())
            {
                String role = rs.getString("role");
                int user_id = rs.getInt("user_id");
                User user = new User(user_id, email, password, role);
                dbc.close();
                return user;
            } else
            {
                dbc.close();
                return null;
            }

        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }
    }

    public User getUser(int user_id) throws DataException
    {
        try
        {
            dbc.open();
            String query
                    = "SELECT * "
                    + "FROM user "
                    + "WHERE user_id = " + user_id + ";";

            User user = null;
            int id = 0;
            String email = "";
            String password = "";
            String role = "";

            PreparedStatement statement = dbc.preparedStatement(query);
            ResultSet rs = statement.executeQuery();

            if (rs.next())
            {
                id = rs.getInt("user_id");
                email = rs.getString("email");
                password = rs.getString("password");
                role = rs.getString("role");

                user = new User(user_id, email, password, role);
            }
            dbc.close();

            return user;
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }
    }

    public List<User> getAllUsers() throws DataException
    {
        try
        {
            dbc.open();
            List<User> users = new ArrayList();

            String query
                    = "SELECT * FROM user;";

            int user_id = 0;
            String email = "";
            String password = "";
            String role = "";

            PreparedStatement statement = dbc.preparedStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                user_id = rs.getInt("user_id");
                email = rs.getString("email");
                password = rs.getString("password");
                role = rs.getString("role");

                User u = new User(user_id, email, password, role);
                users.add(u);
            }

            dbc.close();
            return users;
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }

    }

    public void createUser(User newUser) throws DataException
    {
        try
        {
            dbc.open();

            String query
                    = "INSERT INTO user "
                    + "(email, password, role) "
                    + "VALUES (?,?,?);";

            int user_id = newUser.getId();
            String email = newUser.getEmail();
            String password = newUser.getPassword();
            String role = newUser.getRole();

            PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, email);
            statement.setString(2, password);
            statement.setString(3, role);
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next())
            {
                user_id = rs.getInt(1);
                newUser.setId(user_id);
            }

            dbc.close();
        } catch (SQLException ex)
        {
            throw new DataException(ex.getMessage());
        }

    }
}
