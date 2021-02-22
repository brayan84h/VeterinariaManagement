import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        /// Creamos al dueño de los gatos
        Duenio duenio1 = new Duenio();

        duenio1.id = "163546";
        duenio1.nombre = "Uayeb";

        //// creamos a los gatos
        Gato migato1 = new Gato();
        migato1.nombre = "Gato Uno";
        migato1.duenio = duenio1;
        migato1.edad = 111;

        Gato migato2 = new Gato();
        migato2.nombre = "Gato Missy";
        migato2.duenio = duenio1;

        // Si quisieramos almacenar los gatos en un arreglo de gatos.
        Gato[] mis_gatos = new Gato[2];
        mis_gatos[0] = migato1;
        mis_gatos[1] = migato2;

        /* Imprimimos saludos de gatos usando un FOR y un contador */
        System.out.println("SALUDOS MEDIANTE UN FOR CON CONTADOR Y USANDO UN ARREGLO");
        for( int contador = 1 ; contador <= mis_gatos.length ; contador++ ){
            System.out.println( mis_gatos[contador-1].saludo() );
        }

        /* assignamos las mascotas al dueño */
        duenio1.mascotas.add(migato1);
        duenio1.mascotas.add(migato2);

        /* en listas para obtener un gato lo hacemos mediante la funcion o metodo Get */
        duenio1.mascotas.get(0); // mis_gatos[0]

        /* imprimimos los gatos que le pertecenen al dueño 1 */
        System.out.println("SALUDOS MEDIANTE UN FOREACH Y USANDO UNA LISTA");
        for (Gato g: duenio1.mascotas) {
            System.out.println(g.saludo());
        }


    }
}


class Gato{

    Duenio duenio;
    String nombre;
    float peso;
    short edad;
    String genero;
    double likelihood_die;

    public Gato(){ //CONSTRUCTOR
        System.out.println("miauuuuu que bien estar vivo!!! dame un nombre, por favor");
    }

    public String saludo(){
        String misaludo = new String();
        misaludo = "Hola, mi nombre es: " + this.nombre + ", y mi dueño es: " + this.duenio.nombre;
        return misaludo;
    }

    public void  compute_die_likelihood(){
        /* aqui relacionado con logit regression will happen */
        this.likelihood_die = 0.1;
    }

}

class Duenio{

    String nombre;
    String id;
    List<Gato> mascotas;

    public Duenio(){ //CONSTRUCTOR.
        this.mascotas = new ArrayList<Gato>();
    }

}
