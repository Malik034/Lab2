package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> findTrackByArtistId(int artistId) {
        return songRepository.findTrackByArtistId(artistId);
    }  //DOPOLNITELNO

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }


    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }


    @Override
    public Song findById(Long id){
        return songRepository.findById(id);
    }

    @Override
    public Song saveSong(Song song){

        return songRepository.saveSong(song);
    }

    @Override
    public void deleteSong(Song song){
        songRepository.deleteSong(song);
    }
}
