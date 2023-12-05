package ut4_proyecto_ahorcado;

import java.io.IOException;
import java.util.Arrays;

public class UT4_Proyecto_Ahorcado {

    public static void main(String[] args) throws IOException {
        //VARIABLES NOMBRE APELLIDOS
        final int mayorEdad = 6570;
        int diaNac, mesNac, anoNac, fechaActualDias, fechaNacimientoDias, edad;
        String nomYApe, nombre, email, palabraOculta;
        double edadDias;
        //VARIABLES PARA AHORCADO
        final int maxVidas = 6;
        int opcionJuego, contadorFallos;
        char[] arrayPalabraSecreta, arrayAciertos, arrayLetrasFallidas;
        char letra, jugarOtra;
        boolean aciertoLetra, adivinoPalabra, letraRepetida, letraFallidaRepetida, otraPartida;

        System.out.println("--------------------------------------------------");
        System.out.println("             JUEGO     DEL     AHORCADO           ");
        System.out.println("--------------------------------------------------");
        System.out.println("");

//SPLIT DE NOMBRE Y APELLIDOS PARA MOSTRAR NOMBRE
        nomYApe = Libreria.leerStringComa("Introduce tu nombre [apellidos, nombre]: ");
        //Creamos el metodo obetnerNombre para dividir el nombre
        nombre = Libreria.obtenerNombre(nomYApe);
        System.out.println("Bienvenido, " + nombre + ".");

// CALCULAR FECHA DE NACIMIENTO
        //Solicitar la fecha de nacimiento al usuario
        diaNac = Libreria.leerIntDia("Introduce tu fecha de nacimiento - solo día: ");
        mesNac = Libreria.leerIntMes("Introduce tu fecha de nacimiento - solo mes: ");
        anoNac = Libreria.leerIntAno("Introduce tu fecha de nacimiento - solo año: ");
        // Calcular la cantidad de días
        fechaNacimientoDias = (anoNac * 365) + (mesNac * 30) + diaNac;
        // Calcular la fecha actual conel metodo obtener fecha actual
        fechaActualDias = Libreria.obtenerFechaActualDias();
        edadDias = fechaActualDias - fechaNacimientoDias;
        Libreria.mostrarEdad((int) edadDias);
        System.out.println(" (" + edadDias / 365 + ") años.");

        //Si el jugador es mejor de edad pide el email de los padres
//VERIFICACIÓN EMAIL
// Verificador en método  validarEmail
        if (edadDias < mayorEdad) {
            System.out.println("Eres menor de edad.");
            System.out.println("Tendrás que introducir el email de tus Padres/Tutores");
            System.out.println("Introduce el email de tus padres.");
            email = Libreria.validarEmail();
        } else {
            email = Libreria.validarEmail();
        }
        System.out.println("Email leído: " + email);
        System.out.println("");
        // Pausar para emprezar el juego
        Libreria.pausar();
//JUEGO DEL AHORCADO
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("             JUEGO     DEL     AHORCADO           ");
            System.out.println("--------------------------------------------------");
            System.out.println("");

            System.out.println("Opciones de juego: ");
            System.out.println("\t1. Jugar contra la máquina.");
            System.out.println("\t2. Jugar contra un amigo.");

            opcionJuego = Libreria.leerIntEntre1y2("Qué opción quiere jugar:");
            // Según elijamos la opcion del switch, la palabraOculta será eintroducida por teclado o generada aleatoriamente
            switch (opcionJuego) {
                case 1:
                    System.out.println("Vamos contra la máquina");
                    palabraOculta = Libreria.obtenerPalabrasAleatorias();
                    Libreria.limpieza();
                    break;
                case 2:
                    System.out.println("Contra un amigo");
                    palabraOculta = Libreria.leerStringMayor3("Introduce la palabra oculta: ");
                    Libreria.limpieza();
                    break;
                default:
                    System.out.println("Elige una opción entre 1 y 2. ");
                    throw new AssertionError();
            }
//FUNCIONAMIENTO DEL JUEGO
            arrayPalabraSecreta = palabraOculta.toCharArray();// Hacemos la palabra oculta una array
            System.out.print("La palabra oculta es: ");
            System.out.println(Arrays.toString(arrayPalabraSecreta));
            //Preparamos la Array de aciertos rellenadola con guiones
            arrayAciertos = new char[arrayPalabraSecreta.length];
            Arrays.fill(arrayAciertos, '-'); // Rellena mi array de aciertos con guiones, para indicar el numero de letras que tiene la palabra
            arrayLetrasFallidas = new char[maxVidas];// Array para almacenar letras fallidas
            contadorFallos = 6;

            System.out.println("COMIENZA EL JUEGO...");
            System.out.println("");

// COMPROBADOR DE LETRAS
            do {
                Libreria.encabezadoJuego(); // Imprime el encabezado del juego
                Libreria.imprimirAhorcado(contadorFallos);// Imprime el dibujo del ahorcado llamando al método imprimir ahorcado
                System.out.println("Te quedan " + contadorFallos + " fallos");
                System.out.print("PALABRA EN JUEGO: ");
                System.out.println(arrayAciertos);
                Libreria.mostrarLetrasFallidas(arrayLetrasFallidas);// Muestra las letras fallidas, para recordar al usuario que ha introducido
                aciertoLetra = false;
                adivinoPalabra = false;

                //Evitar repetir letras fallidas ya introducidas
                do {
                    // Evita repetir letras introducidas ya acertadas
                    do {
                        letra = Libreria.leerLetra("Introduce una letra para jugar: ");
                        letraRepetida = false;
                        for (int i = 0; i < arrayAciertos.length; i++) {
                            if (arrayAciertos[i] == letra) {
                                System.out.println("La letra " + letra + " ya ha sido Introducida. Introduce otra diferente");
                                letraRepetida = true;
                                break;
                            }
                        }
                    } while (letraRepetida);// Si la letra introducida no se repite en las acertada, sale del bucle
                    letraFallidaRepetida = false;
                    for (int i = 0; i < arrayLetrasFallidas.length; i++) {
                        if (arrayLetrasFallidas[i] == letra) {
                            System.out.println("La letra " + letra + " ya ha sido elegida y NO está en la palabra. Introduce otra diferente");
                            letraFallidaRepetida = true;
                            break;
                        }
                    }
                } while (letraFallidaRepetida);// Si la letra introducida no se repite en las falladas sale del bucle

//COMPROBADOR DE LETRAS TRAS COMPROBAR QUE NO ESTAN REPETIDAS
                for (int i = 0; i < arrayPalabraSecreta.length; i++) {
                    if (Character.toUpperCase(arrayPalabraSecreta[i]) == Character.toUpperCase(letra)) {// No distingue entre mayusculas y minusculas
                        arrayAciertos[i] = letra; // Suma la letra acertada a la array de aciertos y sustituye el guión por la letra acertada
                        aciertoLetra = true;
                    }
                }
                if (!aciertoLetra) {
                    System.err.println("Lo siento, la letra [" + letra + "] no está en la palabra, pierdes una vida.");
                    contadorFallos--; // Si el boolean está en false, no ha sido acertada la letra y por ello se resta una vida al contador
                    arrayLetrasFallidas[contadorFallos] = letra;// Se guardan en el array las letras fallidas, en orden descendente

                } else if (aciertoLetra) { //Boolean para condicionar el mensaje de acierto de la palabra
                    System.out.println("Exacto, la letra [" + letra + "] está en la palabra: ");
                    System.out.println(arrayAciertos);
                }
//COMPARADOR DE ARRAYS DE PALABRAS
                if (Arrays.equals(arrayPalabraSecreta, arrayAciertos)) { // Compara ambos array, creando la condicion de entrar si son ambos completamente iguales
                    System.out.println("¡Felicidades! Has adivinado la palabra. Juego terminado.");
                    adivinoPalabra = true;
                    break; // Salir del bucle si se ha adivinado la palabra
                }
            } while (contadorFallos != 0);// Si el contador de fallos es cero, termina el bucle
            if (!adivinoPalabra) {//Evita que obtengamos el mensaje de juego terminado si adivinamos las palbra sin gastar los fallos
                contadorFallos = 0;
                Libreria.imprimirAhorcado(contadorFallos);
                System.out.println("Has perdido todas tus vidas, partida acabada.");
                System.out.println("La palabra oculta era: " + palabraOculta);
            }
//VOLVER A JUGAR
            System.out.println("");
            jugarOtra = Libreria.leerSiNo("¿Te gustaría volver a jugar? (s/n):  ");
            otraPartida = true;
            if (jugarOtra == 'N') {
                otraPartida = false;
            }

        } while (otraPartida);
        System.out.println("Gracias por Jugar, juego terminado.");
    }
}
