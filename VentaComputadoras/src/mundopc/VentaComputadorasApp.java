package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {
        Raton raton = new Raton("alambrico","lenobo");
        System.out.println(raton);

        Teclado teclado = new Teclado("alambric","lenobo");
        System.out.println(teclado);

        Monitor monitor = new Monitor("lenobo", 23);
        System.out.println(monitor);

        Computadora computtadora = new Computadora("lenobo",monitor,teclado,raton);
        System.out.println(computtadora);

        Orden orden = new Orden();
        orden.agregarComputadora(computtadora);
        orden.mostrarOrden();
    }
}
