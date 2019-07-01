package dao.mapper;

import model.Score;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreDAOByMybatis {

    @Insert("insert into scores(isbn,id,score)" + "values(#{score.isbn},#{score.id},#{score.score})")
    int add(@Param("score") Score score);

    @Select("select IFNULL(avg(score),0) from(select * from scores where isbn=#{isbn})")
    int queryAvgScore(@Param("isbn") String isbn);

    @Select("select IFNULL(score,0) from scores where isbn=#{score.isbn} and id=#{score.id}")
    int queryScore(@Param("score") Score score);
}

