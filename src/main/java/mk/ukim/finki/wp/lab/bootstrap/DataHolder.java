package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepositoryJPA;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepositoryJPA;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public List<Song> songs = null;
    public List<Album> albums = null;
    public List<Artist> artists = null;

    public SongRepositoryJPA songRepository;
    public AlbumRepositoryJPA albumRepository;
    public ArtistRepositoryJPA artistRepository;

    public DataHolder(AlbumRepositoryJPA albumRepository, SongRepositoryJPA songRepository,ArtistRepositoryJPA artistRepository) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @PostConstruct
    public void init() {
        albums = new ArrayList<>();
        if(albumRepository.count()==0){
            albums.add(new Album( "Rap Album", "Rap", "2005"));
            albums.add(new Album( "Pop Album", "Pop", "2011"));
            albums.add(new Album( "Rock Album", "Rock", "1960"));
            albums.add(new Album("Classic Album", "Classic", "2003"));
            albums.add(new Album("Pop Album", "Pop", "1997"));

            albumRepository.saveAll(albums);
        }


        songs = new ArrayList<>();
        if(songRepository.count()==0) {
            songs.add(new Song("Street Dreams", "Rap", 2002, albums.get(0)));
            songs.add(new Song("Thunder on the Highway", "Rock", 2001, albums.get(1)));
            songs.add(new Song("All Night Long", "Pop", 1988, albums.get(2)));
            songs.add(new Song("Timeless Memories", "Classic", 1979, albums.get(3)));
            songs.add(new Song("No Limits", "Rap", 2008, albums.get(4)));

            songRepository.saveAll(songs);
        }

        artists = new ArrayList<>();
        if(artistRepository.count()==0) {
            artists.add(new Artist("John", "Blake", "Rapper"));
            artists.add(new Artist("Joe", "Parker", "Pop Singer"));
            artists.add(new Artist("Cindy", "Smith", "Rock Singer"));
            artists.add(new Artist("Sarah", "Red", "Classical Singer"));
            artists.add(new Artist("Rose", "Woods", "Rapper"));

            artistRepository.saveAll(artists);
        }
    }
}