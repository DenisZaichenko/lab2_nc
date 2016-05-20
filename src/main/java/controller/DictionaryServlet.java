package controller;

import DAO.LanguageDAO;
import DAO.TranslationDAO;
import model.Language;
import model.Translation;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Stateless
@WebServlet(name = "DictionaryServlet", urlPatterns = "/Test")
public class DictionaryServlet extends HttpServlet   implements Servlet{
    @EJB
    private TranslationDAO translationDAO;
    @EJB
    private LanguageDAO languageDAO;
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Language> result=languageDAO.getAllLanguages();
        String word=req.getParameter("word");
        String lang=req.getParameter("language");
        if(word!=null && lang!=null){
            Translation translation=translationDAO.getTranslation(word, Integer.parseInt(lang));
            req.getSession().setAttribute("word",translation.getWord().getName());
            req.getSession().setAttribute("description",translation.getDescriptionTranslation());
        }/**/
        req.getSession().setAttribute("languages",result);
        RequestDispatcher rd=req.getRequestDispatcher("Index.jsp");
        rd.forward(req,resp);
    }
}
