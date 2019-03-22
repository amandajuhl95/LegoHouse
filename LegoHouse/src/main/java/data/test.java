/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.SQLException;
import logic.Order;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class test
{
    public static void main(String[] args) throws SQLException, DataException
    {   DBfacade db = DBfacade.getInstance();
        User user = new User("M", "1234");
        db.createUser(user);
        System.out.println(db.getAllUsers());
        //System.out.println(user.getId());
//        System.out.println(user.getEmail());
//        System.out.println(user.getRole());
//        System.out.println(user.getPassword());
        
        Order o = new Order(6, 7, 8, user);
        db.makeOrder(o);
//        System.out.println(o.isShipped());
       
       
        
    }
}
