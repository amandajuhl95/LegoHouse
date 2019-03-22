/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicManager;
import logic.Order;

/**
 *
 * @author aamandajuhl
 */
public class CheckoutCommand implements Command
{
    private final String target;

    public CheckoutCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();
        Order order = (Order) session.getAttribute("order");

        String message = manager.createOrder(order);
        session.setAttribute("message", message);

        return target;
    }

}
