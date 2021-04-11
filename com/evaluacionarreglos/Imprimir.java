package com.evaluacionarreglos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Imprimir extends JDialog implements ActionListener{

    private JButton btnRegresar;
    private JTextArea textArea;
    private JScrollPane scrollPane;

    public Imprimir(VentanaMenu parent, boolean modal, Articulo[] arr, int indice){
        super(parent, modal);

        setLayout(null);
        setBounds(20, 20, 600, 300);
        setResizable(false);
        setTitle("Imprimir");

        textArea= new JTextArea();
        textArea.setEditable(false);

        scrollPane= new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(20, 20, 550, 200);

        btnRegresar= new JButton("Regresar");
        btnRegresar.setBounds(20, 225, 100, 30);

        add(btnRegresar);
        add(scrollPane);
        
        resultado(arr, indice);
        btnRegresar.addActionListener(this);
    }

    public void resultado(Articulo[] arr, int indice){
        int i=0;
        while(i<indice){
            textArea.append("---Articulo #"+(i+1)+"---\nID: "+arr[i].getId()+"   |-NOMBRE: "+arr[i].getNombre()+"   |-MODELO: "+arr[i].getModelo()+"   |-PRECIO: $"+arr[i].getPrecio()+"   |-EXISTENCIA: "+arr[i].getExistencia()+"\n------------------\n");
            i++;
        }
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnRegresar){
            System.out.println("Click boton regresa");
            setVisible(false);
        }
    }

}
