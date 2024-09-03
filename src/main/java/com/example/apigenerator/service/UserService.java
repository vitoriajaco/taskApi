package com.example.apigenerator.service;

import com.example.apigenerator.model.UserModel;
import com.example.apigenerator.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserModel updateUser(Long id, UserModel userDetails) {
        Optional<UserModel> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            user.setNome(userDetails.getNome());
            user.setPassword(userDetails.getPassword());
            user.setListaAtividade(userDetails.getListaAtividade());
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Não foi encontrado usuário com o id " + id);
        }
    }

    public UserModel findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi encontrado usuário com o id" + id));
    }
}
