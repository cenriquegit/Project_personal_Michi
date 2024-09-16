import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        boolean isllenada = false;
        boolean isGanada = false;
        boolean isSelectCorrec=false;
        boolean isNumUserVal=false;
        boolean isNumSysVal=false;

        System.out.println("¡-----Bienvenido al juego del Michi por Java-----!");

        while (!isGanada) {
           
            System.out.println("Por favor seleccione con que letra quieres jugar:   x    -    o");

            String selecUser="";
            
           
            while(!isSelectCorrec){
                
                selecUser=scanner.next();
                
                if (selecUser.equalsIgnoreCase("o")||selecUser.equalsIgnoreCase("x")) {
                        isSelectCorrec=true;
                    }else{
                        System.out.println("No es una opcion a elegir");
                    }
                
            }

            System.out.println();
            System.out.println("Tu letra seleccionada es: "+selecUser);

            String selecSystem="";
                
            switch (selecUser) {
                 case "X":
                     
                    selecSystem="O";
                     break;
                 case "x":
                     
                    selecSystem="o";
                     break;
                 case "O":
                     
                    selecSystem="X";
                     break;
                 case "o":
                     
                    selecSystem="x";
                     break;
                     
                
                }
            
            System.out.println("La letra restante que ha sido seleccionada por el system es: "+selecSystem);
            System.out.println();
            System.out.println("          ¡¡¡EMPEZO LA PARTIDA!!!          ");
            System.out.println();
            System.out.println("Escoge tu posicion con indices bidimencionales [Que fila] y [Que columa] se inicia contando desde el 0 ,que es igual a la primera(fila o columna) en ambos casos: ");
            System.out.println();



            String[][] michi = new String[3][3];
            int filaUser=3;
            int columnaUser=3;
            int filaSys=3;
            int columnaSys=3;

            do{
                
                    if(filaUser <3 || columnaUser<3 ){
                        for (int i = 0; i < michi.length; ++i) {
                        
                            for (int j = 0; j < michi.length; ++j) {
                            michi[filaUser][columnaUser] = selecUser;
                        }
                    }
                }
                    else{
                    
                        for (int i = 0; i < michi.length; ++i) {
                        
                            for (int j = 0; j < michi.length; ++j) {
                            michi[i][j] = "_";
                        }
                    }
                }


                    System.out.println("         col 0   col 1   col 2");


            
                    for (String[] mich : michi) {
                        
                        System.out.print("fila :  ");


                        for (int i = 0; i < mich.length; ++i) {

                            switch (i) {
                                
                                case 0:
                                System.out.print("   "+mich[i]+" ");
                                    break;
                                case 2:
                                System.out.print("  " + mich[i] + "     ");
                            
                                System.out.println();
                                    break;
                                default:
                                System.out.print("     " + mich[i] + "     ");
                                    break;
                            
                            }
                        }
                    }


                    while(!isNumUserVal){

                        System.out.print("Tu fila que quieres seleccionar es :");
                        filaUser=scanner.nextInt();

                        System.out.print("Tu columna que quieres seleccionar es :");
                        columnaUser=scanner.nextInt();

                            if(filaUser <4 && columnaUser <4)
                            {
                                isNumUserVal=true;
                            }else{
                                System.out.println("Vuelve a seleccionar tu fila y columna:");
                            } 
                    }
                    while(!isNumSysVal){

                        System.out.print("La fila seleccionada por el Systema es :");
                        double filaSysRandom=Math.random();

                            if (filaSysRandom<0.34) {

                                filaSys=1;
                            
                            }else if(filaSys<0.67){
    
                                filaSys=2;
    
                            }else{
    
                                filaSys=3;
                            }

                        System.out.print("Tu columna seleccionada por el Systema es :");
                        double columnaSysRandom=Math.random();

                            if(filaUser <4 && columnaUser <4)
                            {
                                isNumUserVal=true;
                            }else{
                                System.out.println("Vuelve a seleccionar tu fila y columna:");
                            } 
                    }



            }
            while (!isllenada);

            


            isGanada=true;
        }

        scanner.close();
    }
}