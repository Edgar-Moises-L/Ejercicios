import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        boolean salida = true;

        while (salida == true) {
            System.out.println("");
            System.out.println("*** Aplicacion calculadora ***");
            System.out.println("""
                    1.Suma
                    2.Resta
                    3.Multiplicacion
                    4.Divicion
                    5.Salir
                    """);
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Operacion a realizar: ");
                int operacion = Integer.parseInt(scanner.nextLine());


                if (operacion >= 1 && operacion <= 4) {
                    System.out.print("Ingresa el primer valor: ");
                    int operando1 = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingresa el segundo valor: ");
                    int operando2 = Integer.parseInt(scanner.nextLine());
                    int resultado;

                    switch (operacion) {
                        case 1:
                            resultado = operando1 + operando2;
                            System.out.print("Resultado de la suma: " + resultado);
                            break;
                        case 2:
                            resultado = operando1 - operando2;
                            System.out.print("Resultado de la resta: " + resultado);
                            break;
                        case 3:
                            resultado = operando1 * operando2;
                            System.out.print("Resultado de la multiplicacion: " + resultado);
                            break;
                        case 4:
                            resultado = operando1 / operando2;
                            System.out.print("Resultado de la divicion: " + resultado);
                            break;
                    }

                } else if (operacion == 5) {
                    salida = false;
                    System.out.println("Fin del programa");
                } else {
                    System.out.println("operacion no validad");
                }

            }catch(Exception e){
                System.out.println("valor ingresado no valido");
            }
        }
    }
}
