/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicManager;

/**
 *
 * @author aamandajuhl
 */
public class LogOutCommand implements Command
{
    private final String target;
    
    public LogOutCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException
    {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        session.removeAttribute("order");
        session.removeAttribute("allOrder");
        session.removeAttribute("orders");
        session.removeAttribute("list");
        session.removeAttribute("message");
        return target; 
    }
    
}
