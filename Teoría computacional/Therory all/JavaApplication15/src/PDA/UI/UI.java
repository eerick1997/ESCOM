package PDA.UI;

import PDA.Objects.Stack;
import PDA.forFiles.MyFiles;

public class UI extends javax.swing.JFrame implements Runnable {

    private Stack stack;
    private String writeFile = "";
    private MyFiles file;
    private char[] cList;
    private char aChar = ' ';
    private String anString = "";

    private Thread thread;

    public UI(String str, MyFiles file) {
        initComponents();
        TXTInput.setEditable(false);
        TXTStack.setEditable(false);
        TXTSymbol.setEditable(false);
        this.anString = str;
        TXTInput.setText(str);
        cList = str.toCharArray();
        replaceTextInput();
        thread = new Thread(this);
        this.file = file;
        this.stack = new Stack(file);
        thread.start();
    }

    public UI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TXTSymbol = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TXTInput = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TXTStack = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TXTSymbol.setBackground(new java.awt.Color(0, 204, 204));
        TXTSymbol.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TXTSymbol.setForeground(new java.awt.Color(0, 0, 0));
        TXTSymbol.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TXTSymbol, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(TXTSymbol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        TXTInput.setColumns(20);
        TXTInput.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TXTInput.setForeground(new java.awt.Color(0, 0, 0));
        TXTInput.setRows(5);
        jScrollPane1.setViewportView(TXTInput);

        TXTStack.setColumns(20);
        TXTStack.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TXTStack.setForeground(new java.awt.Color(0, 0, 0));
        TXTStack.setRows(5);
        jScrollPane2.setViewportView(TXTStack);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PDA/UI/Images/flec1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PDA/UI/Images/flec2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 278, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    @Override
    public void run() {
        String strAux = "";
        char[] auxChar = cList;
        String aux = "Z\n";
        String aux2 = "Z";
        String expression = "";
        expression = toWrite(TXTSymbol.getText(), anString, aux2, expression);
        try{
            replaceTextInput();
            setTextStack(aux);
            
            for(int i = 0; i < anString.length(); i++){
                TXTInput.setText("");
                TXTStack.setText("");
                TXTSymbol.setText("");
                
                strAux = anString.substring(i+1);
                if(auxChar[i] == '0'){
                    stack.push('X');
                    aux2 = "X" + aux2;
                    aux = "X\n" + aux;
                    TXTStack.setText(aux);
                    TXTInput.setText(strAux);
                    TXTSymbol.setText( "q" );
                    expression = toWrite("q", strAux, aux2, expression);
                }
                if(auxChar[i] == '1' && i>= 1){
                    stack.pop();
                    aux2 = wasOneWrite(aux2);
                    aux = wasOne(aux);
                    if(!strAux.isEmpty()){
                        TXTStack.setText(aux);
                        TXTInput.setText(strAux);
                        TXTSymbol.setText( "q" );
                        expression = toWrite("P", strAux, aux2, expression);
                    }
                    else{
                        TXTStack.setText(aux2);
                        TXTInput.setText(strAux);
                        TXTSymbol.setText( "f" );
                        expression = toWrite("f", "e" , aux2 , expression);
                    }
                }
                Thread.sleep(1500);
                file.writeSth(expression);
            }
            
        } catch (Exception e){
            System.err.println(e);
        }
        file.closeFile();
    }
    public void replaceTextInput() {

        String str = "";
        TXTInput.setText("");
        for (int i = 0; i < cList.length; i++)
            str += cList[i];
        aChar = cList[0];
        setSymbol((aChar == '0')?"q":"P");
        TXTInput.setText(str);

    }
   

    public void setTextStack(String string) {
        TXTStack.setText("");
        TXTStack.setText(string);
    }

    public void setSymbol(String symbol) {
        TXTSymbol.setText("");
        TXTSymbol.setText(symbol);
    }

    public String wasOne(String str) {
        String aux = "";
        for (int i = 2; i < str.length(); i++) {
            aux += str.charAt(i);
        }
        return aux;
    }

    public String wasOneWrite(String str) {
        String aux = "";
        for (int i = 1; i < str.length(); i++) {
            aux += str.charAt(i);
        }
        return aux;
    }

    public char[] reduceList() {
        char[] list = {' '};
        list = new char[cList.length - 1];
        for (int i = 1; i < cList.length; i++) {
            list[i - 1] = cList[i];
        }
        replaceTextInput();
        return list;
    }

    public String toWrite(String type, String input, String stack, String before) {
        String concat = "(" + type + "," + input + "," + stack + ")";
        if (before.isEmpty()) {
            before = concat;
        } else {
            before += (char) 182 + concat;
        }
        return before;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TXTInput;
    private javax.swing.JTextArea TXTStack;
    private javax.swing.JTextField TXTSymbol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
