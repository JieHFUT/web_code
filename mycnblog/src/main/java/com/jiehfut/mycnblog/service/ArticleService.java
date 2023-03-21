package com.jiehfut.mycnblog.service;


import com.jiehfut.mycnblog.mapper.ArticleMapper;
import com.jiehfut.mycnblog.model.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<ArticleInfo> getMyList(int uid) {
        return articleMapper.getMyList(uid);
    }

}
