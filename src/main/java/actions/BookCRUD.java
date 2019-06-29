package actions;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import dao.mapper.BookDAOByMybatis;
import lombok.Getter;
import lombok.Setter;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import tools.IOUtils;

import java.io.File;
import java.util.List;
import java.util.Map;


public class BookCRUD extends ActionSupport implements ModelDriven<Book> {
    private Book book=new Book();
    @Autowired
    @Setter @Getter
    BookDAOByMybatis dao;

    private IOUtils ioUtils = new IOUtils();
    @Setter @Getter
    private File myUpload;
    @Setter @Getter
    private String myUploadFileName;

    @Override
    public Book getModel(){
        return book;
    }

    public String addBook() throws Exception {
        String rs=ioUtils.copySingleFile(myUpload,myUploadFileName,"upload");
        if(rs.equals("success")){
            String uploadPath="upload/"+myUploadFileName;
            book.setCover(uploadPath);
            System.out.println(book);
            int row = dao.add(book);
            return row > 0 ? SUCCESS : ERROR;
        }else {
            return ERROR;
        }
    }
}
