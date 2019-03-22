/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DBfacade;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aamandajuhl
 */
public class LogicManager
{

    private static LogicManager instance = null;
    private Calculate c = new Calculate();
    private HashMap<String, Integer> legoHouse;
    private ItemList itemlist = new ItemList(legoHouse);
    private DBfacade db;

    public LogicManager() throws SQLException
    {
        this.db = DBfacade.getInstance();
    }

    public static LogicManager getInstance() throws SQLException
    {
        if (instance == null)
        {
            instance = new LogicManager();
        }
        return instance;
    }

    public ItemList calculateLegoHouse(Order order)
    {
        return c.calculateLegoHouse(order);
    }

    public HashMap<String, Integer> getLegoHouse()
    {
        return itemlist.getLegoHouse();
    }

    public User getUser(String email, String password) throws SQLException
    {
        return db.getUser(email, password);
    }

    public void createOrder(Order newOrder) throws SQLException
    {
        db.makeOrder(newOrder);
    }

    public Order getOrder(int order_id) throws SQLException
    {
        return db.getOrder(order_id);
    }

    public String createUser(User u) throws SQLException
    {
        boolean add = false;
        if (!userExist(u))
        {
            add = true;
            db.createUser(u);
            return "User is created";
        } else
        {
            return "A user with this email already exists";
        }
    }

    private boolean userExist(User u) throws SQLException
    {
        List<User> users = db.getAllUsers();

        for (User user : users)
        {
            if (user.getEmail().equals(u.getEmail()))
            {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) throws SQLException
    {
        LogicManager lm = LogicManager.getInstance();
        User user = lm.getUser("ama", "1234");
        Order order = new Order(2, 6, 10, user);
        lm.createOrder(order);
        ItemList itemlist = lm.calculateLegoHouse(order);
        System.out.println(itemlist);

        
        
    }

}