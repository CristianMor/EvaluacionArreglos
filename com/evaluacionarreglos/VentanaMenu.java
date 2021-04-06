package com.evaluacionarreglos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class VentanaMenu extends JFrame{
    
    private JButton btnAgregar;
    private JButton btnImprimir;
    private JButton btnBuscar;
    private JButton btnFin;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    public static int in= 0;

    public Articulo objArti[] = new Articulo[3];
        
    public VentanaMenu(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Menu");
        
        textArea= new JTextArea("Infor");
        textArea.setBounds(160, 10, 300, 130);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

                        
        addBotones();
        accionesBtn();
        initArticulos();

        add(textArea);
    }

    public void setIn(int indice){
        this.in= indice;
    }

    public int getIn(){
        return this.in;
    }
    
    public void addBotones(){
        
        btnAgregar= new JButton("Agregar");
        btnImprimir= new JButton("Imprimir");
        btnBuscar= new JButton("Buscar");
        btnFin= new JButton("Fin");
        
        btnAgregar.setBounds(50, 10, 100, 30);

        btnImprimir.setBounds(50, 45, 100, 30);
        btnBuscar.setBounds(50, 80, 100, 30);
        btnFin.setBounds(50, 115, 100, 30);

        add(btnAgregar);
        add(btnImprimir);
        add(btnBuscar);
        add(btnFin);
    }
    
    public void accionesBtn(){
        btnAgregar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Agregar formAgregar = new Agregar(new VentanaMenu(), true, objArti);
                formAgregar.setVisible(true);
                System.out.println("Click Boton Agregar el valor de in es = "+in);
            }
        });
        
        btnImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int i=0;
                System.out.println("Click Boton Imprimir");
                while(i<objArti.length){
                    System.out.println("Articulo: "+i+"\nId: "+objArti[i].getId()+"\nNombre: "+objArti[i].getNombre()+"\nModelo: "+objArti[i].getModelo()+"\nPrecio: "+objArti[i].getPrecio()+"\nExistencia: "+objArti[i].getExistencia());
                    i++;
                }

                Imprimir formImprimir= new Imprimir(new VentanaMenu(), true);
                formImprimir.setVisible(true);
            }
        });

        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

            }
        });

        btnFin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(JOptionPane.showConfirmDialog(null, "Desea cerrar el programa?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, 2) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    
                }
            }            
        });
    }

    public void initArticulos(){
        for(int i=0; i< objArti.length; i++){
            objArti[i]= new Articulo();
        }
    }

    public static void main(String args[]){
        VentanaMenu Ventana = new VentanaMenu();
        Ventana.setBounds(50, 50, 500, 200);
        Ventana.setVisible(true);
    }
}
