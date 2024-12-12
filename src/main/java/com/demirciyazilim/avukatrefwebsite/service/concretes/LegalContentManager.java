package com.demirciyazilim.avukatrefwebsite.service.concretes;

import com.demirciyazilim.avukatrefwebsite.core.utilities.mapper.ModelMapperService;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.AddLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.DeleteLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.requests.UpdateLegalContentRequest;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses.GetAllLegalContentResponse;
import com.demirciyazilim.avukatrefwebsite.dto.legalContent.responses.GetLegalContentByIdResponse;
import com.demirciyazilim.avukatrefwebsite.entity.LegalContent;
import com.demirciyazilim.avukatrefwebsite.repository.LegalContentRepository;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.LegalContentService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LegalContentManager implements LegalContentService {
    private final LegalContentRepository legalContentRepository;
    private final ModelMapperService modelMapperService;

    @Override
    @Transactional
    public void add(AddLegalContentRequest addLegalContentRequest) {
        LegalContent legalContent = modelMapperService.forRequest().map(addLegalContentRequest, LegalContent.class);
        legalContentRepository.save(legalContent);
    }

    @Override
    @Transactional
    public void delete(DeleteLegalContentRequest deleteLegalContentRequest) {
        LegalContent legalContent = legalContentRepository.findById(deleteLegalContentRequest.getId())
                .orElseThrow(() -> new RuntimeException("Legal Content not found"));
        legalContentRepository.delete(legalContent);
    }

    @Override
    @Transactional
    public void update(UpdateLegalContentRequest updateLegalContentRequest) {
        LegalContent existingContent = legalContentRepository.findById(updateLegalContentRequest.getId())
                .orElseThrow(() -> new RuntimeException("Legal Content not found"));

        LegalContent updatedContent = modelMapperService.forRequest().map(updateLegalContentRequest, LegalContent.class);
        updatedContent.setId(existingContent.getId());

        legalContentRepository.save(updatedContent);
    }

    @Override
    public List<GetAllLegalContentResponse> getAll() {
        List<LegalContent> legalContents = legalContentRepository.findAll();
        return legalContents.stream()
                .map(content -> modelMapperService.forResponse().map(content, GetAllLegalContentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public GetLegalContentByIdResponse getById(Long contentId) {
        LegalContent legalContent = legalContentRepository.findById(contentId)
                .orElseThrow(() -> new RuntimeException("Legal Content not found"));
        return modelMapperService.forResponse().map(legalContent, GetLegalContentByIdResponse.class);
    }
}