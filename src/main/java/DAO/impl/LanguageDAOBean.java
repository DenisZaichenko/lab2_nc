package DAO.impl;

import DAO.LanguageDAO;
import model.Language;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Local(LanguageDAO.class)
@Stateless
public class LanguageDAOBean implements LanguageDAO {
    public List<Language> getAllLanguages() {
        Session session=HibernateUtil.getSession();
        List<Language> list=session.createCriteria(Language.class).list();
        session.close();
        return list;
    }
}
