package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

//DOPOLNITELNO

@WebServlet(name="ArtistDetailsServlet", urlPatterns = {"/artistDetails"})
public class ArtistDetailsServlet extends HttpServlet {
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    public ArtistDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine templateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        String trackId = req.getParameter("trackId");

        String artistId = req.getParameter("artistId");
        Artist artist = artistService.findById(Long.parseLong(artistId));

        List<Song> songs = songService.findTrackByArtistId(Integer.parseInt(artistId));

        WebContext context = new WebContext(webExchange);
        context.setVariable("artist", artist);
        context.setVariable("songs", songs);
        templateEngine.process("artistDetails.html", context, resp.getWriter());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String artistId = req.getParameter("artistId");
        String trackId = req.getParameter("trackId");

        artistService.addSongToArtist(songService.findById(Long.valueOf(trackId)),
                artistService.findById(Long.parseLong(artistId)));

        resp.sendRedirect(req.getContextPath() + "/artistDetails?artistId=" + artistId + "&trackId=" + trackId);
    }
}