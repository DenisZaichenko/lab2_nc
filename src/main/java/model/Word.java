package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity(name = "Word")
public class Word implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "etailerRaw_seq")
    @SequenceGenerator(name = "etailerRaw_seq",
            sequenceName = "'PRODUCT_ID_SEQ")
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "name")
    public String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "word")
    private Set<Translation> translations;

    public Set<Translation> getTranslations(){
        return  translations;
    }
}
