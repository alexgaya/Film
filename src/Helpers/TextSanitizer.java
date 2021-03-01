/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

/**
 *
 * @author m
 */
public class TextSanitizer {
    
    private static final char[] PROHIBITED_CHARS = {'/', ':', ';'};
    
    public static String sanitize(String s) {
        for(char c : PROHIBITED_CHARS) {
            s = s.replace(c, (char) 0);
        }
        s = s.trim();
        return s;
    }
    
    public static int convertToNumber(String y) {
        int num;
        try{
            num = Integer.parseInt(y);
        }
        catch(NumberFormatException e){
            num = -1;
        }
        return num;
    }
    
}
