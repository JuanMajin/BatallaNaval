package myProject.Controller;

import java.awt.Color;
import java.awt.Insets;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
    Clase encargada de controlar las jugadas de la IA
*/

public class IAController extends Thread{

    //Variables para el manejo de turnos
    private boolean turnoIA = false;
    private int barcosHundidos = 0;

    //Objetos para la realizacion del disparo
    private JuegoController juego;

    //Constructor
    public IAController(JuegoController juego) {
        this.juego = juego;
    }

    //Ciclo principal de la IA
    @Override
    public void run() {
        while(true){
            if(this.turnoIA){   //Si es turno de la IA realiza su jugada
                this.disparoIA();
                this.turnoIA = false;
            }

            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(IAController.class.getName()).log(Level.SEVERE, null, ex);
            }

            //Si la IA ha hundido todos los barcos del jugador gana
            if(this.barcosHundidos == 10){
                JOptionPane.showMessageDialog(null, "¡La IA ha ganado!");
                System.exit(0);
            }
        }
    }

    //Metodo para que la IA realice un ataque
    public void disparoIA(){
        while(true){    //El metodo se repite hasta que encuentre una casilla en la que no se haya disparado anteriormente

            int x = (int) (Math.random()*10);   //Obtiene las coordenadas del disparo de forma aleatoria
            int y = (int) (Math.random()*10);

            if(!this.juego.getCtrlJugador().estaDisparado(x, y)){   //Valida que la casilla seleccionada este sin disparar

                this.juego.getCtrlJugador().dispararCasilla(x, y);  //Marca la casilla como disparada

                if(!this.juego.getCtrlJugador().estaOcupado(x, y))  //Si la casilla esta ocupada por un barco la pinta de negro, de lo contrario la marca con una X
                    this.juego.getView().getCasillasTableroJugador().get((y*10)+(x)).setText("X");
                else {
                    this.juego.getView().getCasillasTableroJugador().get((y*10)+(x)).setBackground(Color.BLACK);

                    if(this.juego.getCtrlJugador().estaHundido(this.juego.getCtrlJugador().getID(x, y))){   //Comprueba si el barco al que se toco pasa a estar hundido
                        int[][] barcos = this.juego.getCtrlJugador().getTab().getTablero();
                        for(int v=0; v<10; v++){ //Si sta hundido lo pinta de rojo
                            for(int h=0; h<10; h++){
                                if(barcos[h][v] == this.juego.getCtrlJugador().getID(x, y)){
                                    this.juego.getView().getCasillasTableroJugador().get((v*10)+(h)).setBackground(Color.red);

                                }
                            }
                        }
                        this.barcosHundidos++; //Aumenta en 1 los barcos hundods por la IA
                    }
                }

                this.juego.getView().getCasillasTableroJugador().get((y*10)+(x)).setMargin(new Insets(0, 0, 0, 0));

                break;
            }
        }
    }

    //Le da el turno a la IA
    public void turnoIA(){
        this.turnoIA = true;
    }

    //Verifica si es turno de la IA de jugar
    public boolean isTurnoIA() {
        return turnoIA;
    }


}
