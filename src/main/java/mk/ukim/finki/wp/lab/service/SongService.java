package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;


public interface SongService {
    List<Song> listSongs();
    List<Song> findTrackByArtistId(int artistId);
    Artist addArtistToSong(Artist artist, Song song);
    Song findById(Long id);
    Song saveSong(Song song);
    void deleteSong(Song song);
    public List<Song> findAllByAlbum_Id(Long albumId);
}
