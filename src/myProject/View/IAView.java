package myProject.View;

import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
*Vista de la disposicion de los barcos de la IA identificados por colores
*/

public class IAView {
    private ArrayList<JButton> casillasTablero = new ArrayList<>();
    private int[][] barcos;

    private JFrame frame = new JFrame();

    public IAView(int[][] barcos) {

        this.barcos = barcos;

        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(370, 390);
        this.frame.setTitle("Batalla Naval");
        this.frame.setLayout(null);

        this.addCoordenadas(10, 10);

        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                this.casillasTablero.add(new JButton());
                this.casillasTablero.get(this.casillasTablero.size()-1).setBounds(40 + 30*j, 40 + 30*i, 30, 30);
                this.casillasTablero.get(this.casillasTablero.size()-1).setEnabled(false);

                switch(this.barcos[j][i]){
                    case 0:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.cyan);
                        break;
                    case 1:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.BLUE);
                        break;
                    case 2:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.DARK_GRAY);
                        break;
                    case 3:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.GREEN);
                        break;
                    case 4:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.MAGENTA);
                        break;
                    case 5:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.ORANGE);
                        break;
                    case 6:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.PINK);
                        break;
                    case 7:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.RED);
                        break;
                    case 8:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.WHITE);
                        break;
                    case 9:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.YELLOW);
                        break;
                    case 10:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.lightGray);
                        break;
                    default:
                        this.casillasTablero.get(this.casillasTablero.size()-1).setBackground(Color.cyan);
                }

                this.frame.getContentPane().add(this.casillasTablero.get(this.casillasTablero.size()-1));
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
}
