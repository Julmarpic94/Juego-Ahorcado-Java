package ut4_proyecto_ahorcado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Libreria {
     //--------------------------------------------------------------------------
    //MÉTODO PARA LEER UN STRING (STRING)
    //--------------------------------------------------------------------------
    /**
     * Método para leer un String y comprobar si tiene una ','.
     *
     * @param msj
     * @return
     */
 public static String leerStringComa(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadena = "cadena";
        boolean tieneComa;
        do {
            tieneComa = false;
            try {
                System.out.print(msj);
                cadena = teclado.readLine();
                
                 for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == ',') {
                    tieneComa = true;
                    break;
                }
            }
                 if(!tieneComa){
                     System.err.println("El formato no es correcto, debes separar tus apellidos y nombre con una [,]");
                 }
               
                
            } catch (IOException e) {
                System.err.println("\tError en el método leerString");
                System.out.println(e.getMessage());
            }
        } while (!tieneComa);
        return cadena;
    } 
    //--------------------------------------------------------------------------
    //MÉTODO PARA SEPARAR UN STRING EN DOS 
    //--------------------------------------------------------------------------
    /**
     * Método para separar un String en dos dividido por una ','.
     * @param nomYApe
     * @return 
     */
    // Dividir la array de nomYApe por la coma para obtener el nombre
    public static String obtenerNombre(String nomYApe) {
        String[] arrayNomYApe;
        String nombre, apellidos;
        arrayNomYApe = nomYApe.split(",");
        apellidos = arrayNomYApe[0].strip();
        nombre = arrayNomYApe[1].strip();
        return nombre;
    }
 
    //--------------------------------------------------------------------------
    //MÉTODO PARA PAUSAR LA EJECUCIÓN EL PROGRAMA
    //--------------------------------------------------------------------------
    /**
     * Método para pausar la ejecución y continuar con un intro
     * String. 
     * @throws java.io.IOException
     */
    public static void pausar() throws IOException {
        //PAUSAR
        System.out.println("Pulsa Intro para continuar");
        System.in.read();
    }
    
    //--------------------------------------------------------------------------
    //MÉTODO PARA OBTENER LA FECHA EN DIAS
    //--------------------------------------------------------------------------
    /**
     * Divide la fecha Actual con la clase LocalDate y la devuelve en dias.
     * @return 
     */
    public static int obtenerFechaActualDias() {
        // Clase LocalDate para obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        int anoActual, mesActual, diaActual, fechaActualDias;
        anoActual = fechaActual.getYear();
        mesActual = fechaActual.getMonthValue();
        diaActual = fechaActual.getDayOfMonth();

        fechaActualDias = (anoActual * 365) + (mesActual * 30) + diaActual;
        return fechaActualDias;
    }
