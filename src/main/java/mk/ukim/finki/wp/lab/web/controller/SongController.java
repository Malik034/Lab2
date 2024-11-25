
package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.impl.AlbumServiceImpl;
import mk.ukim.finki.wp.lab.service.impl.SongServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/songs"})
public class SongController {
    private final SongServiceImpl songService;
    private final AlbumServiceImpl albumService;

    public SongController(SongServiceImpl songService, AlbumServiceImpl albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {

        List<Song> songList = songService.listSongs();

        model.addAttribute("songList", songList);
        if(error != null){
            model.addAttribute("error", error);

        }
        return "listSongs";
    }

    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        List<Album> albumList = albumService.findAll();
        model.addAttribute("albumList", albumList);
        return "add-song";
    }

    @PostMapping("/add-form")
    public String saveSong(@RequestParam String title,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId){

        Album album = albumService.findById(albumId);
        Song song = new Song(title, genre, releaseYear, album);

       // song.setId(Long.valueOf(trackId));
        songService.saveSong(song);

        return "redirect:/songs";
    }

    @GetMapping("/edit-form/{songId}")
    public String getEditSongForm(@PathVariable Long songId, Model model) {
        Song song = songService.findById(songId);
        if (song == null) {
            return "redirect:/songs?error=SongNotFound";
        }

        List<Album> albumList = albumService.findAll();
        model.addAttribute("song", song);
        model.addAttribute("albumList", albumList);

        return "editSong";
    }

    @PostMapping("/edit-form/{songId}")
    public String editSong(@PathVariable Long songId,
                           @RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long albumId){

        Song song = songService.findById(songId);
        if(song == null){
            return "redirect:/songs?error=SongNotFound";
        }

       // String trackId = song.getTrackId();

        song.setTitle(title);
        song.setId(Long.valueOf(trackId));
        song.setGenre(genre);
        song.setReleaseYear(releaseYear);

        song.setAlbum(albumService.findById(albumId));
        songService.saveSong(song);

        return "redirect:/songs";
    }

    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){

        Song song = songService.findById(id);
        if(song != null){
            songService.deleteSong(song);
        }

        return "redirect:/songs";
    }

}


