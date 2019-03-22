/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import logic.LogicManager;
import logic.User;

/**
 *
 * @author aamandajuhl
 */
public class CreateUserCommand implements Command
{

    private final String target;

    CreateUserCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, SQLException
    {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User u = new User(email, password);
        String user = manager.createUser(u);
        session.setAttribute("user", user);

        return target;

    }

}
