package myProject.View;

import myProject.Controller.JuegoController;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
    La interfaz grafica del tablero de juego del jugador
*/

public class JuegoView {
    //Controlador asociado a la vista
    private JuegoController ctrl;

    //Casillas de los tableros
    private ArrayList<JButton> casillasTableroJugador = new ArrayList<>();
    private ArrayList<JButton> casillasTableroIA= new ArrayList<>();

    //Componentes Graficos
    private JFrame frame = new JFrame();
    private JButton verIA = new JButton("Ver barcos de la IA");
    private JLabel jugadorTableroLabel = new JLabel("TABLERO DE POSICIÓN");
    private JLabel IATableroLabel = new JLabel("TABLERO PRINCIPAL");

    //Contador de barcos hundidos del jugador
    private int barcosHundidosJugador = 0;

    public JuegoView(JuegoController ctrl) {

        this.ctrl = ctrl;

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(750, 480);
        this.frame.setTitle("Batalla Naval");
        this.frame.setLayout(null);

        this.jugadorTableroLabel.setBounds(30, 25, 330, 30);
        this.IATableroLabel.setBounds(380, 25, 330, 30);
        this.frame.add(this.jugadorTableroLabel);
        this.frame.add(this.IATableroLabel);

        this.verIA.setBounds(470, 390, 150, 25);
        this.verIA.addActionListener((ActionEvent e) -> {
            IAView verIA = new IAView(this.ctrl.getCtrlIA().getTab().getTablero());
        });

        this.addCoordenadas(30, 55);
        this.addCoordenadas(380, 55);


        this.frame.add(this.verIA);

        //Tablero de posiciones de barcos del jugador
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.casillasTableroJugador.add(new JButton());
                this.casillasTableroJugador.get(this.casillasTableroJugador.size()-1).setBounds(60 + 30*j, 85 + 30*i, 30, 30);
                this.casillasTableroJugador.get(this.casillasTableroJugador.size()-1).setEnabled(false);

                if(this.ctrl.getCtrlJugador().estaDisparado(j, i)){

                }

                switch(this.ctrl.getCtrlJugador().getID(j, i)){
                    case 0:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.cyan);
                        break;
                    case 1:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.BLUE);
                        break;
                    case 2:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.YELLOW);
                        break;
                    case 3:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.GREEN);
                        break;
                    case 4:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.MAGENTA);
                        break;
                    case 5:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.ORANGE);
                        break;
                    case 6:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.PINK);
                        break;
                    case 7:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.GREEN);
                        break;
                    case 8:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.WHITE);
                        break;
                    case 9:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.YELLOW);
                        break;
                    case 10:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.lightGray);
                        break;
                    default:
                        this.casillasTableroJugador.get((i*10)+(j)).setBackground(Color.cyan);
                }

                this.frame.getContentPane().add(this.casillasTableroJugador.get(this.casillasTableroJugador.size()-1));
            }
        }

        //Tablero principal del jugador donde realiza las jugadas
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.casillasTableroIA.add(new JButton());
                this.casillasTableroIA.get(this.casillasTableroIA.size()-1).setBounds(410 + 30*j, 85 + 30*i, 30, 30);


                int x = j;
                int y = i;
                this.casillasTableroIA.get(this.casillasTableroIA.size()-1).addActionListener((ActionEvent e) -> {
                    if(!this.ctrl.getIa().isTurnoIA()){
                        this.ctrl.getCtrlIA().dispararCasilla(x, y);

                        if(this.ctrl.getCtrlIA().estaDisparado(x, y)){
                            if(this.ctrl.getCtrlIA().estaOcupado(x, y)){
                                this.casillasTableroIA.get((y*10)+(x)).setBackground(Color.BLACK);
                                if(this.ctrl.getCtrlIA().estaHundido(this.ctrl.getCtrlIA().getID(x, y))){
                                    int[][] barcos = this.ctrl.getCtrlIA().getTab().getTablero();
                                    for(int v=0; v<10; v++){
                                        for(int h=0; h<10; h++){
                                            if(barcos[h][v] == this.ctrl.getCtrlIA().getID(x, y)){
                                                this.casillasTableroIA.get((v*10)+(h)).setBackground(Color.red);
                                            }
                                        }
                                    }
                                    this.barcosHundidosJugador++;
                                }
                            } else {
                                this.casillasTableroIA.get((y*10)+(x)).setBackground(Color.cyan);
                                this.casillasTableroIA.get((y*10)+(x)).setText("X");
                                this.casillasTableroIA.get((y*10)+(x)).setForeground(Color.RED);
                                this.casillasTableroIA.get((y*10)+(x)).setMargin(new Insets(0, 0, 0, 0));
                            }
                        }
                        this.casillasTableroIA.get((y*10)+(x)).setEnabled(false);
                        this.ctrl.turnoIA();
                    } else
                        JOptionPane.showMessageDialog(null, "Por favor espera tu turno");

                    if(this.barcosHundidosJugador == 10){
                        JOptionPane.showMessageDialog(null, "¡Le has ganado a la IA!");
                        System.exit(0);
                    }

                });

                this.frame.getContentPane().add(this.casillasTableroIA.get(this.casillasTableroIA.size()-1));
            }
        }

        this.frame.setVisible(true);
        this.frame.setResizable(false);
    }

    //Agrega las coordenadas al tablero de casillas
    private void addCoordenadas(int x, int y){
        JButton boton0 = new JButton();
        boton0.setBounds(x, y, 30, 30);
        boton0.setEnabled(false);
        boton0.setMargin(new Insets(0, 0, 0, 0));
        boton0.setBackground(Color.WHITE);
        this.frame.getContentPane().add(boton0);
        for(int i=0; i<10; i++){
            JButton botonEjeX = new JButton(String.valueOf((char)(i+65)));
            botonEjeX.setBounds(x+30*(i+1), y, 30, 30);
            botonEjeX.setEnabled(false);
            botonEjeX.setMargin(new Insets(0, 0, 0, 0));
            botonEjeX.setBackground(Color.WHITE);
            this.frame.getContentPane().add(botonEjeX);
        }
        for(int i=0; i<10; i++){
            JButton botonEjeY = new JButton(String.valueOf(i+1));
            botonEjeY.setBounds(x, y+30*(i+1), 30, 30);
            botonEjeY.setEnabled(false);
            botonEjeY.setMargin(new Insets(0, 0, 0, 0));
            botonEjeY.setBackground(Color.WHITE);
            this.frame.getContentPane().add(botonEjeY);
        }
    }

    //Getters
    public ArrayList<JButton> getCasillasTableroJugador() {
        return casillasTableroJugador;
    }

    public ArrayList<JButton> getCasillasTableroIA() {
        return casillasTableroIA;
    }

    public void cerrar(){
        this.frame.dispose();
    }
}
