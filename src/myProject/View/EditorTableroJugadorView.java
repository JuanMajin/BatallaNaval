package myProject.View;

import myProject.Controller.EditorTableroJugador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
*Interfaz grafica del editor del tablero del jugador
*/

public class EditorTableroJugadorView {
    //Constrolador asociado a la vista
    private EditorTableroJugador ctrl;

    //Componentes de la interfaz
    private ArrayList<JButton> casillasTablero = new ArrayList<>();

    private JFrame frame = new JFrame();
    private ButtonGroup direccion = new ButtonGroup();
    private JRadioButton dirHor = new JRadioButton("Horizontal", true);
    private JRadioButton dirVer = new JRadioButton("Vertical", true);
    private JButton ayuda= new JButton("?");
    private JLabel direccionText = new JLabel("Selecciona la orientación del barco");
    private JLabel instruccion = new JLabel("Selecciona la primera casilla que ocupara el barco (izquierda-derecha o arriba-abajo segun la orientacion)");
    private JLabel siguienteBarco = new JLabel("Siguiente barco a colocar: Portaaviones [4 casillas]");
    public static final String MENSAJE_INICIO="Welcome to Batalla naval!"
            +"\nIn this game you must shoot down all the enemy ships to win"
            +"\nYou should do it before your opponent, otherwise your enemy will win."
            +"\nin the first phase you can choose how to position your ships"
            +"\nREMEMBER"
            +"\n1 aircraft carrier: occupies 4 spaces"
            +"\n2 submarines: occupy 3 spaces each."
            +"\n3 destroyers: occupy 2 spaces each"
            +"\n4 frigates: occupy 1 space each";

    public EditorTableroJugadorView(EditorTableroJugador ctrl) {

        this.ctrl = ctrl;

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(700, 470);
        this.frame.setTitle("Batalla Naval");
        this.frame.setLayout(null);

        this.dirHor.setBounds(400, 50, 100, 30);
        this.dirVer.setBounds(400, 80, 100, 30);
        this.frame.getContentPane().add(this.dirHor);
        this.frame.getContentPane().add(this.dirVer);

        this.direccion.add(this.dirHor);
        this.direccion.add(this.dirVer);

        this.direccionText.setBounds(400, 30, 200, 20);
        this.instruccion.setBounds(50, 360, 600, 20);
        this.siguienteBarco.setBounds(50, 385, 600, 30);
        this.siguienteBarco.setFont(new Font("Arial", Font.BOLD, 20));

        this.frame.add(this.direccionText);
        this.frame.add(this.instruccion);
        this.frame.add(this.siguienteBarco);

        this.addCoordenadas(50, 25);

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.casillasTablero.add(new JButton());
                this.casillasTablero.get(this.casillasTablero.size()-1).setBounds(80 + 30*j, 55 + 30*i, 30, 30);
                int x = j;
                int y = i;
                this.casillasTablero.get(this.casillasTablero.size()-1).addActionListener((ActionEvent e) -> {
                    //Comprueba la orientacion del barco deseada por el jugador
                    int selected;
                    if(this.dirHor.isSelected())
                        selected = 0;
                    else
                        selected = 1;
                    this.ctrl.insertarBarco(x, y, selected);
                });

                this.frame.getContentPane().add(this.casillasTablero.get(this.casillasTablero.size()-1));
            }
        }

        this.ayuda.setBounds(470,120,50,25);
        this.ayuda.addActionListener((ActionEvent e)->{
            JOptionPane.showMessageDialog(null, MENSAJE_INICIO);
        });
        this.frame.add(this.ayuda);

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
    public ArrayList<JButton> getCasillasTablero() {
        return casillasTablero;
    }

    public void cerrar(){
        this.frame.dispose();
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getSiguienteBarco() {
        return siguienteBarco;
    }

}