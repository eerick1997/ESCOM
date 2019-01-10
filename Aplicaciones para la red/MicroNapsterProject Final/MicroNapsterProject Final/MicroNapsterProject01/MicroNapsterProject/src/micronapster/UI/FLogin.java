package micronapster.UI;

import micronapster.MyObject.User;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public class FLogin extends javax.swing.JFrame implements Serializable, Runnable {

    private Socket socket;
    private User user;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static final String host = "localhost";
    private static final int port = 5550;
    Boolean bool, registered;
    private Thread thread;

    public FLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void coonectSocket(User user) {
        
        System.out.println("userRegistered constructor starts!");
        this.user = user;
        try {
            System.out.println("Creating socket...");
            socket = new Socket(host, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            System.err.println("userRegistered IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("userRegistered Exception");
            e.printStackTrace();
        }
    }
 
    @Override
    public void run() {
        try {
            System.out.println("userRegistered.java, run method starts!");
            System.out.println("User object: " + user + " name: " + user.getUser() + " pass: " + user.getPassword());
            output.writeObject(user);
            registered = (Boolean)input.readObject();
            System.out.println("Server says: " + registered);
            if(registered && registered != null){
                JOptionPane.showMessageDialog(null, "Bienvenido " + user.getUser());
                (new FWelcome(user.getUser())).setVisible(true);
                setVisible(false);
            }
            else if (!registered && registered != null){
                JOptionPane.showMessageDialog(null, "Lo sentimos no hay coincidencias con el usuario y contraseña");
                BTN_iniciaSesion.setEnabled(true);
            }
            System.out.println("Closing socket");
            socket.close();
        } catch (Exception e) {
            System.err.println("userRegistered.java, run method Exception e");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_General = new javax.swing.JPanel();
        PNL_Napster = new javax.swing.JPanel();
        LBL_iniciaSesion = new javax.swing.JLabel();
        LBL_LogoNapster = new javax.swing.JLabel();
        LBL_Napster = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PNL_Content = new javax.swing.JPanel();
        LBL_Usuario = new javax.swing.JLabel();
        TXT_Usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        LBL_Contraseña = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        BTN_iniciaSesion = new javax.swing.JButton();
        LBL_wordRegister = new javax.swing.JLabel();
        LBL_Registrar = new javax.swing.JLabel();
        TXT_contraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PNL_General.setBackground(new java.awt.Color(0, 102, 51));

        PNL_Napster.setBackground(new java.awt.Color(255, 255, 255));

        LBL_iniciaSesion.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        LBL_iniciaSesion.setForeground(new java.awt.Color(51, 51, 255));
        LBL_iniciaSesion.setText("Bienvenido a");

        LBL_LogoNapster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/napster-100x100.png"))); // NOI18N

        LBL_Napster.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        LBL_Napster.setText("micro-napster");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Delete_15px_1.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        javax.swing.GroupLayout PNL_NapsterLayout = new javax.swing.GroupLayout(PNL_Napster);
        PNL_Napster.setLayout(PNL_NapsterLayout);
        PNL_NapsterLayout.setHorizontalGroup(
            PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_NapsterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PNL_NapsterLayout.createSequentialGroup()
                        .addComponent(LBL_iniciaSesion)
                        .addGap(0, 222, Short.MAX_VALUE))
                    .addComponent(LBL_Napster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(LBL_LogoNapster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        PNL_NapsterLayout.setVerticalGroup(
            PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_NapsterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_iniciaSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_Napster)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PNL_NapsterLayout.createSequentialGroup()
                .addGroup(PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_LogoNapster)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PNL_Content.setBackground(new java.awt.Color(255, 255, 255));

        LBL_Usuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LBL_Usuario.setForeground(new java.awt.Color(0, 102, 51));
        LBL_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Circled User Male_15px_2.png"))); // NOI18N
        LBL_Usuario.setText("Usuario");
        LBL_Usuario.setIconTextGap(10);

        TXT_Usuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TXT_Usuario.setForeground(new java.awt.Color(51, 51, 51));
        TXT_Usuario.setBorder(null);
        TXT_Usuario.setMinimumSize(new java.awt.Dimension(0, 15));
        TXT_Usuario.setOpaque(false);
        TXT_Usuario.setPreferredSize(new java.awt.Dimension(0, 15));
        TXT_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_UsuarioActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator1.setForeground(new java.awt.Color(0, 102, 0));

        LBL_Contraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LBL_Contraseña.setForeground(new java.awt.Color(0, 102, 51));
        LBL_Contraseña.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Password_15px_3.png"))); // NOI18N
        LBL_Contraseña.setText("Contraseña");
        LBL_Contraseña.setIconTextGap(10);

        jSeparator2.setBackground(new java.awt.Color(0, 102, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 102, 0));

        BTN_iniciaSesion.setBackground(new java.awt.Color(51, 102, 255));
        BTN_iniciaSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTN_iniciaSesion.setText("Iniciar sesión");
        BTN_iniciaSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_iniciaSesionActionPerformed(evt);
            }
        });

        LBL_wordRegister.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LBL_wordRegister.setText("No tengo cuenta, quiero");

        LBL_Registrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LBL_Registrar.setForeground(new java.awt.Color(51, 51, 255));
        LBL_Registrar.setText("Registrarme");
        LBL_Registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LBL_RegistrarMousePressed(evt);
            }
        });

        TXT_contraseña.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TXT_contraseña.setForeground(new java.awt.Color(51, 51, 51));
        TXT_contraseña.setBorder(null);
        TXT_contraseña.setMinimumSize(new java.awt.Dimension(0, 15));
        TXT_contraseña.setPreferredSize(new java.awt.Dimension(0, 15));
        TXT_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_contraseñaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PNL_ContentLayout = new javax.swing.GroupLayout(PNL_Content);
        PNL_Content.setLayout(PNL_ContentLayout);
        PNL_ContentLayout.setHorizontalGroup(
            PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_ContentLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BTN_iniciaSesion)
                .addGap(34, 34, 34))
            .addGroup(PNL_ContentLayout.createSequentialGroup()
                .addGroup(PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TXT_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PNL_ContentLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addGroup(PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LBL_Usuario)
                                .addComponent(LBL_Contraseña)))
                        .addGroup(PNL_ContentLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(LBL_wordRegister)
                            .addGap(18, 18, 18)
                            .addComponent(LBL_Registrar))
                        .addGroup(PNL_ContentLayout.createSequentialGroup()
                            .addGap(71, 71, 71)
                            .addGroup(PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TXT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PNL_ContentLayout.setVerticalGroup(
            PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_ContentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LBL_Usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_Contraseña)
                .addGap(1, 1, 1)
                .addComponent(TXT_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_iniciaSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_Registrar)
                    .addComponent(LBL_wordRegister))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PNL_GeneralLayout = new javax.swing.GroupLayout(PNL_General);
        PNL_General.setLayout(PNL_GeneralLayout);
        PNL_GeneralLayout.setHorizontalGroup(
            PNL_GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_Napster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PNL_Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PNL_GeneralLayout.setVerticalGroup(
            PNL_GeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_GeneralLayout.createSequentialGroup()
                .addComponent(PNL_Napster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PNL_Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_General, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_UsuarioActionPerformed
        LBL_Registrar.transferFocus();
    }//GEN-LAST:event_TXT_UsuarioActionPerformed

    private void LBL_RegistrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_RegistrarMousePressed
        FRegister register = new FRegister();
        setVisible(false);
        register.setVisible(true);
    }//GEN-LAST:event_LBL_RegistrarMousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        System.exit(0);
    }//GEN-LAST:event_jLabel3MousePressed

    private void TXT_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_contraseñaActionPerformed
        TXT_contraseña.transferFocus();
    }//GEN-LAST:event_TXT_contraseñaActionPerformed

    private void BTN_iniciaSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_iniciaSesionActionPerformed
        String user = TXT_Usuario.getText().trim();
        String password = TXT_contraseña.getText().trim();
        
        try {
            if (!user.equals("") && !password.equals("")) {
                User mUser = new User("", user, password, "");
                System.out.println("User object: " + mUser + " name: " + mUser.getUser() + " pass: " + mUser.getPassword());
                coonectSocket(mUser);
                BTN_iniciaSesion.setEnabled(false);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_BTN_iniciaSesionActionPerformed

    public static void main(String args[]) {    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_iniciaSesion;
    private javax.swing.JLabel LBL_Contraseña;
    private javax.swing.JLabel LBL_LogoNapster;
    private javax.swing.JLabel LBL_Napster;
    private javax.swing.JLabel LBL_Registrar;
    private javax.swing.JLabel LBL_Usuario;
    private javax.swing.JLabel LBL_iniciaSesion;
    private javax.swing.JLabel LBL_wordRegister;
    private javax.swing.JPanel PNL_Content;
    private javax.swing.JPanel PNL_General;
    private javax.swing.JPanel PNL_Napster;
    private javax.swing.JTextField TXT_Usuario;
    private javax.swing.JPasswordField TXT_contraseña;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
