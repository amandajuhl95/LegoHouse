/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.ItemList;
import logic.LogicManager;
import logic.Order;

/**
 *
 * @author aamandajuhl
 */
public class EmployeeOrderCommand implements Command
{

    private final String target;

    public EmployeeOrderCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException
    {

        HttpSession session = request.getSession();

        int order_id = Integer.parseInt(request.getParameter("selected"));
        Order order = manager.getOrder(order_id);
        session.setAttribute("previousO", order);

        ItemList list = manager.calculateLegoHouse(order);
        session.setAttribute("previousL", list);

        return target;
    }

}
