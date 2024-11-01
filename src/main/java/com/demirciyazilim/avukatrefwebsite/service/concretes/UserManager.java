package com.demirciyazilim.avukatrefwebsite.service.concretes;

import com.demirciyazilim.avukatrefwebsite.core.utilities.exceptions.types.BusinessException;
import com.demirciyazilim.avukatrefwebsite.core.utilities.mapper.ModelMapperService;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.AddUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.requests.UpdateUserRequest;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetAllUserResponse;
import com.demirciyazilim.avukatrefwebsite.dto.user.responses.GetByIdUserResponse;
import com.demirciyazilim.avukatrefwebsite.entity.User;
import com.demirciyazilim.avukatrefwebsite.repository.UserRepository;
import com.demirciyazilim.avukatrefwebsite.service.abstracts.UserService;
import com.demirciyazilim.avukatrefwebsite.service.constants.Messages;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public User add(AddUserRequest request) {
        chechIsUserEmailExists(request.getEmail());
        checkUserPasswordLength(request.getPassword());
        User user = this.modelMapperService.forRequest().map(request, User.class);
        this.userRepository.save(user);
        return user;
    }

    @Override
    public void delete(int id) {
        User userToDelete = findUser(id);
        userRepository.delete(userToDelete);
    }

    @Override
    public void update(UpdateUserRequest request) {
        User userToUpdate =findUser(request.getId());
        checkUserPasswordLength(request.getPassword());
        this.modelMapperService.forRequest().map(request, userToUpdate);
        userRepository.saveAndFlush(userToUpdate);
    }

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> responses = users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class))
                .toList();
        return responses;
    }

    @Override
    public GetByIdUserResponse getById(int id) {
        User user = findUser(id);
        GetByIdUserResponse response = this.modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return response;
    }

    @Override
    public GetByIdUserResponse getByEmail(String email) {
        User user = findUserByEmail(email);
        GetByIdUserResponse response = this.modelMapperService.forResponse().map(user,GetByIdUserResponse.class);
        return response;
    }

    @Override
    public boolean existsUserById(int id) {
        return userRepository.existsById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findUserByEmail(username);
        return user;
    }

    private void chechIsUserEmailExists(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BusinessException(Messages.emailAlreadyExists);
        }
    }
    private void checkUserPasswordLength(String password){
        if (password.length()<8){
            throw new BusinessException(Messages.passwordLength);
        }
    }
    private User findUser(int value){
        return userRepository.findById(value)
                .orElseThrow(()-> new BusinessException(Messages.userNotFound));
    }
    private User findUserByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(()-> new BusinessException(Messages.userNotFound));
    }
}