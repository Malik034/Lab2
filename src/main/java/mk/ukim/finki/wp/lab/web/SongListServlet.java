/*
package mk.ukim.finki.wp.lab.web;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "songListServlet", urlPatterns = {"/listSongs", ""})
public class SongListServlet extends HttpServlet {

    private final SongService songService;
    private final SpringTemplateEngine templateEngine;

    public SongListServlet(SongService songService, SpringTemplateEngine templateEngine) {
        this.songService = songService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req,resp);

        List<Song> songList = songService.listSongs();

        WebContext context = new WebContext(webExchange);
        context.setVariable("songList", songList);
        templateEngine.process("listSongs.html", context, resp.getWriter());
    }
}

 */