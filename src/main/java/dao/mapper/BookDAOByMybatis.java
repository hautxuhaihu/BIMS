package dao.mapper;

import model.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface BookDAOByMybatis {


//  @CacheEvict(value = "allPresss", allEntries = true)
    @Insert("insert into books(isbn,name,author,price,date,press,type,cover)" + "values(#{book.isbn}," +
          "#{book.name},#{book.author},#{book.price},#{book.date},#{book.press},#{book.type},#{book.cover})")
//  @Options(useGeneratedKeys = true,keyProperty = "stu.id")
    int add(@Param("book") Book book);

//  @Cacheable("allPresss")
    @Select("select * from books where isbn like '%${isbn}%'")
    List<Book> queryByIsbn(@Param("isbn") String isbn);
    @Select("select * from books where name like '%${name}%'")
    List<Book> queryByName(@Param("name") String name);
    @Select("select * from books where author like '%${author}%'")
    List<Book> queryByAuthor(@Param("author") String author);
    @Select("select * from books where press like '%${press}%'")
    List<Book> queryByPress(@Param("press") String press);
    @Select("select * from books where type like '%${type}%'")
    List<Book> queryByType(@Param("type") String type);
    @Select("${sql}")
    List<Book> query(@Param("sql") String sql);
}

