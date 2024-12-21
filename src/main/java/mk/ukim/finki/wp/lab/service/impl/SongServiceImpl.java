package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepositoryJPA;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepositoryJPA songRepository;
    private final AlbumRepositoryJPA albumRepository;

    public SongServiceImpl(SongRepositoryJPA songRepository, AlbumRepositoryJPA albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> findTrackByArtistId(int artistId) {
        return songRepository.findByPerformers_Id((long) artistId);
    }  //DOPOLNITELNO

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {

        song.addPerformer(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findById(Long id){
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public Song saveSong(Song song){
        return songRepository.save(song);
    }

    @Override
    public void deleteSong(Song song){
        songRepository.delete(song);
    }

    @Override
    public List<Song> findAllByAlbum_Id(Long albumId){
        return songRepository.findAllByAlbum_Id(albumId);
    }

}