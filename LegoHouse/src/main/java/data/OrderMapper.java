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
import logic.Order;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
class OrderMapper
{
    
    private DatabaseConnector dbc;
    private UserMapper um;
    
    public OrderMapper(DatabaseConnector dbc, UserMapper um) throws SQLException
    {
        this.dbc = dbc;
        this.um = um;
    }
    
    public Order getOrder(int order_id) throws SQLException
    {
        dbc.open();
        
        Order order = null;
        
        String query
                = "SELECT * "
                + "FROM order "
                + "WHERE order_id = '" + order_id + "';";
        
        User user = null;
        int id = 0;
        String order_date = "";
        String shipped = "";
        int length = 0;
        int width = 0;
        int height = 0;
        int user_id = user.getId();
        
        PreparedStatement statement = dbc.preparedStatement(query);
        ResultSet rs = statement.executeQuery();
        
        if (rs.next())
        {
            id = rs.getInt("order_id");
            user_id = rs.getInt("user_id");
            order_date = rs.getString("order_date");
            shipped = rs.getString("shipped");
            length = rs.getInt("length");
            width = rs.getInt("width");
            height = rs.getInt("height");
            
            order = new Order(id, order_date, false, height, width, length);
        }
        
        dbc.close();
        
        return order;
    }
    
    public List<Order> getOrders(int user_id) throws SQLException
    {
        dbc.open();
        
        List<Order> orders = new ArrayList<>();
        User user = um.getUser(user_id);
        
        String query
                = "SELECT * "
                + "FROM order "
                + "WHERE user_id = '" + user_id + "';";
        
        int order_id = 0;
        String order_date = "";
        String shipped = "";
        int length = 0;
        int width = 0;
        int height = 0;
        
        PreparedStatement statement = dbc.preparedStatement(query);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next())
        {
            order_id = rs.getInt("order_id");
            order_date = rs.getString("order_date");
            shipped = rs.getString("shipped");
            length = rs.getInt("length");
            width = rs.getInt("width");
            height = rs.getInt("height");
            
            orders.add(new Order(order_id, order_date, false, height, width, length));
        }
        
        dbc.close();
        
        return orders;
    }
    
    
    public List<Order> getAllOrders() throws SQLException
    {
        dbc.open();
        List<Order> orders = new ArrayList();
        
        String query
                = "SELECT * FROM `order`;";
        
        int id = 0;
        int user_id = 0;
        String order_date = "";
        String shipped = "";
        int length = 0;
        int width = 0;
        int height = 0;
        User user = null;
        
        PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next())
        {
            id = rs.getInt("order_id");
            user_id = rs.getInt("user_id");
            order_date = rs.getString("order_date");
            shipped = rs.getString("shipped");
            length = rs.getInt("length");
            width = rs.getInt("width");
            height = rs.getInt("height");
            
            Order o = new Order(id, order_date, false, height, width, length);
            orders.add(o);
        }
        
        dbc.close();
        return orders;
    }
    
    public void makeOrder(Order newOrder) throws SQLException
    {
        dbc.open();
        
        String query
                = "INSERT INTO `order` "
                + "(length, width, height, user_id) "
                + "VALUES(?,?,?,?);";
        
        int order_id;
        String order_date;
        int length = newOrder.getLength();
        int width = newOrder.getWidth();
        int height = newOrder.getHeight();
        int user_id = newOrder.getUser().getId();
        
        PreparedStatement statement = dbc.preparedStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        statement.setInt(1, length);
        statement.setInt(2, width);
        statement.setInt(3, height);
        statement.setInt(4, user_id);
        statement.executeUpdate();
        
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next())
        {
            order_id = rs.getInt(1);
            newOrder.setOrder_id(order_id);
            order_date = getOrderDate(order_id);
            newOrder.setDate(order_date);
        }
        
        dbc.close();
    }
    
    public String isShipped(int order_id) throws SQLException
    {
        dbc.open();
        
        String query
                = "UPDATE `order` "
                + "SET shipped = CURRENT_TIMESTAMP "
                + "WHERE order_id = " + order_id + ";";
        
        String query2
                = "SELECT * "
                + "FROM `order` "
                + "WHERE order_id = " + order_id + ";";
        
        String shipped = "";
        
        PreparedStatement statement = dbc.preparedStatement(query);
        statement.executeUpdate();
        
        PreparedStatement statement2 = dbc.preparedStatement(query2);
        ResultSet rs = statement2.executeQuery();
        if (rs.next())
        {
            shipped = rs.getString("shipped");
        }
        dbc.close();
        
        return shipped;
        
    }
    
    private String getOrderDate(int order_id) throws SQLException
    {
        
        String query
                = "SELECT order_date "
                + "FROM `order` "
                + "WHERE order_id = " + order_id + ";";
        
        String order_date = "";
        
        PreparedStatement statement = dbc.preparedStatement(query);
        ResultSet rs = statement.executeQuery();
        if (rs.next())
        {
            order_date = rs.getString("order_date");
        }
        
        return order_date;
        
    }
    
}
