package DAO;

import model.Language;

import javax.ejb.Local;
import java.util.List;

@Local
public interface LanguageDAO {
    public List<Language> getAllLanguages();
}
