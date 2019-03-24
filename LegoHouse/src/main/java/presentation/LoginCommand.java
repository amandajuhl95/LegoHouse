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
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class LoginCommand implements Command
{

    private final String target;

    public LoginCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException
    {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = manager.userLogin(email, password);

        session.setAttribute("user", user);
        return target;
    }

}
