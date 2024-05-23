package com.example.test.models.projections;

import com.example.test.models.AuthCred;
import com.example.test.models.Blog;
import com.example.test.models.Comment;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@Projection(name = "blogCommentProjection", types = { Blog.class })
@CrossOrigin("*")
public interface BlogCommentProjection {
    Long getId();
    String getTopic();
    String getArticle();
    String getReadTime();
    Date getCreateOn();
    Date getUpdatedOn();
    List<Comment> getComments();


}
