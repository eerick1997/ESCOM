package turing.machine.UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFileChooser;
import sun.awt.windows.ThemeReader;

/**
 * @author erick
 */
public class Simulator extends javax.swing.JFrame {

    /**
     * *********** GLOBAL VARIABLES ************
     */
    /**
     * ******** TURING MACHINE VARIABLES *******
     */
    private static final String q[] = {"qi", "q1", "q2", "q3", "q4"};
    private static final Character t_symbol = 'X';
    private static final Character symbol = '1';
    private static final String qi = q[0];
    private static final String qf = q[4];
    private static final char B = ' ';
    private String qc = qi;

    private ArrayList<Character> tape;

    /**
     * *********** OTHER VARIABLES ************
     */
    private int animation = 0;
    private static final char L = 'L';
    private static final char R = 'R';
    private static final char N = 'N';
    private char move_to = N;

    /**
     * ********** END GLOBAL VARIBLES **********
     */
    /**
     * Creates new form Simulator
     */
    public Simulator() {
        initComponents();
        this.setResizable(false);
    }

    private void enableButons(boolean enable){
        BTNToLeft.setEnabled(enable);
        BTNToRight.setEnabled(enable);
        BTNStart.setEnabled(enable);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("animation to " + move_to + " contains " + animation);
        Font font = new Font("Dialog", Font.PLAIN, 30);
        g.setFont(font);
        int Xi = 20;
        int Xf = this.getWidth() - 45;

        int Yi = 250;
        int Yf = 50;

        int middle = (Xf + Xi) / 2;
        /**
         * ****** BEGIN DRAWING TAPE *******
         */

        try {
            //Drawing container
            g.drawRect(Xi, Yi, Xf, Yf);

            //Drawing cells and text
            for (int i = -(Xf - 1) * 2, k = 0; i < Xf * 2; i += 3) {

                /**
                 * Making each cell*
                 */
                //Xi contains the size of each cell
                g.drawRect(Xi * i + animation, Yi, 0, Yf);
                g.setFont(font);

                if (i >= (Xi - 5) && k < tape.size() - 1) {
                    //Setting text in each cell
                    g.drawString(tape.get(k++) + "", Xi * i + 20 + animation, (Yi + Yf - 15));
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        /**
         * ******* END DRAWING TAPE ********
         */
        /**
         * ****** BEGIN DRAWING HEAD *******
         */
        int x_coordinates[] = {middle - 30, middle - 30, middle, middle + 30, middle + 30, middle - 30};
        int y_coordinates[] = {Yi - 100, Yi - 50, +Yi - 5, Yi - 50, Yi - 100, Yi - 100};
        Polygon head = new Polygon(x_coordinates, y_coordinates, x_coordinates.length);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.DARK_GRAY);
        g2D.fillPolygon(head);
        g2D.drawPolygon(head);
        g2D.setColor(Color.WHITE);
        g2D.drawString(qc, middle - 18, Yi - 60);

        g2D.setColor(Color.RED);
        g2D.setStroke(new BasicStroke(5.0f));
        g2D.drawRect(middle - 25, Yi, 60, Yf);
        /**
         * ******* END DRAWING HEAD ********
         */
    }

    private void move() {
        try {
            for (int i = 0; i < 60; i++) {
                animate();
                Thread.sleep(10);
            }
            Thread.sleep(300);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private void animate() {
        if (move_to == 'L') {
            animation++;
        } else if (move_to == 'R') {
            animation--;
        }
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXTInputString = new javax.swing.JTextField();
        BTNStart = new javax.swing.JButton();
        BTNToRight = new javax.swing.JButton();
        BTNToLeft = new javax.swing.JButton();
        BTNChooseFIle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1000, 1000));
        setMinimumSize(new java.awt.Dimension(750, 452));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Turing machine simulator");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(0.5F);

        jLabel2.setText("Input string:");

        BTNStart.setText("Start");
        BTNStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNStartActionPerformed(evt);
            }
        });

