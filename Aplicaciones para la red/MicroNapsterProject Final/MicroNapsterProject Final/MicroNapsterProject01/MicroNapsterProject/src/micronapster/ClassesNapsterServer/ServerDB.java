package micronapster.ClassesNapsterServer;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import micronapster.MyObject.Request;
import micronapster.MyObject.Song;
import micronapster.MyObject.User;

public class ServerDB implements Serializable {

    private Connection connection;
    private String driver = "com.mysql.jdbc.Driver",
            URL = "jdbc:mysql://localhost:3306/",
            password = "",
            username = "root",
            database = "dbservernapster";

    private static final String KEY_NME = "name", KEY_ATS = "artist",
            KEY_GNE = "genere", KEY_ABM = "album", KEY_USR = "user",
            KEY_PTH = "path", KEY_SZE = "size", KEY_TLE = "title";

    public void connect() {
        System.out.println("Trying to create a connection...");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(URL + database, username, password);
            System.out.println("DataBase connected successfully");
        } catch (Exception e) {
            System.err.println("ServerDB.java, connect method, Exception");
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        System.out.println("ServerDB.java, addUser method starts!!!");
        connect();
        Statement statement = null;
        try {
            System.out.println(user.getUser());
            statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO tblusers (name, password, ipaddress, nick) VALUES "
                    + "('" + user.getName() + "', '" + user.getPassword() + "','" + user.getIpAddress()
                    + "','" + user.getUser() + "')");
            System.out.println("New user registered successfully: " + user);
        } catch (SQLException e) {
            System.err.println("An error has occurred type: SQLException, in addUser method");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error has occurred type: Exception, in addUser method");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println("An error has occurred type: Exception, in addUser method");
                e.printStackTrace();
            }
        }
    }

    public void addSong(ArrayList<Song> arraySongs) {
        System.out.println("ServerDB.java, addSong method starts!!!");
        connect();
        Statement statement = null;
        try {
            System.out.println(arraySongs);
            statement = connection.createStatement();
            for (int i = 0; i < arraySongs.size(); i++) {
                if (!songAlreadyExist(arraySongs.get(i))) {
                    
                    statement.executeUpdate("INSERT INTO tblsongsnapster (name, artist, genere, album, user, size, title) VALUES "
                            + "('" + replaceApostrophe(arraySongs.get(i).getName()) + "', '" + replaceApostrophe(arraySongs.get(i).getArtist()) + "',"
                            + "'" + replaceApostrophe(arraySongs.get(i).getGenere()) + "','" + replaceApostrophe(arraySongs.get(i).getAlbum()) + "', "
                            + "'" + replaceApostrophe(arraySongs.get(i).getUser()) + "', '"+ arraySongs.get(i).getSongSize() + "', "
                            + " '" + replaceApostrophe(arraySongs.get(i).getTitle()) + "')");
                    System.out.println("#" + i + " New song registered successfully: " + arraySongs.get(i));
                }
            }
        } catch (SQLException e) {
            System.err.println("An error has occurred type: SQLException, in addSong method");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error has occurred type: Exception, in addSong method");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println("An error has occurred type: Exception, in addSong method");
                e.printStackTrace();
            }
        }
    }

    public Boolean verifyUser(User user) {
        connect();
        Statement statement = null;
        ResultSet resultSet = null;
        Boolean state = false;
        try {
            System.out.println("Creating a statement");
            statement = connection.createStatement();
            System.out.println("nick: " + user.getUser());
            resultSet = statement.executeQuery("SELECT nick, password FROM tblusers WHERE nick = '" + user.getUser() + "'"
                    + "AND password = '" + user.getPassword() + "'");

            System.out.println("User virified: " + user);
            state = resultSet.first();
            System.out.println("resultSet.first()" + state);
        } catch (SQLException e) {
            System.err.println("An error has occurred type: SQLException, in verifyUser method ");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error has occurred type: Exception, in verifyUser method");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println("An error has occurred type: Exception, in verifyUser method");
                e.printStackTrace();
            }
        }
        return state;
    }

    public String getIPAddress(String nickName) {
        System.out.println("ServerDB.java starts!!! nickName " + nickName);
        String ipAddress = null;
        Statement statement = null;
        connect();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tblusers WHERE nick = '" + nickName + "' ");
            while (resultSet.next()) {
                ipAddress = resultSet.getString(4);
            }
        } catch (SQLException e) {
            System.err.println("ServerDB.java, getIPAddress method, SQLException");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ServerDB.java, getIPAddress method, Exception");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println("An error has occurred type: Exception in getIPAddress method");
                e.printStackTrace();
            }
        }
        return ipAddress;
    }

    public ArrayList<Song> getSongs(Request request) {
        ArrayList<Song> songs = new ArrayList<Song>();
        Statement statement = null;
        connect();
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM tblsongsnapster WHERE name LIKE "
                    + "'%" + request.getTitle() + "%' AND artist LIKE '%" + request.getArtist() + "%' AND album LIKE "
                    + "'%" + request.getAlbum() + "%' AND genere LIKE '%" + request.getGenere() + "%'");
            int i = 0;
            while (resultSet.next() || request.getMaxSize() < i) {
                i++;
                songs.add(new Song(resultSet.getString(KEY_TLE), resultSet.getString(KEY_ATS),
                        resultSet.getString(KEY_GNE), resultSet.getString(KEY_ABM),
                        resultSet.getString(KEY_USR), resultSet.getInt(KEY_SZE), resultSet.getString(KEY_NME)));
            }
            System.out.println("I'll return datas");
        } catch (SQLException e) {
            System.err.println("An error has occurred type: SQLException in getSongs method");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("An error has occurred type: Exception in getSongs method");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                connection.close();
            } catch (Exception e) {
                System.err.println("An error has occurred type: Exception in getSongs method");
                e.printStackTrace();
            }
        }
        return songs;
    }

    
    public void sessionClose(String user){
        System.out.println("ServerDB.java, sessionClose method Starts!!!");
        Statement statement = null;
        connect();
        try {
            statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM tblsongsnapster WHERE user = '"+user+"'");
            System.out.println("User " + user+ " 'd closed session");
        } catch (SQLException e) {
            System.err.println("ServerDB.java sessionClose method SQLException e");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("ServerDB.java sessionClose method Exception ");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (Exception e) {
                System.err.println("ServerDB.java, sessionClose method Exception finally clause");
                e.printStackTrace();
            }
        }
    }
    
    public void UpdateIPAddress(User user, String newIP){
        System.out.println("UpdateIPAddress.java, sessionClose method Starts!!!");
        System.out.println("micronapster.ClassesNapsterServer.ServerDB.UpdateIPAddress() User: " + user.getUser() + " New IP " + newIP);
        //Statement statement = null;
        connect();
        try {
            //statement = connection.createStatement();
            PreparedStatement preparedStatement = 
                    connection.prepareStatement("UPDATE tblusers SET ipaddress = ? WHERE nick = ?");
            
            preparedStatement.setString(1, newIP);
            preparedStatement.setString(2, user.getUser());
            
            preparedStatement.execute();
            preparedStatement.close();
            
            System.out.println("IP direction changed " + user.getUser() + " 'd closed session");
        } catch (SQLException e) {
            System.err.println("ServerDB.java UpdateIPAddress method SQLException e");
            e.printStackTrace();
        } catch (Exception e){
            System.err.println("ServerDB.java UpdateIPAddress method Exception ");
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                //statement.close();
            } catch (Exception e) {
                System.err.println("ServerDB.java, UpdateIPAddress method Exception finally clause");
                e.printStackTrace();
            }
        }
    }

    public boolean songAlreadyExist(Song song) {
        System.out.println("ServerDB.java, songAlreadyExist method Starts!!!");
        boolean state = false;
        PreparedStatement preparedStatement = null;
        //connect();
        try {
            
            System.out.println("micronapster.ClassesNapsterServer.ServerDB.songAlreadyExist() Song have " + song.getName() + " "
                + song.getArtist() + " " + song.getGenere() + " " + song.getUser() + " " + song.getSongSize() + " " + song.getTitle());
            
            preparedStatement = connection.prepareStatement("SELECT name, artist, genere, album, user, size, title "
                    + "FROM tblsongsnapster WHERE name = ?"
                    + "AND artist = ? AND genere = ? AND album = ? AND user = ? AND size = ? AND title = ?");
            preparedStatement.setString(1, song.getName());
            preparedStatement.setString(2, song.getArtist());
            preparedStatement.setString(3, song.getGenere());
            preparedStatement.setString(4, song.getAlbum());
            preparedStatement.setString(5, song.getUser());
            preparedStatement.setInt(6, song.getSongSize());
            preparedStatement.setString(7, song.getTitle());
            ResultSet resultSet = preparedStatement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            System.out.println("Count have = " + count);
            if (count > 0) {
                state = true;
            }
            if (count == 0) {
                state = false;
            }

            System.out.println("Song: " + song.getTitle() + " Already exists? " + state);

        } catch (SQLException e) {
            System.err.println("ServerDB.java, deleteSong method SQLException ");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("ServerDB.java, deleteSong method Exception ");
            e.printStackTrace();
        } finally {
            try {
                //connection.close();
            } catch (Exception e) {
                System.err.println("ServerDB.java, deleteSong method Exception finally clause");
                e.printStackTrace();
            }
        }
        return state;
    }

    public String replaceApostrophe(String string) {
        String newString = "";
        System.out.println("String string contains " + string);
        try {
            if (!string.trim().isEmpty() && !string.equals("null")) {
                newString = "";
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == (char) 39) {
                        newString = newString + string.charAt(i) + (char) 39 + "";
                    } else {
                        newString = newString + string.charAt(i) + "";
                    }
                    System.err.println("newString have: " + newString);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            newString = "";
        }
        return newString;
    }
    
    
}
