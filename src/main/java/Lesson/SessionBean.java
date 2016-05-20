package Lesson;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;


@Local(SessionLocal.class)
@Stateless(name = "SessionEJB")
public class SessionBean implements SessionLocal {
    public String string(String text){
        return text+" BEAN";
    }
}
