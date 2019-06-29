package dao;

import model.Book;
import model.Press;

import java.util.List;

public interface MyDAO {
    public String url = "jdbc:hsqldb:hsql://localhost";
    public String driver = "org.hsqldb.jdbcDriver";
    public String user="sa";
    public String pass="";
    public boolean checkLogin(String username, String password) throws Exception;
//    public List<String[]> getAllBooks() throws Exception;
//    public List<String[]> queryByPageBooks(Book book) throws Exception;
//    public String addBook(Book book) throws Exception;
//    public String delBook(Book book) throws Exception;
//    public String modifyBook(Book book) throws Exception;
}
