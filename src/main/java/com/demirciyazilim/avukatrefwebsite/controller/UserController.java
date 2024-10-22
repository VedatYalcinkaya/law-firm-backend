package com.demirciyazilim.avukatrefwebsite.controller;

import com.demirciyazilim.avukatrefwebsite.dto.user.requests.AddUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.UpdateUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetAllUserResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetUserByIdResponse;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    // Kullanıcı ekleme
    @PostMapping("/add")
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody @Valid AddUserRequest request){
        userService.add(request);
    }

    // Kullanıcı silme
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

    // Kullanıcı güncelleme
    @PutMapping("/update")
    public void update(@RequestBody @Valid UpdateUserRequest request){
        userService.update(request);
    }

    // Tüm kullanıcıları listeleme
    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll(){
        return userService.getAll();
    }

    // ID'ye göre kullanıcı getirme
    @GetMapping("/getById")
    public GetUserByIdResponse getById(@RequestParam Long id) throws Exception{
        return userService.getById(id);
    }
}
