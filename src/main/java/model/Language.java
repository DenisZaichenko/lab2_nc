package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Language")
public class Language implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "etailerRaw_seq")
    @SequenceGenerator(name = "etailerRaw_seq",
            sequenceName = "'PRODUCT_ID_SEQ")
    private Long id;




    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
    private Set<Translation> translations;

    public Set<Translation> getTranslations(){
        return  translations;
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
