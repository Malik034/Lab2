package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    public Song findByTrackId(String trackId);
    public List<Song> findTrackByArtistId(int artistId); //DOPOLNITELNO
    public Song findById(Long id);
    public Song saveSong(Song song);
    public void deleteSong(Song song);

}
