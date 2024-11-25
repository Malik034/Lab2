package mk.ukim.finki.wp.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Song {

    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Album album;

    public Song(String title, String genre, int releaseYear, Album album) {
         //this.trackId = trackId;
        this.id = (long)(Math.random() * 1000);
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.album = album;
        this.performers = new ArrayList<>();
    }

    public void addPerformer(Artist performer) {
        if (performer != null) {
            performers.add(performer);
        }
    }
}

