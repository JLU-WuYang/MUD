/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.jlu.ccst.mud;

/**
 *
 * @author Administrator
 */
public class Person {
    	protected int experience;
	protected int con;
	protected int dex;
	protected int str;
	protected int wis;
	protected int hp, max_hp;
	protected int nl, max_nl;
	protected int jl, max_jl;
	protected String id;
	protected String username;
	protected String party;
	protected String location;
        protected String word;
        public void setExperience(int experience){
		this.experience = experience;
	}
	public int getExperience(){
		return this.experience;
	}
          public void setcon(int con){
		this.con = con;
	}
	public int getcon(){
		return this.con;
	}
        public void setdex(int dex){
		this.dex = dex;
	}
	public int getdex(){
		return this.dex;
	}
         public void setword(String word){
		this.word = word;
	}
	public String getword(){
		return this.word;
	}
         public void sethp(int hp){
		this.hp = hp;
	}
	public int gethp(){
		return this.hp;
	}
         public void setmax_hp(int max_hp){
		this.max_hp = max_hp;
	}
	public int getmax_hp(){
		return this.hp;
	}
        
        
        
        
        
        
        
        
        public void setLocation(String location){
		this.location = location;
	}
	public String getLocation(){
		return this.location;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getName(){
		return this.username;
	}
	public void setName(String username){
		this.username = username;
	}
    
}
