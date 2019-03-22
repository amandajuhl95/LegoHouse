/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.SQLException;

/**
 *
 * @author aamandajuhl
 */
public class DataException extends SQLException
{
    public DataException(String msg)
    {
        super(msg);
    }
}
