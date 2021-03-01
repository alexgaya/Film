/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Film;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author m
 */
public class FilmReader {
    
    private final FileReader fr;
    private Film[] films;
    private static final int MAX_FILMS = 3;
    private String[] splittedFilmsText;
    
    public FilmReader(String fileName) throws FileNotFoundException {
        this.fr = new FileReader(fileName);
    }
    
    public Film[] getFilms() throws IOException{
        this.readFilms();
        this.convertToFilms();
        return this.films;
    }
    
    private void readFilms() throws IOException{
        int charValue = this.fr.read();
        String text = "";
        while(charValue != -1) {
            char c = (char) charValue;
            text = text + c;
            charValue = this.fr.read();
        }
        this.fr.close();
        if(!text.equals(""))
        this.splittedFilmsText = text.split(";");
    }
    
    private void convertToFilms() {
        if(this.splittedFilmsText != null) {
            this.films = new Film[MAX_FILMS];
            for(int i = 0; i < this.splittedFilmsText.length; i++){
                Film f = new Film();
                String[] props = this.splittedFilmsText[i].split("/");
                f.setTitle(props[0].substring(props[0].indexOf(":")+1));
                f.setDirector(props[1].substring(props[1].indexOf(":")+1));               
                f.setYear(Integer.parseInt(props[2].substring(props[2].indexOf(":")+1)));
                this.films[i] = f;
            }
            
        }
    }
    
    
}
