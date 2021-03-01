/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author m
 */
public class Film {
    private String title;
    private String director;
    private int year;
    
    public Film(){}
    
    public String getTitle(){
        return this.title;
    }
    
    public String getDirector(){
        return this.director;
    }
    
    public int getYear(){
        return this.year;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void setDirector(String director){
        this.director = director;
    }
    
    public void setYear(int year){
        this.year = year;
    }
}
