package pkg01_kaibox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Frame_DP extends javax.swing.JFrame {

    String str = "C:\\Users\\Erick\\Documents\\ESCOM\\Aplicaciones para la red\\Practicas\\01_KAIBOX\\Documents";
    File folder = new File(str);

    public Frame_DP() {
        initComponents();
        setLocationRelativeTo(null);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LBL_kaibox = new javax.swing.JLabel();
        LBL_logo = new javax.swing.JLabel();
        SPT_one = new javax.swing.JSeparator();
        SPT_two = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        LBL_upload = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Upload = new javax.swing.JTable();
        BTN_Upload = new javax.swing.JButton();
        LBL_Download = new javax.swing.JLabel();
        SPT_gral = new javax.swing.JSeparator();
        LBL_exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(97, 212, 195));

        LBL_kaibox.setBackground(new java.awt.Color(255, 255, 255));
        LBL_kaibox.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        LBL_kaibox.setForeground(new java.awt.Color(255, 255, 255));
        LBL_kaibox.setText("KaiBox");

        LBL_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Practica01_Dropbox/Images/Dropbox_96px.png"))); // NOI18N

        SPT_one.setBackground(new java.awt.Color(255, 51, 51));

        SPT_two.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(LBL_kaibox)
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(SPT_one, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LBL_logo))
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SPT_two, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(LBL_kaibox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_logo)
                .addGap(18, 18, 18)
                .addComponent(SPT_one, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SPT_two, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(36, 47, 65));

        LBL_upload.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LBL_upload.setForeground(new java.awt.Color(255, 255, 255));
        LBL_upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Practica01_Dropbox/Images/Download from the Cloud_15px_b.png"))); // NOI18N
        LBL_upload.setText("Upload");
        LBL_upload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LBL_uploadMouseClicked(evt);
            }
        });

        Table_Upload.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Path", "Size", "State"
            }
        ));
        jScrollPane1.setViewportView(Table_Upload);

        BTN_Upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Practica01_Dropbox/Images/Upload to the Cloud_15px.png"))); // NOI18N
        BTN_Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_UploadActionPerformed(evt);
            }
        });

        LBL_Download.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        LBL_Download.setForeground(new java.awt.Color(255, 255, 255));
        LBL_Download.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Practica01_Dropbox/Images/Download from the Cloud_15px_b.png"))); // NOI18N
        LBL_Download.setText("Download");
        LBL_Download.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LBL_DownloadMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LBL_DownloadMousePressed(evt);
            }
        });

        LBL_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Practica01_Dropbox/Images/Cancel_15px_blanco.png"))); // NOI18N
        LBL_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LBL_exitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_Upload))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(LBL_upload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LBL_exit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SPT_gral))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(LBL_Download)
                        .addGap(0, 177, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_upload)
                    .addComponent(LBL_exit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_Upload)
                .addGap(18, 18, 18)
                .addComponent(SPT_gral, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LBL_Download)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LBL_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_exitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_LBL_exitMouseClicked

    private void BTN_UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_UploadActionPerformed

        try {
            Thread thread = new Thread() {
                public void run() {
                    int port = 5533, porcentage = 0, n = 0;
                    String host = "localhost";
                    try {
                        Socket socket = null;
                        DataOutputStream dataOutputStream = null;
                        DataInputStream dataInputStream = null;
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.requestFocus();
                        jFileChooser.setMultiSelectionEnabled(true);
                        int r = jFileChooser.showOpenDialog(null);
                        if (r == JFileChooser.APPROVE_OPTION) {
                            File files[] = jFileChooser.getSelectedFiles();
                            for (int i = 0; i < files.length; i++) {
                                String name_file = files[i].getName();
                                long size = files[i].length();
                                String path_file = files[i].getAbsolutePath();
                                long sent = 0;
                                socket = new Socket(host, port);
                                System.out.println("Connected with server, uploading file " + path_file);
                                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                                dataInputStream = new DataInputStream(new FileInputStream(path_file));
                                dataOutputStream.writeUTF(name_file);
                                dataOutputStream.flush();
                                dataOutputStream.writeLong(size);
                                dataOutputStream.flush();
                                n = 0;
                                byte[] bytes = new byte[1500];
                                while ((n = dataInputStream.read(bytes)) > 0) {
                                    dataOutputStream.write(bytes, 0, n);
                                    dataOutputStream.flush();
                                    sent += n;
                                    dataOutputStream.flush();
                                    System.out.println("\rProgress: " + ((sent * 100) / size) + "% size: " + size);
                                }
                                System.out.println("File transmited...");
                            }
                            dataOutputStream.close();
                            dataInputStream.close();
                            socket.close();
                        }
                    } catch (Exception e) {
                        System.err.println("Error trying to upload a file... " + e);
                        JOptionPane.showMessageDialog(null, "Ocurrió un error al conectar con el servidor... ", "Error", JOptionPane.ERROR);
                    }
                }
            };
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_BTN_UploadActionPerformed

    private void LBL_uploadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_uploadMouseClicked

    }//GEN-LAST:event_LBL_uploadMouseClicked

    private void LBL_DownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_DownloadMouseClicked
        System.out.println("pkg01_kaibox.Frame_DP.LBL_DownloadMouseClicked()");
    }//GEN-LAST:event_LBL_DownloadMouseClicked

    private void LBL_DownloadMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_DownloadMousePressed
        System.out.println("pkg01_kaibox.Frame_DP.LBL_DownloadMousePressed()");
        try {
            Thread thread = new Thread() {
                public void run() {
                    int port = 5534, porcentaje = 0, n = 0;
                    String host = "localhost";
                    try {
                        Socket socket = null;
                        DataInputStream dataInputStream = null;
                        DataOutputStream dataOutputStream = null;
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.requestFocus();
                        jFileChooser.setMultiSelectionEnabled(true);
                        int r = jFileChooser.showOpenDialog(null);
                        if (r == JFileChooser.APPROVE_OPTION) {
                            File[] files = jFileChooser.getSelectedFiles();
                            for (int i = 0; i < files.length; i++) {
                                String name_file = files[i].getName();
                                long size = files[i].length();
                                System.out.println("I need the file: " + name_file);
                                String path_file = files[i].getAbsolutePath();
                                int sent = 0;
                                socket = new Socket(host, port);
                                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                                //We send the name and path of a file that we need.
                                dataOutputStream.writeUTF(path_file);
                                dataOutputStream.flush();

                                dataOutputStream.writeLong(size);
                                dataOutputStream.flush();
                                //We need to receive the file
                                //dataOtputforFile = new DataOutputStream(new FileOutputStream(str + "\\" + name_file));
                                dataOutputStream = new DataOutputStream(new FileOutputStream(str + "\\" + name_file));
                                dataInputStream = new DataInputStream(socket.getInputStream());
                                n = 0;
                                long received = 0;
                                byte[] bytes = new byte[1500];
                                while ((n = dataInputStream.read(bytes)) > 0) {
                                    dataOutputStream.write(bytes, 0, n);
                                    received += n;
                                    dataOutputStream.flush();
                                    System.out.println("\r" + (received * 100) / (size) + "% of " + size + "bytes");
                                }
                                dataInputStream.close();
                                dataOutputStream.close();
                            }
                            socket.close();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            };
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_LBL_DownloadMousePressed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame_DP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame_DP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame_DP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_DP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame_DP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Upload;
    private javax.swing.JLabel LBL_Download;
    private javax.swing.JLabel LBL_exit;
    private javax.swing.JLabel LBL_kaibox;
    private javax.swing.JLabel LBL_logo;
    private javax.swing.JLabel LBL_upload;
    private javax.swing.JSeparator SPT_gral;
    private javax.swing.JSeparator SPT_one;
    private javax.swing.JSeparator SPT_two;
    private javax.swing.JTable Table_Upload;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
