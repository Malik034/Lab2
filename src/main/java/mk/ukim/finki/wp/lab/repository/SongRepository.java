package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class SongRepository {
    private final AlbumRepository albumRepository;
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albums;

    @Autowired
    public SongRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    public void init(){

        albums = albumRepository.findAll();

        songs.add(new Song("Street Dreams", "Rap", 2002, albums.get(0)));
        songs.add(new Song("Thunder on the Highway", "Rock", 2001, albums.get(1)));
        songs.add(new Song("All Night Long", "Pop", 1988, albums.get(2)));
        songs.add(new Song("Timeless Memories", "Classic", 1979, albums.get(3)));
        songs.add(new Song("No Limits", "Rap", 2008, albums.get(4)));
    }

    public List<Song> findAll(){
        return songs;
    }

    
    public Artist addArtistToSong(Artist artist, Song song){
        song.addPerformer(artist);
        return artist;
    }

    public List<Song> findTrackByArtistId(int artistId) {     //DOPOLNITELNO
        List<Song> songsByArtist = new ArrayList<>();
        for (Song song : songs) {
            for (Artist artist : song.getPerformers()) {
                if (artist.getId() == artistId) {
                    songsByArtist.add(song);
                    break;
                }
            }
        }
        return songsByArtist;
    }

    public Song findById(Long id){
        for(Song song: songs){
            if(Objects.equals(song.getId(), id)){
                return song;
            }
        }
        return null;
    }

    public Song saveSong(Song song){
        for(int i=0; i<songs.size(); i++){
            if(songs.get(i).getId().equals(song.getId())){
                songs.set(i, song);
                return song;
            }
        }
        songs.add(song);
        return song;
    }

    public void deleteSong(Song song){
        songs.remove(song);
    }

}
