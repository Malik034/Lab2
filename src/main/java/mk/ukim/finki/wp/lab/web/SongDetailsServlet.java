
package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "songDetailsServlet", urlPatterns = {"/songDetails"})
public class SongDetailsServlet extends HttpServlet {

    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    public SongDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine templateEngine) {
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
        Song song = songService.findById(Long.valueOf(trackId));

        WebContext context = new WebContext(webExchange);
        context.setVariable("song", song);
        templateEngine.process("songDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String trackId = req.getParameter("trackId");
        String artistId = req.getParameter("artistId");

        songService.addArtistToSong(artistService.findById(Long.parseLong(artistId)),
                songService.findById(Long.valueOf(trackId)));

        resp.sendRedirect(req.getContextPath() + "/songDetails?trackId=" + trackId);
    }
}


