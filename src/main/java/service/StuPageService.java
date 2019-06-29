package service;

import com.github.pagehelper.PageInfo;
import dao.mapper.PressDAOByMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class StuPageService {
  @Autowired
  PressDAOByMybatis dao;
  @Cacheable("allStus:pageService")
  public PageInfo findByPage(int pageNum, int pageSize) {
    return PageInfo.of(dao.getAllByPageNumSize(pageNum, pageSize));
  }
}
