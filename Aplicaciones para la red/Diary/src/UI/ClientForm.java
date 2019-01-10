package UI;

import Objects.Person;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ClientForm extends javax.swing.JFrame {

    //Constants
    private static final int port = 2345;
    private static final String host = "localhost";
    
    public ClientForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BTN_Send_Server = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BTN_Send_Server.setText("Enviar al servidor");
        BTN_Send_Server.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_Send_ServerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addComponent(BTN_Send_Server)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(238, Short.MAX_VALUE)
                .addComponent(BTN_Send_Server)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_Send_ServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_Send_ServerActionPerformed

        //Probably we catch an Exception
        try{
            /**Just for testing**/
            Scanner scanner = new Scanner(System.in);
            System.out.println("Datos del objeto persona");
            System.out.print("\n\tNombre -> ");
            String name = scanner.nextLine();
            System.out.print("\n\tFecha de nacimiento (dd-M-yyyy)-> ");
            String date = scanner.nextLine();
            System.out.print("\n\tDireccion -> ");
            String address = scanner.nextLine();
            System.out.print("\n\tEmail -> ");
            String email = scanner.nextLine();
            System.out.print("\n\tEdad -> ");
            int age = scanner.nextInt();
            /**End just for testing**/
            
            //Creating a socket for a client
            Socket socket = new Socket(host, port);
            //Getting IO stream Objects
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
           
            //We create an Object type Person
            Person person = new Person(name,address,email,age,date);
            //We write the object type Person
            objectOutputStream.writeObject(person);
            System.out.println("Object person sent");
            objectOutputStream.close();
            objectInputStream.close();
            socket.close();
            
        } catch(Exception e){
            System.err.println("An error has occurred with a client: " + e);
        }
        
    }//GEN-LAST:event_BTN_Send_ServerActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Send_Server;
    // End of variables declaration//GEN-END:variables
}
