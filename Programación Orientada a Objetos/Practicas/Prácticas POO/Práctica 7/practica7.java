import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
import java.util.*;

public class practica7 implements ActionListener{   
    
    public JLabel TXTNom, TXTRaz, TXTEd, TXTGen;
    public JTextField TXTWNom, TXTWRaz, TXTWEd, TXTWGen;
    public JButton BTNCon, BTNIns;
    public JFrame jframe;
    public String URL = "jdbc:mysql://localhost:3307/",
        dbname = "dbperros";
    public Connection con;
    
    public practica7(){
        jframe = new JFrame("Añadir perros");
        
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLayout(new GridLayout(5,2));
		jframe.setSize(300,300);
        
        TXTNom = new JLabel("Nombre");
        TXTRaz = new JLabel("Raza");
        TXTEd = new JLabel("Edad");
        TXTGen = new JLabel("Genero");

        TXTWNom = new JTextField(30);
        TXTWRaz = new JTextField(30);
        TXTWEd = new JTextField(30);
        TXTWGen = new JTextField(30);
        
        BTNCon = new JButton("Conectar");
        BTNIns = new JButton("Insertar");

        
        BTNCon.addActionListener(this);
        BTNIns.addActionListener(this);
        
        BTNIns.setEnabled(false);
        
        jframe.add(TXTNom);
        jframe.add(TXTWNom);
        jframe.add(TXTRaz);
        jframe.add(TXTWRaz);
        jframe.add(TXTEd);
        jframe.add(TXTWEd);
        jframe.add(TXTGen);
        jframe.add(TXTWGen);
        jframe.add(BTNCon);
        jframe.add(BTNIns);
        
        jframe.setVisible(true);
    }
    
    public Connection connect(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL + dbname, "root", "root");
            System.out.println("Connected successfully");
            BTNIns.setEnabled(true);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    
    public void insertNewDog(Connection conex){
        
        String Nombre, Raza, Genero;
        int Edad;
        Nombre = TXTWNom.getText().toString().trim();
        Raza = TXTWRaz.getText().toString().trim();
        Genero = TXTWGen.getText().toString().trim();
        Edad = Integer.parseInt(TXTWEd.getText().toString().trim());
        
        if(!(Nombre.equals("") && Raza.equals("") && Genero.equals("") && Edad > 0)){
            try{
                Statement st = conex.createStatement();
                st.executeUpdate("INSERT INTO tblperros (Nombre, Raza, Edad, Genero) VALUES ('"+Nombre+"', '"+Raza+"', '"+Edad+"', '"+Genero+"')");
                //conex.close();
                st.close();
                JOptionPane.showMessageDialog(null, "Se ha insertado a un nuevo perro");
                
            } catch(SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error añadiendo al nuevo perro");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Hay algún campo vacio");
        }
    }
    
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton)e.getSource();
        if(button == BTNCon)
            con = connect();
        
        if(button == BTNIns)
            insertNewDog(con);
    }
    
    public static void main(String[] args){
        new practica7();
    }
}