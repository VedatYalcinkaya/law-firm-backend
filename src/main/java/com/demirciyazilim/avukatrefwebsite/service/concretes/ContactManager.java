package com.demirciyazilim.avukatrefwebsite.service.concretes;

import com.demirciyazilim.avukatrefwebsite.core.utilities.mapper.ModelMapperService;
import com.demirciyazilim.avukatrefwebsite.dto.contact.requests.AddContactRequest;
import com.demirciyazilim.avukatrefwebsite.dto.contact.requests.UpdateContactRequest;
import com.demirciyazilim.avukatrefwebsite.dto.contact.responses.GetAllContactResponse;
import com.demirciyazilim.avukatrefwebsite.dto.contact.responses.GetContactByIdResponse;
import com.demirciyazilim.avukatrefwebsite.entity.Contact;
import com.demirciyazilim.avukatrefwebsite.repository.ContactRepository;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContactManager implements ContactService {
    private final ContactRepository contactRepository;
    private final ModelMapperService modelMapperService;

    // Contact ekleme işlemi
    @Override
    @Transactional
    public void add(AddContactRequest request) {
        Contact contact = this.modelMapperService.forRequest().map(request, Contact.class);
        contactRepository.save(contact);
    }

    // Contact güncelleme işlemi
    @Override
    @Transactional
    public void update(UpdateContactRequest request) {
        Contact existingContact = contactRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("İletişim bulunamadı"));

        Contact updatedContact = modelMapperService.forRequest().map(request, Contact.class);
        updatedContact.setId(existingContact.getId());  // ID'yi sabit tutuyoruz, güncelleme işlemi

        contactRepository.save(updatedContact);
    }

    // Contact silme işlemi
    @Override
    @Transactional
    public void delete(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("İletişim bulunamadı"));
        contactRepository.delete(contact);
    }

    // Tüm Contact'ları listeleme işlemi
    @Override
    public List<GetAllContactResponse> getAll() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contact -> modelMapperService.forResponse().map(contact, GetAllContactResponse.class))
                .collect(Collectors.toList());
    }

    // ID'ye göre Contact getirme işlemi
    @Override
    public GetContactByIdResponse getById(Long id) {
        Contact contact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("İletişim bulunamadı"));
        return modelMapperService.forResponse().map(contact, GetContactByIdResponse.class);
    }



}
