package com.demirciyazilim.avukatrefwebsite.service.abstracts;

import com.demirciyazilim.avukatrefwebsite.dto.user.requests.AddUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.UpdateUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetAllUserResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetUserByIdResponse;


import java.util.List;

public interface UserService {

    void add(AddUserRequest request);  // Kullanıcı ekleme

    List<GetAllUserResponse> getAll();  // Tüm kullanıcıları listeleme

    GetUserByIdResponse getById(Long id);  // ID'ye göre kullanıcı getirme

    void update(UpdateUserRequest request);  // Kullanıcı güncelleme

    void delete(Long id);  // Kullanıcı silme

}
