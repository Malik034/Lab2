/*
package mk.ukim.finki.wp.lab.web;

import mk.ukim.finki.wp.lab.service.ArtistService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mk.ukim.finki.wp.lab.model.Artist;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArtistServlet", urlPatterns = {"/artist"})
public class ArtistServlet extends HttpServlet {

    private final ArtistService artistService;
    private final SpringTemplateEngine templateEngine;

    public ArtistServlet(ArtistService artistService, SpringTemplateEngine templateEngine) {
        this.artistService = artistService;
        this.templateEngine = templateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        List<Artist> artistsList = artistService.listArtists();

        String trackId = req.getParameter("trackId");
        WebContext context = new WebContext(webExchange);
        context.setVariable("artistsList", artistsList);
        context.setVariable("trackId", trackId);
        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        resp.sendRedirect(req.getContextPath() + "/artist?trackId=" + trackId);
    }
}

*/