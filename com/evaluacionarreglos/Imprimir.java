package com.evaluacionarreglos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JButton;

public class Imprimir extends JDialog implements ActionListener{

    JButton btnRegresar;

    public Imprimir(VentanaMenu parent, boolean modal){
        super(parent, modal);

        setLayout(null);
        setBounds(20, 20, 300, 300);
        setResizable(false);
        setTitle("Imprimir");

        btnRegresar= new JButton("Regresar");
        btnRegresar.setBounds(20, 20, 100, 30);

        add(btnRegresar);

        btnRegresar.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnRegresar){
            System.out.println("Click boton regresa");
            setVisible(false);
        }
    }

}
