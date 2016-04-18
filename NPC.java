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
public class NPC extends Person{
  private String task;
  public String  getTask(){
    return task;  
  }
  public void setTask(String task){
  this.task=task;
  }
}
