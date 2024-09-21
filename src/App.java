import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        boolean isSelectCorrec=false;


        System.out.println("¡-----Bienvenido al juego del Michi por Java-----!");


            //Codigo para seleccionar la letra con la que quiere jugar cada uno:
            //Pedir dato y definicion de la varible en la que se guardara:
           
            System.out.println("Por favor seleccione con que letra quieres jugar:   x    -    o");

            String selecUser="";


                //Codigo para que ignore si es mayuscula o minuscula y lo guarde en la variable,a la vez hace un bucle para evitar que seleccione un caracter que no sea la x - o :
           
                while(!isSelectCorrec){

                    selecUser=scanner.next();

                    if (selecUser.equalsIgnoreCase("o")||selecUser.equalsIgnoreCase("x")) {
                            isSelectCorrec=true;
                        }else{
                            System.out.println("No es una opcion a elegir");
                        }
                    
                }

                //Mostrar tu letra selecionada:

            System.out.println();
            System.out.println("Tu letra seleccionada es: "+selecUser);

            //Definicion de la variable donde se guardara la letra que queda como la selecionada de systema:

            String selecSystem="";

            //Creacion de un Switch con casos ,que dependiendo de la letra que escoja el usuario se pondra la que queda con el mismo formato,minuscula a minuscula o mayuscula a mayuscula:
                
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
                //Mostrar la letra elegida por el systema:
            
            System.out.println("La letra restante que ha sido seleccionada por el system es: "+selecSystem);
            System.out.println();

            //Inicio deljuego:
            System.out.println("          ¡¡¡EMPEZO LA PARTIDA!!!          ");
            System.out.println();
            System.out.println("Escoge tu posicion con indices bidimencionales [Que fila] y [Que columa] se inicia contando desde el 0 ,que es igual a la primera(fila o columna) en ambos casos: ");
            System.out.println();

            //Deckaracion y definicion del array y de las variable que se usaran para dar valores a las posiciones de cada uno:

   
            int filaSys=3;
            int columnaSys=3;


            //Codigo para recorrer el array bidimensional y agregarle _ a todos los campos o valores dentro:
            boolean isGanada = false;
    
    while (!isGanada) {
            System.out.println("Este es el ESQUEMA");

            String[][] michi = {{"_","_","_"},{"_","_","_"},{"_","_","_"}};

            boolean isllenada = false;

            //Codigo para que muestre en pantalla el esquema del MICHI:

            System.out.println("         col 0   col 1   col 2");

                for (String[] mich : michi) {

                    System.out.print("fila :  ");
                
                    for (int z = 0; z < mich.length; ++z) {
                    
                        switch (z) {

                            case 0:
                            System.out.print("   "+mich[z]+" ");
                                break;
                            case 2:
                            System.out.print("  " + mich[z] + "     ");
                        
                            System.out.println();
                                break;
                            default:
                            System.out.print("     " + mich[z] + "     ");
                                break;
                        
                        }
                    }
                }




                System.out.println();


                while (!isllenada && !isGanada){
                            
                         //Seleccion del usuario de la posicion ,se repeti hasta que sea una posicion valida:
                        
                        int filaUser=3;
                        int columnaUser=3;
                        int espaciosLlenos=0 ;

                        boolean isPasicionUserAvailable=false;
                        boolean isVacio=false;

    
                            while (!isPasicionUserAvailable){     
                                   
                                boolean filaCorecta=false;
                                boolean columnaCorrecta=false;
                                        
                                while(!filaCorecta) {
                                    
                                    String filaStringUser;
                                    
                                    System.out.print("Tu fila seleccionada es :");
                                    
                                    filaStringUser=scanner.next();
                                        
                                    try {
                                            filaUser=Integer.parseInt(filaStringUser);
                                                if (filaUser==Integer.parseInt(filaStringUser)) {
                                                    if (filaUser<3) {
                                                        filaCorecta=true;
                                                    System.out.println("--!!!Fila coreectamente seleccionada: "+filaUser+" !!!--");
                                                    }
                                                }
                                        } catch (Exception e) {
                                            System.out.println();
                                            System.out.println( "fila incorrectaemnte seleccionada , Vuelva seleccionar:");
                                            System.out.println();
                                        }
                                }
                            
                                while(!columnaCorrecta){
                                    String columStringSystem;
                                
                                    System.out.print("Tu columna seleccionada es :");
                                
                                    columStringSystem=scanner.next();
                                  
                                    try {
                                        columnaUser=Integer.parseInt(columStringSystem);
                                            if (columnaUser==Integer.parseInt(columStringSystem)) {
                                                if (columnaUser<3) {
                                                    columnaCorrecta=true;
                                                System.out.println("--!!!Columna coreectamente seleccionada: "+columnaUser+" !!!--");
                                                }
                                                ;
                                            }
                                        } catch (Exception e) {
                                            System.out.println();
                                            System.out.println( "Columna incorrectaemnte seleccionada , Vuelva seleccionar:");
                                            System.out.println();
                                        }
                                }
                                    
                                
                                    //Codigo para colocar la letra del usuario en la posicion que selecciono:
                            
                                    if(michi[filaUser][columnaUser]!=selecSystem && michi[filaUser][columnaUser]!=selecUser){
                                    
                                    michi[filaUser][columnaUser] = selecUser;
                                    isPasicionUserAvailable=true;
                                    }else{
                                        System.out.println();
                                        System.out.println("---La Posicion esta OCUPADA, Vuelve a seleccionar de nuevo---");
                                        System.out.println();
                                    }
                                
                            }
                                //Codigo para que muestre en pantalla el esquema del MICHI:
                    
                                System.out.println("         col 0   col 1   col 2");

                                for (String[] mich : michi) {

                                    System.out.print("fila :  ");
                                
                                
                                    for (int z = 0; z < mich.length; ++z) {
                                    
                                        switch (z) {

                                            case 0:
                                            System.out.print("   "+mich[z]+" ");
                                                break;
                                            case 2:
                                            System.out.print("  " + mich[z] + "     ");
                                        
                                            System.out.println();
                                                break;
                                            default:
                                            System.out.print("     " + mich[z] + "     ");
                                                break;
                                        
                                        }
                                    }
                                }
                                System.out.println();

                                //Codigo para comprobar si se formo una fila o diagonal con la letra del Usuario:

                                if (michi[0][0]==selecUser ) {
                                    if(michi[1][1]==selecUser && michi[2][2]==selecUser){
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;

                                    }
                                    if(michi[0][1]==selecUser && michi[0][2]==selecUser){
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if(michi[1][0]==selecUser && michi[2][0]==selecUser){
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                }
                                if(michi[1][1]==selecUser){
                                    if (michi[0][1]==selecUser && michi[2][1]==selecUser) {
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if (michi[1][0]==selecUser && michi[1][2]==selecUser) {
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if (michi[0][2]==selecUser && michi[2][0]==selecUser) {
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                }
                                if(michi[2][2]==selecUser){
                                    if (michi[1][2]==selecUser && michi[0][2]==selecUser) {
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;

                                    }
                                    if(michi[2][0]==selecUser && michi[2][1]==selecUser){
                                        System.out.println("FELICIDADES! eres un WINNER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                }
                    
                                    //Codigo para para cuando se llena el michi:

                                        for(int j=0;j<michi.length;++j){
                                            if (michi[0][j]!="_" ) {
                                                    espaciosLlenos += 1 ;
                                                }
    
                                            if(michi[1][j]!="_"){
                                                espaciosLlenos += 1 ;
                                            }

                                            if(michi[2][j]!="_"){
                                                espaciosLlenos += 1 ;
                                            }

                                            if (espaciosLlenos==9 ) {
                                                
                                                isllenada=true;
                                                isVacio=true;
                                            } 
                                             
                                        }

                                //Selecccionar la posicion en el que se colocara la letra del system comparando si el campo tiene la letra del usuario,si es asi se evitara y volvera a selecionar la posiciom hasta que no esta en la posicion la letra del usuario:

                                while (!isVacio) {

                                    double filaSysRandom=Math.random();

                                    if (filaSysRandom<0.34){     
                                    
                                        filaSys=0;

                                    
                                        }else if(filaSys<0.67){ 
                                        
                                            filaSys=1;  
                                        
                                        }else{  
                                        
                                            filaSys=2;

                                        }
                                    
                                    double columnaSysRandom=Math.random();   
                                    
                                    
                                    if (columnaSysRandom<0.34) {

                                        columnaSys=0;    
                                    
                                        }else if(columnaSys<0.67){   
                                    
                                        columnaSys=1;    
                                    
                                        }else {  
                                        
                                        columnaSys=2;
                                        }

                                    //Codigo para colocar la letra que selecciono en la posiccion del michi que selecciono al azar:

                                    if (michi[filaSys][columnaSys]!=selecUser && michi[filaSys][columnaSys]!=selecSystem) {
                                        
                                        System.out.println();
                                        System.out.println("La fila seleccionada por el Systema es :"+filaSys);
                                        System.out.println("La columna seleccionada por el Systema es :"+columnaSys);
                                        System.out.println();

                                        michi[filaSys][columnaSys]=selecSystem;
                             
                                       //Codigo para que muestre en pantalla el esquema del MICHI:

                                        System.out.println("         col 0   col 1   col 2");

                                        for (String[] mich : michi) {
                                        
                                            System.out.print("fila :  ");
                                        
                                        
                                            for (int z = 0; z < mich.length; ++z) {
                                            
                                                switch (z) {
                                                
                                                    case 0:
                                                    System.out.print("   "+mich[z]+" ");
                                                        break;
                                                    case 2:
                                                    System.out.print("  " + mich[z] + "     ");
                                                
                                                    System.out.println();
                                                        break;
                                                    default:
                                                    System.out.print("     " + mich[z] + "     ");
                                                        break;
                                                
                                                         }
                                                     }
                                                 }
                                                System.out.println();

                                        isVacio=true;

                                    }
                                }

                                //Codigo para comprobar si se formo una fila o diagonal con la letra del system:

                                if(michi[0][0]==selecSystem){
                                    if (michi[0][1]==selecSystem && michi[0][2]==selecSystem) {
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if(michi[1][0]==selecSystem && michi[2][0]==selecSystem){
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if(michi[1][1]==selecSystem && michi[2][2]==selecSystem){
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                }
                                if(michi[1][1]==selecSystem){
                                    if(michi[1][0]==selecSystem && michi[1][2]==selecSystem){
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if(michi[0][1]==selecSystem && michi[2][1]==selecSystem){
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if(michi[0][2]==selecSystem && michi[2][0]==selecSystem){
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                }
                                if(michi[2][2]==selecSystem){
                                    if (michi[1][2]==selecSystem && michi[0][2]==selecSystem) {
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                    if(michi[2][1]==selecSystem && michi[2][0]==selecSystem){
                                        System.out.println("LAMENTABLE!! eres un LOOSER!!!");
                                        isGanada=true;
                                        break;
                                    }
                                }
                }
        }

        scanner.close();
    }
}