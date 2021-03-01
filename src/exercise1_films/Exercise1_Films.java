/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1_films;

import Helpers.TextSanitizer;
import Models.Film;
import Services.FilmReader;
import Services.FilmWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author m
 */
public class Exercise1_Films {
    
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        menu();
    }
    
    
    
    
    
    private static int enterYear(Scanner s) {
        System.out.println("Enter film's year:");
        String year = s.nextLine();
        year = TextSanitizer.sanitize(year);
        int y = TextSanitizer.convertToNumber(year);
        if (y == -1) {
            System.out.println("\nInvalid number, try again or introduce 0 "
                    + "if you don't know the year.\n");
            enterYear(s);
        }
        return y;
    }
    
    private static String enterTitle(Scanner s) {
        System.out.println("Enter film's title:");
        String title = s.nextLine();
        title = TextSanitizer.sanitize(title);
        if(title == null || title.equals("")) {
            System.out.println("\nInvalid title, try again or introduce "
                    + "'unknown' if you don't know the title.\n");
            enterTitle(s);
        }
        return title;
    }
    
    private static String enterDirector(Scanner s) {
        System.out.println("Enter film's director:");
        String director = s.nextLine();
        director = TextSanitizer.sanitize(director);
        if(director.equals("") || director == null) {
            System.out.println("\nInvalid director, try again or introduce "
                    + "'unknown' if you don't know the director.\n");
            enterDirector(s);
        }
        return director;
    }
    
    private static void printFilms() throws IOException{
        FilmReader filmReader = new FilmReader("Films.txt");
        Film[] films = filmReader.getFilms();
        if(films == null) {
            System.out.println("There are no films.");
        }else{
            for(Film f : films){
                if(f != null){
                   System.out.println("Title: " + f.getTitle());
                   System.out.println("Director: " + f.getDirector());
                   System.out.println("Year: " + f.getYear() + "\n");   
                }
            }
        }
    }
    
    private static void saveFilms(Scanner s) throws IOException {
        FilmWriter filmWriter = new FilmWriter("Films.txt");
        Film[] films = new Film[3];
        for(int i = 0; i < 3; i++){
            String title = enterTitle(s);
            String director = enterDirector(s);
            int y = enterYear(s);
            Film f = new Film();
            f.setTitle(title);
            f.setDirector(director);
            f.setYear(y);
            films[i] = f;
        }
        filmWriter.setFilms(films);
        filmWriter.saveFilms();
    }
    
    private static void menu() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce 1 to write a set of 3 new films." + 
                "\nIntroduce 2 to read the set of films." + 
                "\nIntroduce 3 to stop the program.");
        int n; 
        try{
            n = s.nextInt();
            s.nextLine();
            if(n == -1 || n > 3) {
                System.out.println("\nInvalid number, try again or introduce 3 "
                        + "to exit the program");
                menu();
            }
            switch(n){
                case 1:
                    saveFilms(s);
                    menu();
                    break;
                case 2:
                    printFilms();
                    menu();
                    break;
                case 3:
                    //s.close();
                    System.exit(0);
                    break;
            }
        }
        catch(IOException e){
            System.out.println("\nYou must enter a number.\n");
        }
    }
}
