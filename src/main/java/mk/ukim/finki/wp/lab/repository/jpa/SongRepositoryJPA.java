package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SongRepositoryJPA extends JpaRepository<Song, Long> {
    List<Song> findByPerformers_Id(Long performers_Id);
    List<Song> findAllByAlbum_Id(Long albumId);
}