package LibraryBussinesLayer;

import Model.Entities.*;
import DAO.*;

import javax.annotation.Resource;
import java.util.List;

public class BookMgr {

    @Resource
    private Dao dao;

    final List<Book> list = dao.find(Book.class);

    public Book newBook() {
        return new Book();
    }

    public void persist(Book book) {
        dao.persist(book);
    }

    public List<Book> getBook() {
        return list;
    }

    public Book getBook(int i ) {
        if (!list.isEmpty()) {
                return list.get(i);
            }
        else {
            System.out.print("No Books founded");
            return null;
        }
    }

    public void deleteBook (Book book){
        dao.delete(book);
    }

    public Book getBookById (int id){
        for (int i=0; i<= list.size(); i++ ){
            if (list.get(i).getId()== id){
                return list.get(i);
            }
            else{return null;}

       }

        return null;
    }
}
