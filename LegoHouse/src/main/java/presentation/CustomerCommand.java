/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicManager;
import logic.Order;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class CustomerCommand implements Command
{
    
    private final String target;

    public CustomerCommand(String target)
    {
        this.target = target;
    }
    

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();

        if (session.getAttribute("orders") == null)
        {
            User user = (User) session.getAttribute("user");
            List<Order> orders = manager.getOrders(user);
            session.setAttribute("orders", orders);
        }
        
        return target;
    }
    
}
