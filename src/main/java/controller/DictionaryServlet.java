package controller;

import DAO.LanguageDAO;
import DAO.TranslationDAO;
import model.Language;
import model.Translation;

import javax.annotation.security.RolesAllowed;
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

@RolesAllowed("Privet")
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
        String word=req.getParameter("fWord");
        String fLang=req.getParameter("fLanguage");
        String tLang=req.getParameter("tLanguage");
        if(word!=null && fLang!=null){
            Translation translation=translationDAO.getTranslation(word, Integer.parseInt(fLang), Integer.parseInt(tLang));
            if(word!=null && fLang!=null) {
                req.getSession().setAttribute("tWord", translation.getNameTranslation());
                req.getSession().setAttribute("fWord", word);
                req.getSession().setAttribute("description", translation.getDescriptionTranslation());
            }
        }/**/
        req.getSession().setAttribute("languages",result);
        RequestDispatcher rd=req.getRequestDispatcher("Index.jsp");
        rd.forward(req,resp);
    }
}
