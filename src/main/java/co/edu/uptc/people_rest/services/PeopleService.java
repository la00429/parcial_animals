package co.edu.uptc.people_rest.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.uptc.people_rest.exception.InvalidRangeException;

import org.springframework.beans.factory.annotation.Value;
@Service
public class PeopleService {

    @Value("${people.file.path}")
    private String filePath;

    
    public List<String> getPersonInRange(int from, int to) throws IOException {
        List<String> names = Files.readAllLines(Paths.get(filePath));
        
        if (from < 0 || to >= names.size() || from > to) {
             throw new InvalidRangeException("Invalid range: Please check the provided indices.");
        }

    
        return names.subList(from, to + 1);
    }
}

//  devolver los nombres del archivo de manera salteada (uno sí y otro no)
// devolver los nombres que empiecen por una letra especifica ( ejemplo "C",  si el parametro es "Ca" no debe retornanr nada asi exista alguno que conisida)
// devolver los ultimos n nombres almacenados en el archivo
// devolver los nombres que su longitud de caracteres sea menor o igual a 4.  