/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicManager;
import logic.Order;

/**
 *
 * @author aamandajuhl
 */
public class EmployeeCommand implements Command
{

    private final String target;

    public EmployeeCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException
    {
        HttpSession session = request.getSession();

        if (session.getAttribute("allOrders") == null)
        {
            List<Order> allOrders = manager.getAllOrders();
            session.setAttribute("allOrders", allOrders);
        }

        return target;
    }

}
