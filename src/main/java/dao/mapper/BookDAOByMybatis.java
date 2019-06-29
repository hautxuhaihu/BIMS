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
}

