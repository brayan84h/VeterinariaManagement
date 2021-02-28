package utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Duenio {

    public List<Gato> mascotas;
    public String id;
    public String name;

    private Date fecha_nacimiento;

    public Duenio(){ //CONSTRUCTOR.
        this.mascotas = new ArrayList<Gato>();
    }

}