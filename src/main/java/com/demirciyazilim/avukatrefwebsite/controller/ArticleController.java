package com.demirciyazilim.avukatrefwebsite.controller;


import com.demirciyazilim.avukatrefwebsite.dto.article.requests.AddArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.DeleteArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.requests.UpdateArticleRequest;
import com.demirciyazilim.avukatrefwebsite.dto.article.responses.GetAllArticleResponse;
import com.demirciyazilim.avukatrefwebsite.dto.article.responses.GetArticleByIdResponse;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/articles")
@CrossOrigin
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/add")
    public ResponseEntity<Void> addArticle(@RequestBody AddArticleRequest request) {
        articleService.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteArticle(@RequestBody DeleteArticleRequest request) {
        articleService.delete(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateArticle(@RequestBody UpdateArticleRequest request) {
        articleService.update(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllArticleResponse>> getAllArticles() {
        List<GetAllArticleResponse> articles = articleService.getAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public GetArticleByIdResponse getById(@RequestParam Long id) throws InterruptedException {
        return articleService.getById(id);
    }

}