        BTNToRight.setText("Move to right");
        BTNToRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNToRightActionPerformed(evt);
            }
        });

        BTNToLeft.setText("Move to left");
        BTNToLeft.setMaximumSize(new java.awt.Dimension(122, 31));
        BTNToLeft.setMinimumSize(new java.awt.Dimension(122, 31));
        BTNToLeft.setPreferredSize(new java.awt.Dimension(122, 31));
        BTNToLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNToLeftActionPerformed(evt);
            }
        });

        BTNChooseFIle.setText("Choose a file");
        BTNChooseFIle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNChooseFIleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXTInputString, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTNStart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BTNChooseFIle)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BTNToLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(BTNToRight)
                .addGap(275, 275, 275))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTInputString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNStart)
                    .addComponent(BTNChooseFIle))
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTNToLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNToRight))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNStartActionPerformed
        animation = 60;
        try {
            //Getting the input string
            tape = new ArrayList<Character>();
            tape.add(B);
            for (char c : TXTInputString.getText().trim().toCharArray()) {
                tape.add(c);
            }
            tape.add(B);
            if (!tape.toString().isEmpty()) {
                transitionFunction();
            }
            enableButons(false);
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_BTNStartActionPerformed

    private void BTNToLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNToLeftActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 60; i++) {
                        move_to = R;
                        animate();
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }//GEN-LAST:event_BTNToLeftActionPerformed

    private void BTNToRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNToRightActionPerformed
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 60; i++) {
                        move_to = L;
                        animate();
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }).start();
    }//GEN-LAST:event_BTNToRightActionPerformed

    private void BTNChooseFIleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNChooseFIleActionPerformed

        String str = "";
        ArrayList<String> lines = new ArrayList<>();
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showOpenDialog(this);
            File file = jFileChooser.getSelectedFile();
            if (file != null) {
                FileReader files = new FileReader(file);
                BufferedReader read = new BufferedReader(files);
                while ((str = read.readLine()) != null) {
                    lines.add(str);
                }
                read.close();
            }

            int rand = (int) (Math.random() * (lines.size() - 1));
            animation = 60  ;
            tape = new ArrayList<>();
            tape.add(B);
            String selected = lines.get(rand).trim();
            TXTInputString.setText(selected);
            for (char c : selected.toCharArray()) {
                tape.add(c);
            }
            tape.add(B);
            if (!tape.toString().isEmpty()) {
                transitionFunction();
            }
            enableButons(false);
        } catch (Exception e) {
            System.err.println(e);
        }


    }//GEN-LAST:event_BTNChooseFIleActionPerformed

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
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulator().setVisible(true);
            }
        });
    }

    /**
     * ***********************************************************
     * * * * * * * * * BEGIN TURING MACHINE CODE * * * * * * * * *
     * ***********************************************************
     */
    private void transitionFunction() throws Exception {
        System.out.println("turing.machine.UI.Simulator.transitionFunction()");
        writeHistory("---------- " + TXTInputString.getText() + " ---------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                //This make a undifined cicle
                boolean flag = true;
                //This variable store the position of the current symbol
                int i = 0;
                //This variable contains the actual state
                qc = qi;
                //This variable contains the current symbol
                Character c_symbol = B;

                while (flag) {
                    System.out.println(flag);
                    c_symbol = tape.get(i);
                    move_to = N;
                    if (qc == q[0]) {

                        //If current symbol it's a '1'
                        if (c_symbol == symbol) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q1, R, 1)");
                            qc = q[1];
                            tape.set(i++, symbol);
                            move_to = R;
                        } else if (c_symbol == B) {
                            System.out.println("INITIAL");
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q0, R, B)");
                            qc = q[0];
                            tape.set(i++, B);
                            move_to = R;
                        }

                    } else if (qc == q[1]) {

                        //If current symbol it's a '1'
                        if (c_symbol == symbol) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q1, R, 1)");
                            qc = q[1];
                            tape.set(i++, symbol);
                            move_to = R;
                        } //If current symbol it's a ' '
                        else if (c_symbol == B) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q2, L, B)");
                            qc = q[2];
                            tape.set(i--, B);
                            move_to = L;
                        }
                    } else if (qc == q[2]) {

                        //If current symbol it's a '1'
                        if (c_symbol == symbol) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q3, R, X)");
                            qc = q[3];
                            tape.set(i++, t_symbol);
                            move_to = R;
                        } //If current symbol it's a 'X'
                        else if (c_symbol == t_symbol) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q2, L, X)");
                            qc = q[2];
                            tape.set(i--, t_symbol);
                            tape.add(B);
                            move_to = L;
                        } else if (c_symbol == B) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q4, R, B)");
                            qc = q[4];
                            tape.set(i++, B);
                            move_to = R;
                        }
                    } else if (qc == q[3]) {

                        //If current symbol it's a 'X'
                        if (c_symbol == t_symbol) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q3, R, X)");
                            qc = q[3];
                            tape.set(i++, t_symbol);
                            move_to = R;
                        } //If current symbol it's a ' '
                        else if (c_symbol == B) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q2, L, X)");
                            qc = q[2];
                            //tape.add(B);
                            tape.set(i--, t_symbol);
                            //tape.add(B);
                            move_to = L;
                        }
                    } else if (qc == q[4]) {

                        //If current symbol it's a 'X'
                        if (c_symbol == t_symbol) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (q4, R, 1)");
                            qc = q[4];
                            tape.set(i++, symbol);
                            move_to = R;
                        } //If current symbol it's a ' '
                        else if (c_symbol == B) {
                            writeHistory("(" + qc + ", " + c_symbol + ") -> (qf, R, B)");
                            System.out.println("FINAL");
                            flag = false;
                            qc = "qf";
                            move_to = R;
                            move();
                            enableButons(true);
                            break;
                        }
                    }
                    move();

                }
            }

        }).start();
        ;

        System.out.println("turing.machine.UI.Simulator.transitionFunction()");

    }

    /**
     * ***********************************************************
     * * * * * * * * * END TURING MACHINE CODE * * * * * * * * * *
     * ***********************************************************
     */
    private void writeHistory(String state) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("History.txt", true));
            writer.append("\n");
            writer.append(state);
            writer.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNChooseFIle;
    private javax.swing.JButton BTNStart;
    private javax.swing.JButton BTNToLeft;
    private javax.swing.JButton BTNToRight;
    private javax.swing.JTextField TXTInputString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
