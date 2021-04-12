/* Clase VentanaMenu o clase principal esta clase hereda de la clase JFrame y es la principal del programa en ella se encuentra el arreglo de tipo Articulo el UI de la pantalla es el siguente consta de 4 botones para ejecutar diferentes funciones y un textArea donde se mostrara el resultado al realizar una busqueda
 * Nombre: Cristian Martin Moreno Rodriguez
 * Fecha: 29/marzo/2021 */

package com.evaluacionarreglos;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class VentanaMenu extends JFrame{

    //Declaracion de componentes y atributos de la clase
    private JButton btnAgregar;
    private JButton btnImprimir;
    private JButton btnBuscar;
    private JButton btnFin;
    private JTextArea textArea;

    //Se crea esta variable para poder ser modificada desde otra clase que hace referencia a esta clase
    public static int in= 0;

    public Articulo objArti[] = new Articulo[100];
        
    public VentanaMenu(){
        //Propiedades para el JFrame
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Menu");
        
        //Se inicializan los componentes y inicializa el arreglo de tipo Articulo, se modifican algunas propiedades y se agregan al jframe
        textArea= new JTextArea();
        textArea.setBounds(160, 10, 300, 130);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

                        
        addBotones();
        //Metodo donde se escucha alos botones por medio de actionlistener y se ejecutan los eventos
        accionesBtn();
        initArticulos();

        add(textArea);
    }

    //Metodo set y get del atributo in
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
                /*Se instancia e inicializa un objeto de la clase tipo Agregar y se mandan por parametros la referencia de la clase padre , modal como true y el arreglo de tipo Articulo*/
                Agregar formAgregar = new Agregar(new VentanaMenu(), true, objArti);
                formAgregar.setVisible(true);
                System.out.println("Click Boton Agregar el valor de in es = "+in);
            }
        });
        
        btnImprimir.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int i=0;
                System.out.println("Click Boton Imprimir");
                while(i<in){
                    //Imprimira por consola el arreglo de tipo Articulo solo imprimira los que esten agregados
                    System.out.println("Articulo: "+i+"\nId: "+objArti[i].getId()+"\nNombre: "+objArti[i].getNombre()+"\nModelo: "+objArti[i].getModelo()+"\nPrecio: "+objArti[i].getPrecio()+"\nExistencia: "+objArti[i].getExistencia());
                    i++;
                }
                /*Se instancia e inicializa un objeto de la clase Imprimir y se mandan por parametros la referencia de la clase padre, modal como true y el aareglo de Articulo y in que contiene el valo de los datos agregados*/
                Imprimir formImprimir= new Imprimir(new VentanaMenu(), true, objArti, in);
                formImprimir.setVisible(true);
            }
        });

        btnBuscar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Si al momento de buscar algun atributo que pertenece a Articulo y este es null evitariamos una exception de tipo nullpointer~ y si esto no tiene null entonces mostrariamos un joption panel con dos opciones para saber si desea buscar por id o por nombre
                if(objArti[0].getNombre() == null){
                    JOptionPane.showMessageDialog(null, "Error no se ah registrado ni un articulo.", "ERROR", JOptionPane.WARNING_MESSAGE);
                }else{
                    String [] opt= {"id", "nombre"};
                    int x = JOptionPane.showOptionDialog(null, "Seleccione como quiere buscar el articulo", "Buscar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opt, null);
                    System.out.println(x);
                    //con la variable x obtengo la opcion que elegio el usuario y de alli con un swtich decido que es lo que hara.
                    switch(x){
                        case 1:
                            String nombre= JOptionPane.showInputDialog(null, "Ingrese nombre a buscar: ", "Buscar", JOptionPane.QUESTION_MESSAGE);
                            System.out.println("Nombre: "+nombre);
                            int result= busquedaNombre(objArti, nombre);
                            if(result >= 0){
                                textArea.setText(" ");
                                textArea.append("---Articulo encontrado---\nId: "+objArti[result].getId()+"\nNombre: "+objArti[result].getNombre()+"\nModelo: "+objArti[result].getModelo()+"\nPrecio: $"+objArti[result].getPrecio()+"\nExistencia: "+objArti[result].getExistencia());
                            }else{
                                JOptionPane.showMessageDialog(null, "Error el nombre que busca no fue encontrado.", "ERROR", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        case 0: 
                            int id= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el id a buscar: ", "Buscar", JOptionPane.QUESTION_MESSAGE));
                            System.out.println("id: "+id);
                            int resultado= busquedaId(objArti, id);
                            System.out.println("Variable Resultado es= "+resultado);
                            if(resultado >= 0){
                                textArea.setText("");
                                textArea.append("---Articulo encontrado---\nId: "+objArti[resultado].getId()+"\nNombre: "+objArti[resultado].getNombre()+"\nModelo: "+objArti[resultado].getModelo()+"\nPrecio: $"+objArti[resultado].getPrecio()+"\nExistencia: "+objArti[resultado].getExistencia());
                            }else{
                                JOptionPane.showMessageDialog(null, "Error el id que busca no fue encontrado.", "ERROR", JOptionPane.WARNING_MESSAGE);
                            }
                            break;
                        default:
                            System.out.println("Operacion cancelada");
                    }
                }
            }
        });

//Finaliza el programa
        btnFin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(JOptionPane.showConfirmDialog(null, "Desea cerrar el programa?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, 2) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    
                }
            }            
        });
    }

//Se instancia el arreglo de tipo Articulo
    public void initArticulos(){
        for(int i=0; i< objArti.length; i++){
            objArti[i]= new Articulo();
        }
    }
//Busqueda lineal o secuencial para buscar por nombre
    public int busquedaNombre(Articulo A[], String X){
        int dere= this.getIn();

        for(int i=0; i<dere; i++){
            if(A[i].getNombre().compareToIgnoreCase(X) == 0){
                return i;
            }
        }
        return -1;
    }

//Busqueda binaria para buscar por id
    public int busquedaId(Articulo A[], int X){
        int izq=0;
        int dere= this.getIn()-1;
        while(izq <= dere){
            int medio= izq + (dere - izq) / 2;
            if(A[medio].getId() == X){
                return medio;
            }
            if(A[medio].getId() < X) { 
                izq= medio + 1;
            }else{
                dere= medio - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        VentanaMenu Ventana = new VentanaMenu();
        Ventana.setBounds(50, 50, 500, 200);
        Ventana.setVisible(true);
    }
}
