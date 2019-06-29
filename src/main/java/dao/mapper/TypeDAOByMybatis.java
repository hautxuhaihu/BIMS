package dao.mapper;

import model.Type;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface TypeDAOByMybatis {

  @Insert("insert into book_type(name)" + "values(#{type.name})")
  int add(@Param("type") Type type);

  @Select("select * from book_type")
  List<Type> getAll();
}
