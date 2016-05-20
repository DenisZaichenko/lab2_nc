package model;

import javax.persistence.*;

@Entity(name = "Translation")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "etailerRaw_seq")
    @SequenceGenerator(name = "etailerRaw_seq",
            sequenceName = "'PRODUCT_ID_SEQ")
    private Long id;


    public Long getId() {
        return id;
    }

    public Word getWord() {
        return word;
    }

    public Language getLanguage() {
        return language;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getNameTranslation() {
        return nameTranslation;
    }

    public void setNameTranslation(String nameTranslation) {
        this.nameTranslation = nameTranslation;
    }

    public String getDescriptionTranslation() {
        return descriptionTranslation;
    }

    public void setDescriptionTranslation(String descriptionTranslation) {
        this.descriptionTranslation = descriptionTranslation;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Word_id", nullable = false)
    private Word word;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Lang_id", nullable = false)
    private Language language;

    private String nameTranslation;

    private String descriptionTranslation;



}
