package DAO.impl;

import DAO.TranslationDAO;
import model.Translation;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local(TranslationDAO.class)
@Stateless
public class TranslationDAOBean implements TranslationDAO {
    public Translation getTranslation(String word, long langId, long goalLangId) {
        Session session = HibernateUtil.getSession();
        //Query query = session.createQuery("select t from Translation t join fetch t.language l join fetch t.word w where  t.nameTranslation =:word and t.language.id=:id ").setParameter("word", word).setParameter("id", langId);
        Query query = session.createQuery("select  t " +
                "from Translation t " +
                "join fetch t.word " +
                "where t.language.id=:gLangId " +
                "and t.word.id=" +
                "(select t.word.id from Translation t " +
                "where  t.nameTranslation =:word and t.language.id=:id)")
                .setParameter("word", word).
                        setParameter("id", langId).
                        setParameter("gLangId",goalLangId);
        Translation res=null;
        if(query.list().size()>0&& query.list().get(0)!=null)
            res=(Translation)(query.list().get(0));
        session.close();
        return res;
    }
}