//--------------------------------------------------------------------------
    //MÉTODO PARA DIVIDIR LA FECHA ACTUAL DIAS EN DIAS, MESES Y ANOS
    //--------------------------------------------------------------------------
    /**
     * Divide la fecha Actual en dias y la devuelve en dias, meses y anos. 
     * @param edadDias
     */
    public static void mostrarEdad(int edadDias) {
        int anos, meses, dias, anosInt, mesesInt, diasInt;
        int restoAnos;
        //int[] arrayEdad = null ;

        anos = (int) edadDias / 365;
        restoAnos = edadDias % 365;
        meses = restoAnos / 30;
        dias = restoAnos % 30;

        anosInt = (int) anos;
        mesesInt = (int) meses;
        diasInt = (int) dias;
//        
//        arrayEdad[0] = anosInt;
//        arrayEdad[1] = mesesInt;
//        arrayEdad[2] = diasInt;

        System.out.print("Tienes " + anosInt + " años " + mesesInt + " meses y " + diasInt + " días ");

    }
    
    //--------------------------------------------------------------------------
    //MÉTODO PARA GENERAR 10 PALABRAS AUTOMATICAS
    //--------------------------------------------------------------------------
    /**
     * Devuelve una palabra aleatoria desde un array de String. 
     * @return 
     */
    public static String obtenerPalabrasAleatorias() {
        String[] palabraAleatoria = {"CAMION", "COCHE", "HELICOPTERO", "PERRO", "SEMANA",
            "PROGRAMACION", "JAMON", "NEUMATICO", "ZAPATO", "MOCHILA"};
        int numeroAleatorio;
        numeroAleatorio = (int) ((Math.random() * palabraAleatoria.length));
        return palabraAleatoria[numeroAleatorio];
    }

    
     //--------------------------------------------------------------------------
    //MÉTODO PARA IMPRIMIR EL DIBUJO DEL AHORACADO
    //--------------------------------------------------------------------------
    /**
     * Devuelve el dibujo correspondiente al numero de fallos que el usuario tiene. 
     * @param contadorFallos
     */
    public static void imprimirAhorcado(int contadorFallos) {

        switch (contadorFallos) {

            case 6:
                System.out.println("  +-------!-");
                System.out.println("  |         ");
                System.out.println("  |         ");
                System.out.println("  |         ");
                System.out.println("  |         ");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            case 5:
                System.out.println("  +-------!-");
                System.out.println("  |       O ");
                System.out.println("  |         ");
                System.out.println("  |         ");
                System.out.println("  |         ");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            case 4:
                System.out.println("  +-------!-");
                System.out.println("  |       O ");
                System.out.println("  |       | ");
                System.out.println("  |       | ");
                System.out.println("  |         ");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            case 3:
                System.out.println("  +-------!-");
                System.out.println("  |       O ");
                System.out.println("  |      /| ");
                System.out.println("  |       | ");
                System.out.println("  |         ");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            case 2:

                System.out.println("  +-------!-");
                System.out.println("  |       O ");
                System.out.println("  |      /|\\");
                System.out.println("  |       | ");
                System.out.println("  |         ");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            case 1:

                System.out.println("  +-------!-");
                System.out.println("  |       O ");
                System.out.println("  |      /|\\");
                System.out.println("  |       | ");
                System.out.println("  |      /  ");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            case 0:

                System.out.println("  +-------!-");
                System.out.println("  |       O ");
                System.out.println("  |      /|\\");
                System.out.println("  |       | ");
                System.out.println("  |      / \\");
                System.out.println(" _|_        ");
                System.out.println("|   |________");
                System.out.println("|____________|");
                break;

            default:
                throw new AssertionError();
        }
    }
    //--------------------------------------------------------------------------
    //MÉTODO PARA LEER DIAS, UN INT ENTRE 1 Y 31
    //--------------------------------------------------------------------------
    /**
     * Solo permite introducir un numero entero entre 1 y 31. 
     * @param msj
     * @return 
     */
 public static int leerIntDia(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String auxiliar;
        int valor = 0;
        boolean error;

        do {
            error = false;
            try {
                do {
                    System.out.print(msj);
                    auxiliar = teclado.readLine();
                    valor = Integer.parseInt(auxiliar);
                    if (valor < 1 || valor > 31) {
                        System.err.println("\tError: El día de nacimiento debe estar entre 1 y 31.");
                    }
                } while (valor < 1 || valor > 31);

            } catch (IOException | NumberFormatException e) {
                error = true;
                System.err.println("\tError en método leerIntMayorACero: formato del número no válido");
                System.out.println(e.getMessage());
            }
        } while (error);
        return valor;
    }
    //--------------------------------------------------------------------------
    //MÉTODO PARA LEER MES, UN INT ENTRE 1 Y 12
    //--------------------------------------------------------------------------
    /**
     * Solo permite introducir un numero entero entre 1 y 12. 
     * @param msj
     * @return 
     */
 public static int leerIntMes(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String auxiliar;
        int valor = 0;
        boolean error;

        do {
            error = false;
            try {
                do {
                    System.out.print(msj);
                    auxiliar = teclado.readLine();
                    valor = Integer.parseInt(auxiliar);
                    if (valor < 1 || valor > 12) {
                        System.err.println("\tError: El mes de nacimiento debe estar entre 1 y 12.");
                    }
                } while (valor < 1 || valor > 12);

            } catch (IOException | NumberFormatException e) {
                error = true;
                System.err.println("\tError en método leerIntMayorACero: formato del número no válido");
                System.out.println(e.getMessage());
            }
        } while (error);
        return valor;
    }
    //--------------------------------------------------------------------------
    //MÉTODO PARA LEER ANO UN INT ENTRE 1923 Y 2023
    //--------------------------------------------------------------------------
    /**
     * Solo permite introducir un numero entero entre 1923 y 2023. 
     * @param msj
     * @return 
     */
 public static int leerIntAno(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String auxiliar;
        int valor = 0;
        boolean error;

        do {
            error = false;
            try {
                do {
                    System.out.print(msj);
                    auxiliar = teclado.readLine();
                    valor = Integer.parseInt(auxiliar);
                    if (valor < 1923 || valor > 2023) {
                        System.err.println("\tError: El año de nacimiento debe estar entre 1923 y 2023.");
                    }
                } while (valor < 1923 || valor > 2023);

            } catch (IOException | NumberFormatException e) {
                error = true;
                System.err.println("\tError en método leerIntMayorACero: formato del número no válido");
                System.out.println(e.getMessage());
            }
        } while (error);
        return valor;
    }
 
    //--------------------------------------------------------------------------
    //MÉTODO PARA LEER OPCION ENTRE 1 Y 2 
    //--------------------------------------------------------------------------
    /**
     * Solo permite introducir el numero 1 o numero 2. 
     * @param msj
     * @return 
     */
 public static int leerIntEntre1y2(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String auxiliar;
        int valor = 0;
        boolean error;

        do {
            error = false;
            try {
                do {
                    System.out.print(msj);
                    auxiliar = teclado.readLine();
                    valor = Integer.parseInt(auxiliar);
                    if (valor < 1 || valor > 2) {
                        System.err.println("\tError: Elige una opción entre [1] y [2].");
                    }
                } while (valor < 1 || valor > 2);

            } catch (IOException | NumberFormatException e) {
                error = true;
                System.err.println("\tError en método leerIntMayorACero: formato del número no válido");
                System.out.println(e.getMessage());
            }
        } while (error);
        return valor;
    }
 
  //--------------------------------------------------------------------------
    //MÉTODO PARA VALIDAR EL FORMATO DE UN EMAIL
    //--------------------------------------------------------------------------
    /**
     * Valida un email introducido utilizando las expresiones regulares.
     * @return 
     */
  public static String validarEmail() {    

        String email = "";
        boolean validado = false;

        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);

        do {
            System.out.println("Intoduce el email: ");

            try {
                email = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("\tError: fallo en la lectura");
            }

            //Expresiones regulares para el formato del email
            // 
            String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            boolean emailOK = matcher.matches();

            if (!emailOK){
                System.out.println("\tError: Formato de email incorrecto.");
            } else {
                validado = true;
            }
        } while (!validado);
        return email;
    }
    //--------------------------------------------------------------------------
    //MÉTODO PARA LIMPIAR LA PANTALLA DE LA CONSOLA
    //--------------------------------------------------------------------------
    /**
     * Imprime 20 lineas en blanco para limpiar la consola de codigo. 
     */
  public static void limpieza() {

        final int LIMPIEZA = 20;
        for (int i = 0; i < LIMPIEZA; i++) {
            System.out.println("");
        }
    }
    //--------------------------------------------------------------------------
    //MÉTODO PARA LEER UN STRING CON MAS DE 3 CARACTERES Y SOLO LETRAS
    //--------------------------------------------------------------------------
    /**
     * Compruebas si un String si tiene al menos tres caracteres y si solo contiene letras. 
     * @param msj
     * @return 
     */
   public static String leerStringMayor3(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadena = "cadena";
        boolean error, menor3;
        do{
            menor3 = false;
        do {
            error = false;
            try {
                System.out.print(msj);
                cadena = teclado.readLine();
                 if (!cadena.matches("[a-zA-Z]+")) {// utilizamos un If para comprobar si el codigo introducido son letras, para ello usamos las expresiones regulares [a-zA-Z]+ que comprende las letras minusculas y mayusculas solamente
                        System.out.println("La palabra debe contener solo letras.");
                        error = true;
                    }
            } catch (IOException e) {
                error = true;
                System.err.println("\tError en el método leerString");
                System.out.println(e.getMessage());
            }
        } while (error);
            if (cadena.length() < 3) {
                System.out.println("La palabra debe tener más de tres carácteres.");
                menor3 = true;
            }
                
            } while (menor3);
        return cadena.toUpperCase();
    }
    //--------------------------------------------------------------------------
    //MÉTODO PARA IMPRIMIR ENCABEZADO
    //--------------------------------------------------------------------------
    /**
     * Imprime el encabezado del juego 
     */
   public static void encabezadoJuego(){
        System.out.println("--------------------------------------------------");
        System.out.println("             JUEGO     DEL     AHORCADO           ");
        System.out.println("--------------------------------------------------");
        System.out.println("");
   } 
   
    //--------------------------------------------------------------------------
    //MÉTODO PARA LEER SI ES UNA LETRA
    //--------------------------------------------------------------------------
    /**
     * Comprueba si un char es una letra y la convierte en mayuscula . 
     * @param msj
     * @return 
     */
      public static char leerLetra(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadena = null;
        char letra = ' ';
        boolean error;

        do {
            error = false;

            try {
                System.out.print(msj);
                cadena = teclado.readLine();

                if (!cadena.matches("[a-zA-Z]")) {// Verifica si la cadena es de letras con expresiones regulares
                    System.err.println("Formato no valído, debe introducir una letra.");
                    error = true;
                }else{
                letra=Character.toUpperCase(cadena.charAt(0)); //Transformamos a mayusculas y coge el primer caracter de la cadena
                }
            } catch (IOException e) {
                error = true;
                System.err.println("\tError en el método leerString");
                System.out.println(e.getMessage());
            }
        } while (error);
        
        return letra;
    }
  
    //--------------------------------------------------------------------------
    //MÉTODO PARA ORDENAR E IMPRIMIR UN ARRAY
    //--------------------------------------------------------------------------
    /**
     * Ordena e imprime el array de LetraFallidas. 
     * @param arrayLetrasFallidas 
     */
     public static void mostrarLetrasFallidas (char[]arrayLetrasFallidas){
         Arrays.sort(arrayLetrasFallidas);
           System.out.println("Letras Fallidas: " + Arrays.toString(arrayLetrasFallidas));
     }
     
     //--------------------------------------------------------------------------
    //MÉTODO PARA LEER SI O NO
    //--------------------------------------------------------------------------
    /**
     * Comprueba si un char es una letra S o N y la convierte en mayuscula . 
     * @param msj
     * @return 
     */
     
      public static char leerSiNo(String msj) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadena = null;
        char letra = ' ';
        boolean error;

        do {
            error = false;
            try {
                System.out.print(msj);
                cadena = teclado.readLine();
                if (!(cadena.equalsIgnoreCase("s") || cadena.equalsIgnoreCase("n"))){// Verifica si la cadena es de letras con expresiones regulares
                    System.err.println("Formato no valído, debe introducir una S o una N.");
                    error = true;
                }else{
                letra=Character.toUpperCase(cadena.charAt(0)); //Transformamos a mayusculas y coge el primer caracter de la cadena
                }
            } catch (IOException e) {
                error = true;
                System.err.println("\tError en el método leerString");
                System.out.println(e.getMessage());
            }
        } while (error);
        
        return letra;
    }
}
             