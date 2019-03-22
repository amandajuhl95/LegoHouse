/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.HashMap;

/**
 *
 * @author aamandajuhl
 */
public class ItemList
{
    HashMap<String, Integer> legoHouse;

    public ItemList(HashMap<String, Integer> legoHouse)
    {
        this.legoHouse = legoHouse;
    }

    public HashMap<String, Integer> getLegoHouse()
    {
        return legoHouse;
    }

    @Override
    public String toString()
    {
        return "" + legoHouse;
    }
    
    
    

}
