/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author aamandajuhl
 */
public class CommandController
{

    private static CommandController instance = null;
    private final Map<String, Command> commands = new HashMap();

    private CommandController()
    {
        commands.put("create", new CreateUserCommand("index.jsp"));
        commands.put("login", new LoginCommand("shop.jsp"));
        commands.put("shop", new ShopCommand("shop.jsp"));
        commands.put("shoppingcart", new ShoppingcartCommand("shoppingcart.jsp"));
        commands.put("checkout", new CheckoutCommand("checkout.jsp"));
        commands.put("customer", new CustomerCommand("customer.jsp"));
        commands.put("customerOrder", new CustomerOrderCommand("customerOrder.jsp"));
        commands.put("employee", new EmployeeCommand("employee.jsp"));
        commands.put("employeeOrder", new EmployeeOrderCommand("employeeOrder.jsp"));
        commands.put("logout", new LogOutCommand("index.jsp"));
    }
    
    public static synchronized Command commandFrom(String key)
    {
        if (key == null)
        {
            key = "back";
        }
        if (instance == null)
        {
            instance = new CommandController();
        }
        return instance.commands.get(key);
    }
}
