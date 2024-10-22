package com.demirciyazilim.avukatrefwebsite.service.concretes;

import com.demirciyazilim.avukatrefwebsite.core.utilities.mapper.ModelMapperService;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.AddUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.UpdateUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetAllUserResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetUserByIdResponse;
import com.demirciyazilim.avukatrefwebsite.entity.User;
import com.demirciyazilim.avukatrefwebsite.repository.UserRepository;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public void add(AddUserRequest request) {
        User user = this.modelMapperService.forRequest().map(request, User.class);
        userRepository.save(user);
    }

    // Kullanıcı güncelleme işlemi
    @Override
    public void update(UpdateUserRequest request) {
        User existingUser = userRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        User updatedUser = modelMapperService.forRequest().map(request, User.class);
        updatedUser.setId(existingUser.getId());  // ID sabit kalmalı, çünkü update yapıyoruz

        userRepository.save(updatedUser);
    }

    // Kullanıcıyı silme işlemi
    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        userRepository.delete(user);
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapperService.forResponse().map(user, GetAllUserResponse.class))
                .collect(Collectors.toList());
    }
    @Override
    public GetUserByIdResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        return modelMapperService.forResponse().map(user, GetUserByIdResponse.class);
    }
}
