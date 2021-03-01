/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Models.Film;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author m
 */
public class FilmWriter {
    private final FileWriter fw;
    private Film[] films;
    
    public FilmWriter(String fileName) throws IOException {
        this.fw = new FileWriter(fileName);
    }
    
    public void setFilms(Film[] films){
        this.films = films;
    }
    
    public void saveFilms() throws IOException {
        for(Film f : films) {
            if (f != null) {
                this.fw.write("title:" + f.getTitle() + "/director:" + 
                        f.getDirector() + "/year:" + f.getYear() + ";");
            }
        }
        this.fw.close();
    }
}
