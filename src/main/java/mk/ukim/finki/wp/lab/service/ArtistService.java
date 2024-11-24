package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface ArtistService {
    List<Artist> listArtists();
    Song addSongToArtist(Song song, Artist artist);  //DOPOLNITELNO
    Artist findById(Long id);

}
