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
public class Calculate
{

    private HashMap<String, Integer> makeWall(int length, int height)
    {
        HashMap<String, Integer> wall = new HashMap<>();

        int part = length - 2;

        wall.put("4x2", 0);
        wall.put("2x2", 0);
        wall.put("1x2", 0);

        if (part > 4)
        {
            wall.replace("4x2", (((part - (part % 4)) / 4) * height));
            part = part % 4;
        }
        if (part >= 2)
        {
            wall.replace("2x2", (((part - (part % 2)) / 2) * height));
            part = part % 2;
        }
        if (part >= 1)
        {
            wall.replace("1x2", (part * height));
        }

        return wall;

    }

    public ItemList calculateLegoHouse(Order order)
    {
        HashMap<String, Integer> wall1 = makeWall(order.getLength(), order.getHeight());
        HashMap<String, Integer> wall2 = makeWall(order.getWidth(), order.getHeight());

        HashMap<String, Integer> legoHouse = new HashMap<>();

        legoHouse.put("4x2", (wall1.get("4x2") * 2) + (wall2.get("4x2") * 2));
        legoHouse.put("2x2", (wall1.get("2x2") * 2) + (wall2.get("2x2") * 2));
        legoHouse.put("1x2", (wall1.get("1x2") * 2) + (wall2.get("1x2") * 2));

        ItemList itemlist = new ItemList(legoHouse);
        return itemlist;
    }
   
    
    

}
