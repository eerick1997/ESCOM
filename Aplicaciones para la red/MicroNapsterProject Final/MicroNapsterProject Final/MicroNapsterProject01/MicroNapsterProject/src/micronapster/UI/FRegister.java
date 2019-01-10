package micronapster.UI;

import java.net.InetAddress;
import javax.swing.JOptionPane;
import micronapster.ClassesClient.SendUserData;
import micronapster.MyObject.User;
import java.net.*;
import java.io.*;

public class FRegister extends javax.swing.JFrame implements Serializable, Runnable {

    private InetAddress ip;

    private Socket socket;
    private User user;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static final String host = "localhost";
    private static final int port = 5550;
    Boolean bool, registered;
    private Thread thread;

    public FRegister() {
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
            System.err.println("userRegisteres Exception");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("userRegistered.java, run method starts!");
            output.writeObject(user);
            registered = (Boolean) input.readObject();
            System.out.println("Server says: " + registered);
            if (registered) {
                JOptionPane.showMessageDialog(null, "Este usuario ya existe, elije otro nick");
            } else {
                JOptionPane.showMessageDialog(null, "Bienvenido " + user.getUser());
                new SendUserData(user);
                setVisible(false);
                FWelcome welcome = new FWelcome(user.getUser());
                welcome.setVisible(true);
                BTN_register.setEnabled(false);
            }
            System.out.println("Closing socket");
            socket.close();
        } catch (Exception e) {
            System.err.println("userRegistered.java, run method Exception e");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PNL_GralRegister = new javax.swing.JPanel();
        PNL_Napster = new javax.swing.JPanel();
        LBL_logoNapster = new javax.swing.JLabel();
        LBL_Napster = new javax.swing.JLabel();
        LBL_micro = new javax.swing.JLabel();
        PNL_Register = new javax.swing.JPanel();
        LBL_Exit = new javax.swing.JLabel();
        LBL_Register = new javax.swing.JLabel();
        LBL_Name = new javax.swing.JLabel();
        TXT_Name = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        LBL_user = new javax.swing.JLabel();
        TXT_User = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        BTN_register = new javax.swing.JButton();
        LBL_word = new javax.swing.JLabel();
        LBL_iniciaSesion = new javax.swing.JLabel();
        LBL_password = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        TXT_password = new javax.swing.JPasswordField();
        LBL_passwordC = new javax.swing.JLabel();
        TXT_passwordC = new javax.swing.JPasswordField();
        jSeparator5 = new javax.swing.JSeparator();
        LBL_pC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PNL_GralRegister.setBackground(new java.awt.Color(0, 0, 0));

        PNL_Napster.setBackground(new java.awt.Color(102, 102, 102));
        PNL_Napster.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PNL_NapsterMouseDragged(evt);
            }
        });
        PNL_Napster.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PNL_NapsterMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                PNL_NapsterMouseReleased(evt);
            }
        });

        LBL_logoNapster.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        LBL_logoNapster.setForeground(new java.awt.Color(255, 255, 255));
        LBL_logoNapster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_logoNapster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/napster.png"))); // NOI18N

        LBL_Napster.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        LBL_Napster.setForeground(new java.awt.Color(255, 255, 255));
        LBL_Napster.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_Napster.setText("napster");

        LBL_micro.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        LBL_micro.setForeground(new java.awt.Color(255, 255, 255));
        LBL_micro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_micro.setText("micro");

        javax.swing.GroupLayout PNL_NapsterLayout = new javax.swing.GroupLayout(PNL_Napster);
        PNL_Napster.setLayout(PNL_NapsterLayout);
        PNL_NapsterLayout.setHorizontalGroup(
            PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_NapsterLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(LBL_logoNapster, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(LBL_micro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LBL_Napster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );
        PNL_NapsterLayout.setVerticalGroup(
            PNL_NapsterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_NapsterLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(LBL_logoNapster, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_micro)
                .addGap(11, 11, 11)
                .addComponent(LBL_Napster)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PNL_Register.setBackground(new java.awt.Color(51, 51, 51));
        PNL_Register.setForeground(new java.awt.Color(255, 255, 255));

        LBL_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Close Window_15px_3.png"))); // NOI18N
        LBL_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LBL_ExitMousePressed(evt);
            }
        });

        LBL_Register.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LBL_Register.setForeground(new java.awt.Color(255, 255, 255));
        LBL_Register.setText("Registrate");

        LBL_Name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBL_Name.setForeground(new java.awt.Color(255, 255, 255));
        LBL_Name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Circled User Male_15px_1.png"))); // NOI18N
        LBL_Name.setText("Nombre");
        LBL_Name.setToolTipText("");
        LBL_Name.setIconTextGap(8);

        TXT_Name.setBackground(new java.awt.Color(51, 51, 51));
        TXT_Name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TXT_Name.setForeground(new java.awt.Color(255, 255, 255));
        TXT_Name.setBorder(null);
        TXT_Name.setOpaque(false);
        TXT_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_NameActionPerformed(evt);
            }
        });

        LBL_user.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBL_user.setForeground(new java.awt.Color(255, 255, 255));
        LBL_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Add User Male_15px.png"))); // NOI18N
        LBL_user.setText("Usuario");
        LBL_user.setToolTipText("");
        LBL_user.setIconTextGap(8);

        TXT_User.setBackground(new java.awt.Color(51, 51, 51));
        TXT_User.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TXT_User.setForeground(new java.awt.Color(255, 255, 255));
        TXT_User.setBorder(null);
        TXT_User.setOpaque(false);
        TXT_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_UserActionPerformed(evt);
            }
        });

        BTN_register.setBackground(new java.awt.Color(102, 102, 255));
        BTN_register.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BTN_register.setForeground(new java.awt.Color(255, 255, 255));
        BTN_register.setText("Registrarme");
        BTN_register.setBorder(null);
        BTN_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_registerActionPerformed(evt);
            }
        });

        LBL_word.setForeground(new java.awt.Color(204, 204, 204));
        LBL_word.setText("Ya tengo cuenta, quiero");

        LBL_iniciaSesion.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        LBL_iniciaSesion.setForeground(new java.awt.Color(102, 102, 255));
        LBL_iniciaSesion.setText("Iniciar sesión");
        LBL_iniciaSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LBL_iniciaSesionMousePressed(evt);
            }
        });

        LBL_password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBL_password.setForeground(new java.awt.Color(255, 255, 255));
        LBL_password.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Password_15px_2.png"))); // NOI18N
        LBL_password.setText("Contraseña");
        LBL_password.setToolTipText("");
        LBL_password.setIconTextGap(8);

        TXT_password.setBackground(new java.awt.Color(51, 51, 51));
        TXT_password.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TXT_password.setForeground(new java.awt.Color(255, 255, 255));
        TXT_password.setBorder(null);
        TXT_password.setMinimumSize(new java.awt.Dimension(0, 15));
        TXT_password.setOpaque(false);
        TXT_password.setPreferredSize(new java.awt.Dimension(0, 15));
        TXT_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_passwordActionPerformed(evt);
            }
        });

        LBL_passwordC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LBL_passwordC.setForeground(new java.awt.Color(255, 255, 255));
        LBL_passwordC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Password_15px_2.png"))); // NOI18N
        LBL_passwordC.setText("Verifica tu contraseña");
        LBL_passwordC.setToolTipText("");
        LBL_passwordC.setIconTextGap(8);

        TXT_passwordC.setBackground(new java.awt.Color(51, 51, 51));
        TXT_passwordC.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TXT_passwordC.setForeground(new java.awt.Color(255, 255, 255));
        TXT_passwordC.setBorder(null);
        TXT_passwordC.setMinimumSize(new java.awt.Dimension(0, 15));
        TXT_passwordC.setOpaque(false);
        TXT_passwordC.setPreferredSize(new java.awt.Dimension(0, 15));
        TXT_passwordC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_passwordCActionPerformed(evt);
            }
        });

        LBL_pC.setForeground(new java.awt.Color(51, 102, 255));
        LBL_pC.setText("-----------------------------------------------------------");

        javax.swing.GroupLayout PNL_RegisterLayout = new javax.swing.GroupLayout(PNL_Register);
        PNL_Register.setLayout(PNL_RegisterLayout);
        PNL_RegisterLayout.setHorizontalGroup(
            PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_RegisterLayout.createSequentialGroup()
                .addContainerGap(310, Short.MAX_VALUE)
                .addComponent(LBL_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(PNL_RegisterLayout.createSequentialGroup()
                .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PNL_RegisterLayout.createSequentialGroup()
                        .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PNL_RegisterLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TXT_Name)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PNL_RegisterLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PNL_RegisterLayout.createSequentialGroup()
                                            .addComponent(LBL_word)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(LBL_iniciaSesion))
                                        .addGroup(PNL_RegisterLayout.createSequentialGroup()
                                            .addGap(23, 23, 23)
                                            .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(LBL_pC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                                .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(TXT_passwordC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TXT_User)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TXT_password, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PNL_RegisterLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(LBL_Register)
                                        .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LBL_user)
                                            .addComponent(LBL_Name)))
                                    .addGroup(PNL_RegisterLayout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LBL_password)
                                            .addComponent(LBL_passwordC))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PNL_RegisterLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_register, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PNL_RegisterLayout.setVerticalGroup(
            PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_RegisterLayout.createSequentialGroup()
                .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PNL_RegisterLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(LBL_Register, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(LBL_Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXT_password, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LBL_passwordC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TXT_passwordC, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_pC)
                .addGap(66, 66, 66)
                .addComponent(BTN_register, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PNL_RegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBL_word)
                    .addComponent(LBL_iniciaSesion))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout PNL_GralRegisterLayout = new javax.swing.GroupLayout(PNL_GralRegister);
        PNL_GralRegister.setLayout(PNL_GralRegisterLayout);
        PNL_GralRegisterLayout.setHorizontalGroup(
            PNL_GralRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PNL_GralRegisterLayout.createSequentialGroup()
                .addComponent(PNL_Napster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PNL_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PNL_GralRegisterLayout.setVerticalGroup(
            PNL_GralRegisterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_Napster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PNL_Register, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        PNL_Register.getAccessibleContext().setAccessibleName("Registrate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_GralRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PNL_GralRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int xx, xy;
    private void PNL_NapsterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PNL_NapsterMousePressed
        setOpacity((float) 0.8);
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_PNL_NapsterMousePressed

    private void PNL_NapsterMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PNL_NapsterMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_PNL_NapsterMouseDragged

    private void PNL_NapsterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PNL_NapsterMouseReleased
        setOpacity((float) 1.0);
    }//GEN-LAST:event_PNL_NapsterMouseReleased

    private void LBL_ExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_ExitMousePressed
        System.exit(0);
    }//GEN-LAST:event_LBL_ExitMousePressed

    private void TXT_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_NameActionPerformed
        TXT_Name.transferFocus();
    }//GEN-LAST:event_TXT_NameActionPerformed

    private void TXT_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_UserActionPerformed
        TXT_User.transferFocus();
    }//GEN-LAST:event_TXT_UserActionPerformed

    private void LBL_iniciaSesionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_iniciaSesionMousePressed
        FLogin login = new FLogin();
        setVisible(false);
        login.setVisible(true);
    }//GEN-LAST:event_LBL_iniciaSesionMousePressed

    private void BTN_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_registerActionPerformed

        String name = TXT_Name.getText().toUpperCase().trim();
        String user = TXT_User.getText().trim();
        String password = TXT_password.getText().trim();
        String passwordC = TXT_passwordC.getText().trim();
        FWelcome welcome;
        System.out.println("" + user);

        boolean alreadyExist = false;

        if (name.equals("")) //Nombre está vacio
        {
            JOptionPane.showMessageDialog(null, "El campo nombre usuario esta vacío.");
            limpiar();
        }

        if (!password.equals("")) // Contraseña no es vacío.
        {
            if (password.equals(passwordC)) //Confirma contraseña
            {
                LBL_pC.setText("Contraseñas coinciden");
                try {
                    User newUser = new User(name, user, password, "");
                    coonectSocket(newUser);
                    limpiar();
                } catch (Exception e) {
                    System.err.println("An exception has occurred in RegisterFrame class");
                    e.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Verifique su contraseña");
                LBL_pC.setText("Las contraseñas no coinciden");
                TXT_passwordC.setText("");
            }
        } else {
            limpiar();
        }
    }//GEN-LAST:event_BTN_registerActionPerformed

    private void TXT_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_passwordActionPerformed
        TXT_password.transferFocus();
    }//GEN-LAST:event_TXT_passwordActionPerformed

    private void TXT_passwordCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_passwordCActionPerformed
        TXT_passwordC.transferFocus();
    }//GEN-LAST:event_TXT_passwordCActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_register;
    private javax.swing.JLabel LBL_Exit;
    private javax.swing.JLabel LBL_Name;
    private javax.swing.JLabel LBL_Napster;
    private javax.swing.JLabel LBL_Register;
    private javax.swing.JLabel LBL_iniciaSesion;
    private javax.swing.JLabel LBL_logoNapster;
    private javax.swing.JLabel LBL_micro;
    private javax.swing.JLabel LBL_pC;
    private javax.swing.JLabel LBL_password;
    private javax.swing.JLabel LBL_passwordC;
    private javax.swing.JLabel LBL_user;
    private javax.swing.JLabel LBL_word;
    private javax.swing.JPanel PNL_GralRegister;
    private javax.swing.JPanel PNL_Napster;
    private javax.swing.JPanel PNL_Register;
    private javax.swing.JTextField TXT_Name;
    private javax.swing.JTextField TXT_User;
    private javax.swing.JPasswordField TXT_password;
    private javax.swing.JPasswordField TXT_passwordC;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        TXT_Name.setText("");
        TXT_User.setText("");
        TXT_password.setText("");
        TXT_passwordC.setText("");
    }

}
