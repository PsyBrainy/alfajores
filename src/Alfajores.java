
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Alfajores {


    public static double precio;

    public static void cuenta(String letraSabor){

        switch (letraSabor){
            case "C":
                precio += 1.20;
                break;
            case "D":
                precio += 1.10;
                break;
            case "F":
                precio += 0.80;
                break;
            case "L":
                precio += 0.70;
                break;
            case "M":
                precio += 2.05;
                break;
            case "N":
                precio += 2.85;
                break;
        }
    }

    public static void reglas(String[][] caja){

        int total = 0;

        for (int columna = 0; columna < 2 ; columna++){

            if (caja[columna][0].equals(caja [columna][1]) && caja[columna][0].equals(caja [columna][2])){
                precio+=2.50;
                precio+=0.60;
            }
            if (caja[columna][0].equals(caja [columna][1]) && caja[columna][0].equals(caja [columna][2])){
                precio+=0.60;
            }else if (caja[0][0].equals(caja [1][1]) && caja[0][0].equals(caja [2][2])){
                precio+=0.60;
            }else if (caja[2][0].equals(caja [1][1]) && caja[0][2].equals(caja [2][2])){
                precio+=0.60;
            }

            for (int fila = 0; fila < 2; fila++) {

                if (caja[fila][columna].equals(caja[fila][columna+1])){
                    total++;
                }
            }
        }

        if (total==9){
            precio-=3.40;
        }
        if (caja[1][1].equals("F")){
            precio+=9.80;
        }

    }
    public static void main(String[] args) {

        List<String> sabores = new ArrayList<>();

        String [] sabor = {"C","D","F","L","M","N"};
        SecureRandom random = new SecureRandom();

        String caja [][] =  new String[3][3];

        for (int letra = 0; letra < 1; letra++) {

            for (int fila = 0; fila < caja.length ; fila++){

                for (int columna = 0; columna < caja.length; columna++) {



                    caja [fila][columna]= sabor[random.nextInt(6)];

                    cuenta(caja [fila][columna]);

                    System.out.print(caja[fila][columna] + "");
                }
                System.out.println("");
            }
        }

        reglas(caja);

        System.out.println(precio);

    }



}


