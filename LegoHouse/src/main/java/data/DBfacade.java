/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.SQLException;
import java.util.List;
import logic.Order;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class DBfacade
{
    private static DBfacade instance = null;
    private DatabaseConnector dbc = new DatabaseConnector();
    private DataSourceMysql dataSource = new DataSourceMysql();
    private UserMapper um = new UserMapper(dbc);
    private OrderMapper om = new OrderMapper(dbc, um);

    private DBfacade() throws DataException
    {
        dbc.setDataSource(dataSource.getDataSource());
    }

    public static DBfacade getInstance() throws DataException
    {
        if (instance == null)
        {
            instance = new DBfacade();
        }
        return instance;
    }
     
    public void createUser(User newUser) throws DataException
    {
        um.createUser(newUser);
    }

    public User userLogin(String email, String password) throws DataException
    {
        return um.userLogin(email, password);
    }
    
    public User getUser(int user_id) throws DataException
    {
        return um.getUser(user_id);
    }

    public List<User> getAllUsers() throws DataException
    {
        return um.getAllUsers();
    }

    public Order getOrder(int order_id) throws DataException
    {
        return om.getOrder(order_id);
    }
    
    public List<Order> getOrders(int user_id) throws DataException
    {
        return om.getOrders(user_id);
    }

    public List<Order> getAllOrders() throws DataException
    {
        return om.getAllOrders();
    }

    public void makeOrder(Order newOrder) throws DataException
    {
        om.makeOrder(newOrder);
    }

    public String isShipped(int order_id) throws DataException
    {
        return om.isShipped(order_id);
    }
}
