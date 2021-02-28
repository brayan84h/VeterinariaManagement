package application;

import java.util.ArrayList;
import java.util.List;

public class AppCliente {
    public static void main(String[] args) {

        //CREAMOS EL CLIENTE

        Client client1 = new Client("Jose Ramon", "08012001543","9865-4909", "Col. Suazo Cordova");

        System.out.println(client1.saludar());


        //CREAMOS EL EQUIPO(computadora)

        Computer compu1 = new Computer("A1L","Laptop", "Dell", "Memorias dañadas", 548.6);
        Computer compu2 = new Computer("A2K","Desktop", "HP", "Grafica dañada", 548.6);

        client1.asignar_computadora(compu1);
        client1.asignar_computadora(compu2);

        System.out.println("IMPRIMIENDO DUENIO DE COMP DESDE LA INFORMACION DE LA COMP");
        System.out.println(compu1.mi_duenio.id_client+"\n");

        System.out.println("COMPUTADORAS DEL CLIENTE: \n");
        client1.imprimir_mis_computadoras();

        Techincal reparador = new Techincal("Uayeb");

        System.out.println("COMPUTADORAS DEL TECNICO: \n");
        reparador.imprimir_mis_computadoras();


        reparador.recibe( client1.computers.get(0) , client1 );

        System.out.println("COMPUTADORAS DEL TECNICO: \n");
        reparador.imprimir_mis_computadoras();

        System.out.println("COMPUTADORAS DEL CLIENTE: \n");
        client1.imprimir_mis_computadoras();


    }
}


class Client {
    String name_client;
    String id_client;
    String phone_client;
    String direction;

    List<Computer> computers;

    public Client(String name, String id, String phone, String dir){

        this.name_client = name;
        this.id_client = id;
        this.phone_client = phone;
        this.direction = dir;
        this.computers = new ArrayList<Computer>();

    }

    public String saludar(){
        String saludo = "Hola! mi nombre es " + this.name_client + " y mi ID es " + this.id_client + "\n";
        return saludo;
    }

    public void asignar_computadora(Computer nueva_computadora){
        nueva_computadora.mi_duenio = this;
        this.computers.add(nueva_computadora);
    }

    public void quitar_computadora(Computer computadora_a_eliminar){
        this.computers.remove(computadora_a_eliminar);
        System.out.println(computadora_a_eliminar.id + " fue removida del usuario " + this.id_client + "\n");
    }

    public void imprimir_mis_computadoras(){
        short i = 1;
        for( Computer c : this.computers ){
            System.out.println("Mi computadora numero " + i + " es la " + c.id+": "+c.mark+", "+c.tip_compu);
            i += 1;
        }
        System.out.println("");
    }

}

class Techincal{
    String name_tech;
    String id_tech;
    String phone_tech;

    List<Computer> computadoras_a_reparar;

    public Techincal(String name_tech){
        computadoras_a_reparar = new ArrayList<Computer>();
        this.name_tech = name_tech;
    }

    public void recibe(Computer computadora_a_reparar, Client cliente_que_entrega_la_computadora){

        this.computadoras_a_reparar.add( computadora_a_reparar );
        cliente_que_entrega_la_computadora.quitar_computadora(computadora_a_reparar);

    }

    public void imprimir_mis_computadoras(){
        short i = 1;
        for( Computer c : this.computadoras_a_reparar ){
            System.out.println("Mi computadora numero  " + i + " a reparar es la " + c.id+": "+c.mark+", "+c.tip_compu + " y su dueño es " + c.mi_duenio.id_client);
            i += 1;
        }
        System.out.println("");
    }


}

class Computer{
    String id;
    String tip_compu;
    String mark;
    String Details;
    double repair_price;

    Client mi_duenio;

    public Computer(String id, String tip_compu, String mark, String Details, double repair_price){
        this.id = id;
        this.tip_compu = tip_compu;
        this.mark = mark;
        this.Details = Details;
        this.repair_price = repair_price;
    }

    public void quien_es_mi_duenio(Client mi_duenio){
        this.mi_duenio = mi_duenio;
    }

}