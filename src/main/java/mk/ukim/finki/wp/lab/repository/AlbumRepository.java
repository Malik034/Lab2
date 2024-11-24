package mk.ukim.finki.wp.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Album;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class AlbumRepository {

    public static List<Album> albums = new ArrayList<>();

    @PostConstruct
    public void init() {
        albums.add(new Album( "Rap Album", "Rap", "2005"));
        albums.add(new Album( "Pop Album", "Pop", "2011"));
        albums.add(new Album( "Rock Album", "Rock", "1960"));
        albums.add(new Album("Classic Album", "Classic", "2003"));
        albums.add(new Album("Pop Album", "Pop", "1997"));
    }

    public List<Album> findAll(){
        return albums;
    }

    public Album findById(Long id){
        for(Album album: albums){
            if(Objects.equals(album.getId(), id)){
                return album;
            }
        }
        return null;
    }

}
