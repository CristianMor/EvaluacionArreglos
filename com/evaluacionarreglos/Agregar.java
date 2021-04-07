package com.evaluacionarreglos;


import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Agregar extends JDialog{

    private JButton btnBack;
    private JButton btnGuardar;
    private JLabel txtId;
    private JLabel txtNombre;
    private JLabel txtModelo;
    private JLabel txtPrecio;
    private JLabel txtExistencia;
    private JTextField nombreBox;
    private JTextField modeloBox;
    private JTextField precioBox;
    private JTextField existBox;

    private VentanaMenu aux;
    private int auxIn;

    public Agregar(VentanaMenu parent, boolean modal, Articulo[] arrObj){
        super(parent, modal);

        this.aux = parent;
        this.auxIn= aux.getIn();
        System.out.println("El valor de in recibido es = "+auxIn);

        setLayout(null);
        setBounds(200, 200, 410, 410);
        setResizable(false);
        setTitle("Nuevo Articulo");

        System.out.println("Clase agregar instanciada.");
        
        txtId= new JLabel("Id: "+String.valueOf(aux.getIn()));
        txtId.setBounds(10, 10, 200, 30);
        txtId.setEnabled(false);

        txtNombre= new JLabel("Nombre: ");
        txtNombre.setBounds(10, 45, 200, 30);
        nombreBox= new JTextField();
        nombreBox.setBounds(70, 48, 200, 25);

        txtModelo= new JLabel("Modelo: ");
        txtModelo.setBounds(10, 80, 200, 30);
        modeloBox= new JTextField();
        modeloBox.setBounds(70, 83, 200, 25);

        txtPrecio= new JLabel("Precio: ");
        txtPrecio.setBounds(10, 115, 200, 30);
        precioBox= new JTextField();
        precioBox.setBounds(70, 118, 200, 25);
        
        txtExistencia= new JLabel("Existencia: ");
        txtExistencia.setBounds(10, 150, 200, 30);
        existBox= new JTextField();
        existBox.setBounds(86, 153, 185, 25);

        btnBack= new JButton("Regresar");
        btnBack.setBounds(215, 185, 100, 30);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(10, 185, 100, 30);

        add(txtId);
        add(txtNombre);
        add(txtModelo);
        add(txtPrecio);
        add(txtExistencia);
        
        add(nombreBox);
        add(modeloBox);
        add(precioBox);
        add(existBox);

        add(btnBack);
        add(btnGuardar);

        accionBtn(arrObj);
        capturaTeclado();
    }

    public void capturaTeclado(){
        precioBox.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                char caracter = e.getKeyChar();
                
                if((caracter < '0') || (caracter > '9') && (caracter != '\b')){
                    e.consume();
                }
            }
            
            public void keyReleased(KeyEvent e){
            }

            public void keyPressed(KeyEvent e){

            }
        });
    }

    public void accionBtn(Articulo[] arr){

        btnGuardar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(esAlgunoVacio(nombreBox, modeloBox, precioBox, existBox)){
                    JOptionPane.showMessageDialog(null, "Por favor no deje ni un campo vacio.", "ERROR", JOptionPane.WARNING_MESSAGE);
                    
                }else{ 
                    try{ 
                        arr[auxIn].setId(auxIn);
                        arr[auxIn].setNombre(nombreBox.getText());
                        arr[auxIn].setModelo(modeloBox.getText());
                        arr[auxIn].setPrecio(Integer.parseInt(precioBox.getText()));
                        arr[auxIn].setExistencia(Integer.parseInt(existBox.getText()));
                
                        System.out.println("Nombre: "+nombreBox.getText()+"\nModelo: "+modeloBox.getText()+"\nPrecio: "+precioBox.getText()+"\nExistencia: "+existBox.getText());
                        auxIn +=1;
                        aux.setIn(auxIn);
                        System.out.println("Se setio in + 1= "+auxIn);
                        txtId.setText("Id: "+String.valueOf(auxIn));
                    }catch(ArrayIndexOutOfBoundsException err){
                        System.out.println("Ocurrio un error de tipo: "+err.getMessage());
                        JOptionPane.showMessageDialog(null, err.getMessage(), "ERROR", JOptionPane.WARNING_MESSAGE);
                        btnGuardar.setEnabled(false);
                    }finally{
                        System.out.println("Quedo in en = "+auxIn);
                    }
                    nombreBox.setText("");
                    modeloBox.setText("");
                    precioBox.setText("");
                    existBox.setText("");
                }
            }
        });

        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                aux.setIn(auxIn);
                System.out.println("Regreso in a VentanaMenu = "+auxIn);
                System.out.println("Regreso");
            }
        });
    }

    public boolean esAlgunoVacio(JTextField... textFields){
        for(JTextField textField: textFields){
            if(textField.getText().isEmpty()){
                return true;
            }
        }
        return false;
    }
}
