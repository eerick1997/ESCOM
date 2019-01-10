package micronapster.MyObject;

import java.io.Serializable;

public class Song implements Serializable {

    private String title, artist, genere, album, user, name;
    private int songSize;

    public Song(String title, String artist, String genere, String album, String user, int songSize, String name) {
        System.out.println("Song.java " + title + " " + artist + " "
                + genere + " " + album + " " + user);

        try {
            if (title.trim().isEmpty()) 
                title = "Sin titulo";
        } catch (NullPointerException e) {
            System.err.println("Song constructor Exception evaluating title");
            e.printStackTrace();
            title = "Sin titulo";
        }
        try {
            if (artist.trim().isEmpty()) 
                artist = "Artista desconocido";
        } catch (NullPointerException e) {
            System.err.println("Song constructor Exception evaluating title");
            e.printStackTrace();
            artist = "Artista desconocido";
        }
        try {
            if (genere.trim().isEmpty()) 
                genere = "Sin genero";
        } catch (NullPointerException e) {
            System.err.println("Song constructor Exception evaluating title");
            e.printStackTrace();
            genere = "Sin genero";
        }
        try {
            if (album.trim().isEmpty())
                album = "Desconocido";
        } catch (NullPointerException e) {
            System.err.println("Song constructor Exception evaluating title");
            e.printStackTrace();
            album = "Desconocido";
        }
        this.title = title;
        this.artist = artist;
        this.genere = genere;
        this.album = genere;
        this.user = user;
        this.songSize = songSize;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenere() {
        return genere;
    }

    public String getAlbum() {
        return album;
    }

    public String getUser() {
        return user;
    }

    public int getSongSize() {
        return songSize;
    }

    public String getName() {
        return name;
    }

    public void setTitle(String string) {
        this.title = string;
    }

    public void setName(String string) {
        this.title = string;
    }

    public void setArtist(String string) {
        this.artist = string;
    }

    public void setGenere(String string) {
        this.genere = string;
    }

    public void setAlbum(String string) {
        this.album = string;
    }

    public void setUser(String string) {
        this.user = string;
    }

    public void setSongSize(int Int) {
        this.songSize = Int;
    }
}
