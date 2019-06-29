package dao.mapper;

import model.Press;
import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface PressDAOByMybatis {
//  @Cacheable("allPresss")
  @Select("select * from press")
  List<Press> getAll();

  //@Cacheable(value = "allPresss:page")
  @Select("select * from press")
  List<Press> getAllByPageNumSize(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

  @Cacheable("allPresss")
  @Select("select * from stu where id=#{id}")
  Press findById(@Param("id") long id);

  @CacheEvict(value = "allPresss",allEntries = true)
  @Insert("insert into press(name)" + "values(#{press.name})")
//  @Options(useGeneratedKeys = true,keyProperty = "stu.id")
  int add(@Param("press") Press press);

  @CacheEvict(value = "allPresss",allEntries = true)
  @Update("update stu set username=#{stu.username},os=#{stu.os}," +
      "java=#{stu.java},math=#{stu.math} where id=#{stu.id}")
  int update(@Param("stu") Press stu);

  @CacheEvict(value = "allPresss",allEntries = true)
  @Delete("delete from stu where id=#{id}")
  int delById(@Param("id") long id);

  @Select("select count(*) from stu")
  int total();
}
