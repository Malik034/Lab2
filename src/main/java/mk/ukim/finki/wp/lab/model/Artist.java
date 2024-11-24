package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Artist {

    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private List<Song> songs;    //DOPOLNITELNO

    public Artist(Long id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.songs = new ArrayList<>();   //DOPOLNITELNO
    }

    public void addSongs(Song song) {

        if(song != null) {
            songs.add(song);                //DOPOLNITELNO
        }
    }
}