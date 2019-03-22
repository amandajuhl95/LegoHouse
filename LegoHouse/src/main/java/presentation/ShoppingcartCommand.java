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
import logic.ItemList;
import logic.LogicManager;
import logic.Order;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class ShoppingcartCommand implements Command
{

    private final String target;

    public ShoppingcartCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException, SQLException
    {
        HttpSession session = request.getSession();

        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        User user = (User) session.getAttribute("user");

        if (length != 0 && width != 0 && height != 0)
        {
            Order order = new Order(height, width, length, user);
            ItemList list = manager.calculateLegoHouse(order);

            if (list != null)
            {
                session.setAttribute("list", list);
                session.setAttribute("order", order);
                return target;
            }
        }

        return target;
    }

}
