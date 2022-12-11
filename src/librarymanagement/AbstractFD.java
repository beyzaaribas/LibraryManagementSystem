package librarymanagement;
import java.util.ArrayList;


public abstract class AbstractFD<T> {
    abstract ArrayList<T> fetch();
    abstract void deleteMember (int id);
    abstract void deleteBooks (int id);

}
