package com.demirciyazilim.avukatrefwebsite.controller;

import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.AddLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.DeleteLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.UpdateLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses.GetAllLegalContentResponse;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses.GetLegalContentByIdResponse;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.LegalContentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/legal-contents")
@CrossOrigin
public class LegalContentController {
    private final LegalContentService legalContentService;

    @PostMapping("/add")
    public ResponseEntity<Void> addLegalContent(@RequestBody AddLegalContentRequest request) {
        legalContentService.add(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteLegalContent(@RequestBody DeleteLegalContentRequest request) {
        legalContentService.delete(request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateLegalContent(@RequestBody UpdateLegalContentRequest request) {
        legalContentService.update(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllLegalContentResponse>> getAllLegalContents() {
        List<GetAllLegalContentResponse> legalContents = legalContentService.getAll();
        return new ResponseEntity<>(legalContents, HttpStatus.OK);
    }

    @GetMapping("/getById")
    public GetLegalContentByIdResponse getById(@RequestParam Long id) {
        return legalContentService.getById(id);
    }
}