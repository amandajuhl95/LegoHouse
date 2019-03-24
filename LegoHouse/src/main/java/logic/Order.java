/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DBfacade;
import data.DataException;
import java.sql.SQLException;

/**
 *
 * @author aamandajuhl
 */
public class Order
{

    private int order_id;
    private String date;
    private boolean shipped;
    private int height;
    private int width;
    private int length;
    private User user;
    private DBfacade db = null;

    public Order(int order_id, String date, boolean shipped, int height, int width, int length) throws DataException
    {
        this.db = DBfacade.getInstance();
        this.order_id = order_id;
        this.date = date;
        this.shipped = shipped;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Order(int height, int width, int length, User user) throws DataException
    {
        this.db = DBfacade.getInstance();
        this.height = height;
        this.width = width;
        this.length = length;
        this.user = user;
    }

    public void setOrder_id(int order_id)
    {
        this.order_id = order_id;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public int getHeight()
    {
        return height;
    }

    public int getWidth()
    {
        return width;
    }

    public int getLength()
    {
        return length;
    }

    public int getOrder_id()
    {
        return order_id;
    }

    public String getDate()
    {
        return date;
    }

    public User getUser()
    {
        return user;
    }

    public String isShipped() throws SQLException
    {
        return db.isShipped(order_id);
    }

    @Override
    public String toString()
    {
        return "Ordernumer:  " + order_id + " " + date;
    }

}
