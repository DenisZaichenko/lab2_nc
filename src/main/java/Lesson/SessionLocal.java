package Lesson;

import javax.ejb.Local;

@Local
public interface SessionLocal {
    public String string(String text);
}
