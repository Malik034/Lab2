
/*
package mk.ukim.finki.wp.lab.repository;


import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ArtistRepository {

    public static List<Artist> artists = new ArrayList<>();

    @PostConstruct
    public void init(){
        artists.add(new Artist( "John", "Blake", "Rapper"));
        artists.add(new Artist( "Joe", "Parker", "Pop Singer"));
        artists.add(new Artist( "Cindy", "Smith", "Rock Singer"));
        artists.add(new Artist( "Sarah", "Red", "Classical Singer"));
        artists.add(new Artist( "Rose", "Woods", "Rapper"));
    }

    public List<Artist> findAll(){
        return artists;
    }

    public Optional<Artist> findById(Long id){
        for(Artist artist : artists){
            if(artist.getId().equals(id)){
                return Optional.of(artist);
            }
        }
        return Optional.empty();
    }

    public Song addSongToArtist(Song song, Artist artist) {

        artist.addSongs(song);    //DOPOLNITELNO
        return song;
    }

}

 */