package myProject.Controller;

import myProject.Model.Tablero;
import myProject.View.EditorTableroJugadorView;

import java.awt.Color;
import javax.swing.JOptionPane;
/**
 * se almacenan los datos de los tableros
 */

public class EditorTableroJugador {

    // Objetos donde se guarda la informacion del tablero del jugador
    private int[][] barcos;
    private Tablero jugador;

    //Interfaz grafica
    private EditorTableroJugadorView view;

    //Variable que lleva la cuenta de los barcos colocados en el tablero
    private int IDBarco = 1;

    //Constructor que inicializa los valores por defecto del tablero del jugador
    public EditorTableroJugador() {
        this.barcos = new int[10][10];
        this.jugador = new Tablero();

        //Crea un tablero vacio (sin barcos)
        for(int i=0; i<10; i++){
            for(int j=0; j<0; j++){
                this.barcos[i][j] = 0;
            }
        }
    }

    //Ingresa las coordenadas de un barco al arreglo provisional
    //Se pasan las coordenadas de la primera casilla y la dirección del barco (0: horizontal 1: vertical)

    /*
    Id de los barcos
        1: portaaviones (4 casillas)
        2 y 3: submarinos (3 casillas)
        4,5 y 6: destructores (2 casillas)
        7,8,9 y 10: fragatas (1 casilla)
    */
    public void insertarBarco(int x, int y, int direccion){

        //Determina el tamaño del barco segun su ID
        int tam;
        if(this.IDBarco == 1)
            tam = 4;
        else if(this.IDBarco >=2 && this.IDBarco <=3)
            tam = 3;
        else if(this.IDBarco >=4 && this.IDBarco <=6)
            tam = 2;
        else
            tam = 1;

        //Inserta el barco en el tablero sea de forma horizontal o vertical
        if(direccion == 0){
            if(x+tam <= 10){    //Comprueba que el barco no salga del limite del tablero
                int sum = 0;    //Creamos un contador para confirmar que no existe un barco en el sitio donde se quiere colocar al nuevo
                for(int i=0; i<tam; i++){
                    sum += this.barcos[x+i][y];
                }

                if(sum == 0){   //Si el area esta vacia, se coloca el barco
                    for(int i=0; i<tam; i++){
                        this.barcos[x+i][y] = this.IDBarco;
                        this.view.getCasillasTablero().get((y*10)+(x+i)).setEnabled(false);

                        switch(this.IDBarco){    //Segun el ID del barco, se pintan las casillas de un color diferente
                            case 0:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.cyan);
                                break;
                            case 1:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.BLUE);
                                break;
                            case 2:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.YELLOW);
                                break;
                            case 3:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.GREEN);
                                break;
                            case 4:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.MAGENTA);
                                break;
                            case 5:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.ORANGE);
                                break;
                            case 6:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.PINK);
                                break;
                            case 7:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.GREEN);
                                break;
                            case 8:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.WHITE);
                                break;
                            case 9:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.YELLOW);
                                break;
                            case 10:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.lightGray);
                                break;
                            default:
                                this.view.getCasillasTablero().get((y*10)+(x+i)).setBackground(Color.cyan);
                        }
                    }
                    this.IDBarco++;  //Aumentamos en 1 el ID del proximo barco
                } else
                    JOptionPane.showMessageDialog(null, "No es posible colocar el barco en esa posición");

            } else
                JOptionPane.showMessageDialog(null, "No es posible colocar el barco en esa posición");
        } else {
            //Se realiza lo mismo que se realizo anteriormente pero para el caso vertical
            if(y+tam <= 10){
                int sum = 0;
                for(int i=0; i<tam; i++){
                    sum += this.barcos[x][y+i];
                }
                if(sum == 0){
                    for(int i=0; i<tam; i++){
                        this.barcos[x][y+i] = this.IDBarco;
                        this.view.getCasillasTablero().get(((y+i)*10)+x).setEnabled(false);
                        switch(this.IDBarco){
                            case 0:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.cyan);
                                break;
                            case 1:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.BLUE);
                                break;
                            case 2:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.YELLOW);
                                break;
                            case 3:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.GREEN);
                                break;
                            case 4:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.MAGENTA);
                                break;
                            case 5:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.ORANGE);
                                break;
                            case 6:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.PINK);
                                break;
                            case 7:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.GREEN);
                                break;
                            case 8:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.WHITE);
                                break;
                            case 9:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.YELLOW);
                                break;
                            case 10:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.lightGray);
                                break;
                            default:
                                this.view.getCasillasTablero().get(((y+i)*10)+x).setBackground(Color.cyan);
                        }
                    }
                    this.IDBarco++;
                } else
                    JOptionPane.showMessageDialog(null, "No es posible colocar el barco en esa posición");

            } else
                JOptionPane.showMessageDialog(null, "No es posible colocar el barco en esa posición");
        }

        //Se cambia el texto guia del barco a colocar segun el tamaño del mismo
        if(this.IDBarco == 1)
            this.view.getSiguienteBarco().setText("Siguiente barco a colocar: Portaaviones [4 casillas]");
        else if(this.IDBarco >=2 && this.IDBarco <=3)
            this.view.getSiguienteBarco().setText("Siguiente barco a colocar: Submarino [3 casillas]");
        else if(this.IDBarco >=4 && this.IDBarco <=6)
            this.view.getSiguienteBarco().setText("Siguiente barco a colocar: Destructor [2 casillas]");
        else
            this.view.getSiguienteBarco().setText("Siguiente barco a colocar: Fragata [1 casilla]");

        //En caso de haber colocado todos los barcos se continua a la pantalla del juego
        if(this.IDBarco > 10){
            this.iniciarJuego();
        }
    }

    //Inicia la vista
    public void mostrarView(){
        this.view = new EditorTableroJugadorView(this);
    }

    //Manda el arreglo con las posiciones de los barcos del jugador al controlador del juego
    public void iniciarJuego(){
        this.view.cerrar();
        this.jugador.setTablero(this.barcos);
        JuegoController juego = new JuegoController(this.jugador);
    }
}
