package com.jiehfut.mycnblog.controller;


import com.jiehfut.mycnblog.common.Constant;
import com.jiehfut.mycnblog.model.ArticleInfo;
import com.jiehfut.mycnblog.model.UserInfo;
import com.jiehfut.mycnblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @RequestMapping("/mylist")
    public List<ArticleInfo> mylist(HttpServletRequest request) {
        UserInfo userInfo = (UserInfo) request.getAttribute(Constant.SESSION_USERINFO_KEY);
        if (userInfo != null) {
            return articleService.getMyList(userInfo.getId());
        }
        return null;
    }
}
