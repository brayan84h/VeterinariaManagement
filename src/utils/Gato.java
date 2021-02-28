package utils;

public class Gato{

    public Duenio duenio;
    public String nombre;
    public float peso;
    public short edad;
    public String genero;
    public double likelihood_die;

    public Gato(){ //CONSTRUCTOR
        System.out.println("miauuuuu que bien estar vivo!!! dame un nombre, por favor");
    }

    public String saludo(){
        String misaludo = new String();
        misaludo = "Hola, mi nombre es: " + this.nombre + ", y mi dueño es: " + this.duenio.name;
        return misaludo;
    }

    public void  compute_die_likelihood(){
        /* aqui relacionado con logit regression will happen */
        this.likelihood_die = 0.1;
    }

}
