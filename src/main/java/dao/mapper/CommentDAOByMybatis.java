package dao.mapper;

import model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentDAOByMybatis {

    @Select("select * from comments where isbn=#{isbn}")
    List<Comment> queryComments(@Param("isbn") String isbn);
}

