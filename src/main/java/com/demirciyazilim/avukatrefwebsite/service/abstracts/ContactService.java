package com.demirciyazilim.avukatrefwebsite.service.abstracts;

import com.demirciyazilim.avukatrefwebsite.dto.contact.requests.AddContactRequest;
import com.demirciyazilim.avukatrefwebsite.dto.contact.requests.UpdateContactRequest;
import com.demirciyazilim.avukatrefwebsite.dto.contact.responses.GetAllContactResponse;
import com.demirciyazilim.avukatrefwebsite.dto.contact.responses.GetContactByIdResponse;

import java.util.List;

public interface ContactService {
    void add(AddContactRequest request);  // Contact ekleme
    void delete(Long id);  // Contact silme
    void update(UpdateContactRequest request);  // Contact güncelleme
    List<GetAllContactResponse> getAll();  // Tüm Contact'ları listeleme
    GetContactByIdResponse getById(Long id);  // ID'ye göre Contact getirme


}
