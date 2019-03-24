/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicManager;

/**
 *
 * @author aamandajuhl
 */
public class ShopCommand implements Command
{

    private final String target;

    public ShopCommand(String target)
    {
        this.target = target;
    }

    @Override
    public String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException
    {
        return target;
    }

}
