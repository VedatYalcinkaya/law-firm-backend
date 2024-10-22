package com.demirciyazilim.avukatrefwebsite.controller;

import com.demirciyazilim.avukatrefwebsite.dto.contact.requests.AddContactRequest;
import com.demirciyazilim.avukatrefwebsite.dto.contact.requests.UpdateContactRequest;
import com.demirciyazilim.avukatrefwebsite.dto.contact.responses.GetAllContactResponse;
import com.demirciyazilim.avukatrefwebsite.dto.contact.responses.GetContactByIdResponse;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.ContactService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/contacts")
@CrossOrigin
public class ContactController {
    private ContactService contactService;

    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddContactRequest request){
        contactService.add(request);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        contactService.delete(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateContactRequest request){
        contactService.update(request);
    }
    @GetMapping("/getAll")
    public List<GetAllContactResponse> getAll(){
        return contactService.getAll();
    }
    @GetMapping("/getById")
    public GetContactByIdResponse getById(@RequestParam Long id) throws Exception{
        return contactService.getById(id);
    }

}
