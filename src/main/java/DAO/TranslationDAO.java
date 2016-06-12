package DAO;

import model.Translation;

public interface TranslationDAO {
    public Translation getTranslation(String word, long langId, long goalLangId);
}

