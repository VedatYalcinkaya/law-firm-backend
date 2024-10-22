package com.demirciyazilim.avukatrefwebsite.service.abstracts;

import com.demirciyazilim.avukatrefwebsite.dto.article.requests.AddArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.DeleteArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.UpdateArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.responses.GetAllArticleResponse;
import com.demirciyazilim.avukatrefwebsite.dto.article.responses.GetArticleByIdResponse;

import java.util.List;

public interface ArticleService {
    void add(AddArticleRequest addArticleRequest);

    void delete(DeleteArticleRequest deleteArticleRequest);

    void update(UpdateArticleRequest updateArticleRequest);

    List<GetAllArticleResponse> getAll();

    GetArticleByIdResponse getById(Long articleId);
}
