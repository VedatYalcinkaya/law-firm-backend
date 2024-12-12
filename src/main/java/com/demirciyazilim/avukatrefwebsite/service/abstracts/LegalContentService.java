package com.demirciyazilim.avukatrefwebsite.service.abstracts;

import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.AddLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.DeleteLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.UpdateLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses.GetAllLegalContentResponse;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses.GetLegalContentByIdResponse;
import com.demirciyazilim.avukatrefwebsite.entity.LegalContent;

import java.util.List;

public interface LegalContentService {


    void add(AddLegalContentRequest request);


    void delete(DeleteLegalContentRequest request);


    void update(UpdateLegalContentRequest request);


    List<GetAllLegalContentResponse> getAll();


    GetLegalContentByIdResponse getById(Long contentId);
}