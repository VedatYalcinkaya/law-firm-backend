package com.demirciyazilim.avukatrefwebsite.service.abstracts;

import com.demirciyazilim.avukatrefwebsite.dto.user.requests.AddUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.UpdateUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetAllUserResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetByEmailUserResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetByIdUserResponse;

import com.demirciyazilim.avukatrefwebsite.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {

    User add(AddUserRequest request);
    void delete(int id);
    void update(UpdateUserRequest request);
    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(int id);
    GetByEmailUserResponse getByEmail(String email);
    boolean existsUserById(int id);


}
