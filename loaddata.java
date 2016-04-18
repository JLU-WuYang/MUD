/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.jlu.ccst.mud;

import java.io.BufferedReader;
import java.io.File;  
import java.io.InputStreamReader; 
import java.io.FileReader;
import java.util.Collection;
import java.util.Iterator;
/**
 *
 * @author Administrator
 */
public class loaddata {
    public static void loadroom(){
        try{
        File file = new File("I:\\test_map.txt");  
        BufferedReader reader = null; 
        reader = new BufferedReader(new FileReader(file));  
        String tempString = null;  
        String id=null;
        String name=null;
        String description=null;
        int number=0;
         // 一次读入一行，直到读入null为文件结束  
         while ((tempString = reader.readLine()) != null) {  
               id=tempString;
               name=reader.readLine();
               description=reader.readLine();
               number= Integer.parseInt(reader.readLine());
               RoomManagement.creatRoom(id, name, description,number);
            } 
        }
        catch (Exception e) {
				e.printStackTrace();
			}
    
    
    }
      public static void loadNPC(){
        try{
        File file = new File("I:\\test_npc.txt");  
        BufferedReader reader = null; 
        reader = new BufferedReader(new FileReader(file));  
        String tempString = null;  
        String name=null;
        String word=null;
        String task=null;
        int hp=0;
        int max_hp=0;
         // 一次读入一行，直到读入null为文件结束  
      
         Collection <Room> c = RoomManagement.cityMap .values();
		for (Iterator<Room> it = c.iterator(); it.hasNext();) {
			Room temp = (Room) it.next();
			for(int i=0;i<temp.getNpcNumber();i++){
                        name = reader.readLine();
                        word = reader.readLine();
                        hp = Integer.parseInt(reader.readLine());
                        max_hp = Integer.parseInt(reader.readLine());
                        task = reader.readLine();
                        temp.creatNpc(name, word, task, hp, max_hp);
                        }
		}
        }
        catch (Exception e) {
				e.printStackTrace();
			}
    
    
    }
}
