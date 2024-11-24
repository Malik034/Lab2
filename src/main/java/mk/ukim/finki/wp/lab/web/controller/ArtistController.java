package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public String showArtists(@RequestParam(value = "trackId") String trackId, Model model) {

        List<Artist> artistsList = artistService.listArtists();

        model.addAttribute("artistsList", artistsList);
        model.addAttribute("trackId", trackId);

        return "artistsList";
    }

    @PostMapping
    public String handlePost(@RequestParam("trackId") String trackId) {
        return "redirect:/artist?trackId=" + trackId;
    }
}