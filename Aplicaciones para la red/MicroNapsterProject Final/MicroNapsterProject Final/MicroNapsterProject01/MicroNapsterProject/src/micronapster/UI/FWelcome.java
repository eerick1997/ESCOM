package micronapster.UI;

import java.awt.Color;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
import micronapster.ClassesClient.*;
import micronapster.MyObject.*;
import org.apache.tika.exception.TikaException;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.*;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FWelcome extends javax.swing.JFrame implements Serializable, Runnable {

    public FileInputStream fis;
    private char d = 92;
    private downloadSong download;

    private preferencesClient preferences = new preferencesClient();

    private String nickName;
    private ArrayList<Song> arraySongs;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private static final String host = "localhost";
    private static final int port = 9900;
    boolean bool, registered;
    private Thread thread;
    private String route;
    private Request request;
    private String titles[] = {"File name", "Title", "Artist", "Genre", "Album", "User", "Size (bytes)"};
    private DefaultTableModel tblmodel = new DefaultTableModel(null, titles);

    public FWelcome() {
        initComponents();
        setLocationRelativeTo(null);
        TBL_Songs.setModel(tblmodel);
        LBL_LogOut.setText("Hola: " + nickName);
    }

    public FWelcome(String nickName) {
        this.nickName = nickName;
        initComponents();
        setLocationRelativeTo(null);
        TBL_Songs.setModel(tblmodel);
        LBL_LogOut.setText("Hola: " + nickName);
    }

    public void connectSocket(Request request) {
        System.out.println("connectSocket starts");
        System.out.println("Request object: " + request);
        this.request = request;
        try {
            System.out.println("Creating socket...");
            socket = new Socket(host, port);
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            thread = new Thread(this);
            thread.start();
        } catch (IOException e) {
            System.err.println("Fwelcome.java, connectSocket method IOException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Fwelcome.java, connectSocket method Exception");
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            tblmodel = new DefaultTableModel(null, titles);
            System.out.println("Fwelcome.java, run method starts!");
            output.writeObject(request);
            arraySongs = (ArrayList<Song>) input.readObject();
            System.out.println("Server says: " + arraySongs);
            if (arraySongs != null && arraySongs.size() > 0) {
                JOptionPane.showMessageDialog(null, "Hay " + arraySongs.size() + " coincidencias");
                for (int i = 0; i < arraySongs.size(); i++) {
                    if (!arraySongs.get(i).getName().equals("")) {
                        tblmodel.addRow(new Object[]{arraySongs.get(i).getName(), arraySongs.get(i).getTitle(),
                            arraySongs.get(i).getArtist(), arraySongs.get(i).getGenere(),
                            arraySongs.get(i).getAlbum(), arraySongs.get(i).getUser(), arraySongs.get(i).getSongSize()});
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay canciones con esos datos.");
            }
            TBL_Songs.setModel(tblmodel);
            System.out.println("Closing socket");
            socket.close();
        } catch (IOException e) {
            System.err.println("Fwelcome.java, run method IOException");
        } catch (Exception e) {
            System.err.println("Fwelcome.java, run method Exception");
            e.printStackTrace();
        }
    }

    public void clearTable() {
        for (int i = 0; i < TBL_Songs.getRowCount(); i++) {
            TBL_Songs.remove(i);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        POP_TBL = new javax.swing.JPopupMenu();
        ITEM_TBL = new javax.swing.JMenuItem();
        Content = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        LBL_Exit = new javax.swing.JLabel();
        LBL_LogOut = new javax.swing.JLabel();
        BTN_Update = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Home = new javax.swing.JPanel();
        Search = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Songs = new javax.swing.JTable();
        LBL_Name = new javax.swing.JLabel();
        TXT_Name = new javax.swing.JTextField();
        SPT_Name = new javax.swing.JSeparator();
        LBL_Artist = new javax.swing.JLabel();
        TXT_Artist = new javax.swing.JTextField();
        SPT_Artist = new javax.swing.JSeparator();
        LBL_Genere = new javax.swing.JLabel();
        TXT_Genere = new javax.swing.JTextField();
        SPT_Genere = new javax.swing.JSeparator();
        LBL_Album = new javax.swing.JLabel();
        TXT_Album = new javax.swing.JTextField();
        SPT_Album = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        ITEM_TBL.setText("Download");
        ITEM_TBL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ITEM_TBLActionPerformed(evt);
            }
        });
        POP_TBL.add(ITEM_TBL);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        Content.setBackground(new java.awt.Color(0, 0, 0));

        Header.setBackground(new java.awt.Color(153, 153, 153));

        LBL_Exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Delete_15px_1.png"))); // NOI18N
        LBL_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LBL_ExitMousePressed(evt);
            }
        });

        LBL_LogOut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBL_LogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LBL_LogOut.setText("Cerrar sesión");
        LBL_LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LBL_LogOutMouseClicked(evt);
            }
        });

        BTN_Update.setBackground(new java.awt.Color(153, 153, 153));
        BTN_Update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BTN_Update.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BTN_Update.setText("Share");
        BTN_Update.setOpaque(true);
        BTN_Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_UpdateMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/napster.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("micro napster");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BTN_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LBL_LogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(LBL_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LBL_Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(LBL_LogOut)
                                .addComponent(BTN_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel4))
                    .addComponent(jLabel3))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        Home.setLayout(new java.awt.CardLayout());

        Search.setBackground(new java.awt.Color(204, 204, 204));

        TBL_Songs.setAutoCreateRowSorter(true);
        TBL_Songs.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        TBL_Songs.setForeground(new java.awt.Color(51, 51, 51));
        TBL_Songs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File name", "Title", "Artist", "Genere", "Album", "User", "Size (bytes)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Songs.setComponentPopupMenu(POP_TBL);
        TBL_Songs.setGridColor(new java.awt.Color(255, 255, 255));
        TBL_Songs.setMinimumSize(new java.awt.Dimension(375, 80));
        TBL_Songs.setOpaque(false);
        TBL_Songs.setRowHeight(20);
        TBL_Songs.setSelectionBackground(new java.awt.Color(128, 128, 128));
        jScrollPane1.setViewportView(TBL_Songs);

        LBL_Name.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBL_Name.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Musical Notes_15px.png"))); // NOI18N
        LBL_Name.setText("Name : ");

        TXT_Name.setBackground(new java.awt.Color(204, 204, 204));
        TXT_Name.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TXT_Name.setBorder(null);
        TXT_Name.setOpaque(false);
        TXT_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_NameActionPerformed(evt);
            }
        });

        LBL_Artist.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBL_Artist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Music Conductor_15px.png"))); // NOI18N
        LBL_Artist.setText("Artist : ");

        TXT_Artist.setBackground(new java.awt.Color(204, 204, 204));
        TXT_Artist.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TXT_Artist.setBorder(null);
        TXT_Artist.setOpaque(false);
        TXT_Artist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_ArtistActionPerformed(evt);
            }
        });

        LBL_Genere.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBL_Genere.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/International Music_15px.png"))); // NOI18N
        LBL_Genere.setText("Genere : ");

        TXT_Genere.setBackground(new java.awt.Color(204, 204, 204));
        TXT_Genere.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TXT_Genere.setBorder(null);
        TXT_Genere.setOpaque(false);
        TXT_Genere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_GenereActionPerformed(evt);
            }
        });

        LBL_Album.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LBL_Album.setIcon(new javax.swing.ImageIcon(getClass().getResource("/micronapster/Images/Music Record_15px.png"))); // NOI18N
        LBL_Album.setText("Album : ");

        TXT_Album.setBackground(new java.awt.Color(204, 204, 204));
        TXT_Album.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        TXT_Album.setBorder(null);
        TXT_Album.setOpaque(false);
        TXT_Album.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_AlbumActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButton1.setText("Search");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jButton2.setText("Clear");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SearchLayout = new javax.swing.GroupLayout(Search);
        Search.setLayout(SearchLayout);
        SearchLayout.setHorizontalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LBL_Name)
                .addGap(18, 18, 18)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SPT_Name)
                            .addComponent(TXT_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LBL_Artist)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SPT_Artist)
                            .addComponent(TXT_Artist, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchLayout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addComponent(LBL_Genere)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SPT_Genere)
                            .addComponent(TXT_Genere, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LBL_Album)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SPT_Album)
                            .addComponent(TXT_Album, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        SearchLayout.setVerticalGroup(
            SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_Name)
                            .addComponent(TXT_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SPT_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_Artist)
                            .addComponent(TXT_Artist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SPT_Artist, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_Genere)
                            .addComponent(TXT_Genere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SPT_Genere, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchLayout.createSequentialGroup()
                        .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LBL_Album)
                            .addComponent(TXT_Album, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SPT_Album, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        Home.add(Search, "card2");

        javax.swing.GroupLayout ContentLayout = new javax.swing.GroupLayout(Content);
        Content.setLayout(ContentLayout);
        ContentLayout.setHorizontalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ContentLayout.setVerticalGroup(
            ContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContentLayout.createSequentialGroup()
                .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LBL_ExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_ExitMousePressed
        new closeSession(nickName);
        System.exit(0);
    }//GEN-LAST:event_LBL_ExitMousePressed

    private void LBL_LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LBL_LogOutMouseClicked

    }//GEN-LAST:event_LBL_LogOutMouseClicked

    private void BTN_UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_UpdateMouseClicked
        setLblColor(BTN_Update);
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                route = chooser.getSelectedFile().toString();
                route = route.replace(d, '/');
                System.out.println("route have " + route);
                new preferencesClient().setPath(nickName, route);
                createFileList();
                System.out.println(route);
            } catch (Exception ex) {
                System.err.println("Fwelcome.java BTN_UpdateMouseClicked Exception");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_BTN_UpdateMouseClicked

    private void TXT_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_NameActionPerformed
        TXT_Name.transferFocus();
    }//GEN-LAST:event_TXT_NameActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TXT_ArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_ArtistActionPerformed
        TXT_Artist.transferFocus();
    }//GEN-LAST:event_TXT_ArtistActionPerformed

    private void TXT_GenereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_GenereActionPerformed
        TXT_Genere.transferFocus();
    }//GEN-LAST:event_TXT_GenereActionPerformed

    private void TXT_AlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_AlbumActionPerformed
        TXT_Album.transferFocus();
    }//GEN-LAST:event_TXT_AlbumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String title = TXT_Name.getText().trim();
        String artist = TXT_Artist.getText().trim();
        String album = TXT_Album.getText().trim();
        String genre = TXT_Genere.getText().trim();

        connectSocket(new Request(title, artist, album, 100, genre, nickName));

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ITEM_TBLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITEM_TBLActionPerformed
        TBL_Songs.getSelectedRow();
        Song newSong = new Song(
                (String) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 1),//Title
                (String) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 2),//Artist
                (String) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 3),//Genre
                (String) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 4),//Album
                (String) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 5),//User
                (int) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 6), //SongSize
                (String) tblmodel.getValueAt(TBL_Songs.getSelectedRow(), 0));//NameFile
        download = new downloadSong(newSong);
    }//GEN-LAST:event_ITEM_TBLActionPerformed

    public void setLblColor(JLabel lbl) {
        lbl.setBackground(new Color(102, 102, 102));
    }

    public void resetLblColor(JLabel lbl) {
        lbl.setBackground(new Color(153, 153, 153));
    }

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        // Change  UI look of table
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FWelcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BTN_Update;
    private javax.swing.JPanel Content;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Home;
    private javax.swing.JMenuItem ITEM_TBL;
    private javax.swing.JLabel LBL_Album;
    private javax.swing.JLabel LBL_Artist;
    private javax.swing.JLabel LBL_Exit;
    private javax.swing.JLabel LBL_Genere;
    private javax.swing.JLabel LBL_LogOut;
    private javax.swing.JLabel LBL_Name;
    private javax.swing.JPopupMenu POP_TBL;
    private javax.swing.JSeparator SPT_Album;
    private javax.swing.JSeparator SPT_Artist;
    private javax.swing.JSeparator SPT_Genere;
    private javax.swing.JSeparator SPT_Name;
    private javax.swing.JPanel Search;
    private javax.swing.JTable TBL_Songs;
    private javax.swing.JTextField TXT_Album;
    private javax.swing.JTextField TXT_Artist;
    private javax.swing.JTextField TXT_Genere;
    private javax.swing.JTextField TXT_Name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public void createFileList() {
        ArrayList<Song> arraySongs = new ArrayList<Song>();

        String path = preferences.getPath(nickName);

        File directory = new File(path);
        File[] filesInsideDirectory = directory.listFiles();
        for (File file : filesInsideDirectory) {
            if (file.getName().endsWith(".mp3") || file.getName().endsWith(".MP3")) {
                System.out.println("filesInsideDirectory: " + file.getName() + " Size " + file.length());

                arraySongs.add(getMetaData(file.getName(), path, (int) file.length()));
            }
        }
        new sendSongsData(arraySongs);
    }

    public Song getMetaData(String nameFile, String path, int Size) {
        String title = "Sin titulo", artists = "Artista desconocido", genere = "Sin genero", album = "Desconocido";
        Song songMetadata = null;
        try {
            InputStream inputStream = new FileInputStream(new File(path + "/" + nameFile));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseContext = new ParseContext();
            parser.parse(inputStream, handler, metadata, parseContext);
            inputStream.close();

            title = metadata.get("title");
            artists = metadata.get("xmpDM:artist");
            genere = metadata.get("xmpDM:genre");
            album = metadata.get("xmpDM:album");

            System.out.println("titleSong is: " + title);
            System.out.println("artists of this song are: " + artists);
            System.out.println("genere of this song is: " + genere);
            System.out.println("Album of this song is: " + album);

            songMetadata = new Song(title, artists, genere, album, nickName, Size, nameFile);

            System.out.println("User: " + nickName);
        } catch (FileNotFoundException e) {
            System.out.println("getMetaData method FileNotFoundException: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("getMetaData method IOException: ");
            e.printStackTrace();
        } catch (SAXException e) {
            System.out.println("getMetaData method SAXException: ");
            e.printStackTrace();
        } catch (TikaException e) {
            System.out.println("getMetaData method TikaException: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("getMetaData method Exception ");
            e.printStackTrace();
        }
        return songMetadata;
    }

    public void limpiar() {
        TXT_Album.setText("");
        TXT_Artist.setText("");
        TXT_Genere.setText("");
        TXT_Name.setText("");
    }
}
