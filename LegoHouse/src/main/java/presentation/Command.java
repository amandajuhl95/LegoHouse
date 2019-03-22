/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import logic.LogicManager;

/**
 *
 * @author aamandajuhl
 */
public interface Command
{
    String execute(HttpServletRequest request, LogicManager manager) throws CommandException, DataException, SQLException;
}
