package com.demirciyazilim.avukatrefwebsite.service.concretes;

import com.demirciyazilim.avukatrefwebsite.core.utilities.mapper.ModelMapperService;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.AddArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.DeleteArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.UpdateArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.responses.GetAllArticleResponse;
import com.demirciyazilim.avukatrefwebsite.dto.article.responses.GetArticleByIdResponse;
import com.demirciyazilim.avukatrefwebsite.entity.Article;
import com.demirciyazilim.avukatrefwebsite.repository.ArticleRepository;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ArticleManager implements ArticleService {
    private final ArticleRepository articleRepository;
    private final ModelMapperService modelMapperService;

    @Override
    @Transactional
    public void add(AddArticleRequest addArticleRequest) {
        Article article = modelMapperService.forRequest().map(addArticleRequest, Article.class);
        articleRepository.save(article);
    }

    @Override
    @Transactional
    public void delete(DeleteArticleRequest deleteArticleRequest) {
        Article article = articleRepository.findById(deleteArticleRequest.getId())
                .orElseThrow(() -> new RuntimeException("Makale bulunamadı"));
        articleRepository.delete(article);
    }

    @Override
    @Transactional
    public void update(UpdateArticleRequest updateArticleRequest) {
        Article existingArticle = articleRepository.findById(updateArticleRequest.getId())
                .orElseThrow(() -> new RuntimeException("Makale bulunamadı"));

        Article updatedArticle = modelMapperService.forRequest().map(updateArticleRequest, Article.class);
        updatedArticle.setId(existingArticle.getId());

        articleRepository.save(updatedArticle);
    }

    @Override
    public List<GetAllArticleResponse> getAll() {
        List<Article> articles = articleRepository.findAll();
        return articles.stream()
                .map(article -> modelMapperService.forResponse().map(article, GetAllArticleResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetArticleByIdResponse getById(Long articleId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Makale bulunamadı"));
        return modelMapperService.forResponse().map(article, GetArticleByIdResponse.class);
    }
}
