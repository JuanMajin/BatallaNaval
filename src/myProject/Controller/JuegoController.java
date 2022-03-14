package myProject.Controller;

import myProject.Model.Tablero;
import myProject.View.JuegoView;

/**
*El controlador general del juego
*/

public class JuegoController {

    //Interfaz del juego y controlador de la IA
    private JuegoView view;
    private IAController ia;

    //Controladores de los tableros
    private TableroController ctrlJugador;
    private TableroController ctrlIA;

    //Constructor
    public JuegoController(Tablero tab) {
        this.ctrlJugador =  new TableroController(tab);
        this.ctrlIA = new TableroController(this.getTableroIA());
        this.view = new JuegoView(this);

        ia = new IAController(this);
        ia.start();
    }

    //Obtiene el tablero con los barcos de la IA
    private Tablero getTableroIA(){
        int[][] barcosIA = new int[10][10];

        for(int i=0; i<10; i++){
            for(int j=0; j<0; j++){
                barcosIA[i][j] = 0;
            }
        }

        int IDBarco = 1;
        while(IDBarco <= 10){

            //Selecciona una casilla al azar y una direccion para el barco
            int x = (int) (Math.random()*10);
            int y = (int) (Math.random()*10);
            int direccion = (int) (Math.random()*2);

            //Obtiene el tamaño del barco segun el ID del barco
            int tam;
            if(IDBarco == 1)
                tam = 4;
            else if(IDBarco >=2 && IDBarco <=3)
                tam = 3;
            else if(IDBarco >=4 && IDBarco <=6)
                tam = 2;
            else
                tam = 1;

            //Valida que el barco pueda ser colocado
            if(direccion == 0){
                if(x+tam <= 10){
                    int sum = 0;
                    for(int i=0; i<tam; i++){
                        sum += barcosIA[x+i][y];
                    }
                    if(sum == 0){
                        for(int i=0; i<tam; i++){
                            barcosIA[x+i][y] = IDBarco;
                        }
                        IDBarco++;
                    }
                }
            } else {
                if(y+tam <= 10){
                    int sum = 0;
                    for(int i=0; i<tam; i++){
                        sum += barcosIA[x][y+i];
                    }
                    if(sum == 0){
                        for(int i=0; i<tam; i++){
                            barcosIA[x][y+i] = IDBarco;
                        }
                        IDBarco++;
                    }
                }
            }
        }

        //Crea el tablero de la IA y le asigna los barcos anteriormente obtenidos
        Tablero tableroIA = new Tablero();
        tableroIA.setTablero(barcosIA);
        return tableroIA;
    }

    //Marca la finalización del turno del jugador y el comienzo del turno de la IA
    public void turnoIA(){
        this.ia.turnoIA();
    }

    //Getters de los contoladores de los tableros
    public TableroController getCtrlJugador() {
        return ctrlJugador;
    }

    public TableroController getCtrlIA() {
        return ctrlIA;
    }

    public JuegoView getView() {
        return this.view;
    }

    public IAController getIa() {
        return ia;
    }


}
