package com.jiehfut.mycnblog.mapper;

import com.jiehfut.mycnblog.model.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleMapper {

    public List<ArticleInfo> getMyList(@Param("uid") int uid);

}
