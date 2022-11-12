package com.greecode.IndependentBand.services;

import com.greecode.IndependentBand.models.User;
import com.greecode.IndependentBand.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Listar todos os usuários
    public List<User> getUsers() {
        log.info( "Lista todos usuários" );
        return userRepository.findAll();
    }
    // Listar um usuário
    public Optional<User> getUserById(Long id) {
        log.info( "Lista usuário por id {}", id );
        return userRepository.findById(id);
    }
    // Salvar usuário
    public User saveUser(@RequestBody User user) {
        log.info( "Usuário {}", user.getName(), " salvo com sucesso!" );
        if(user != null){
            return userRepository.save(user);
        }
        return null;
    }
    // Deleta usuário
    public Boolean deleteUser(Long id) {
        log.info( "Deleta usuário por id ", id );
        userRepository.deleteById(id);
        return true;
    }
    
    // Atualiza usuário
    public Optional<User> updateUser(Long id, User user) {
        log.info( "Usuário {} ", user.getName(), " Atualizado com sucesso!" );
        return userRepository.findById(id).map(
          record -> {
              record.setName(user.getName());
              record.setEmail(user.getEmail());
              record.setPassword(user.getPassword());
              record.setCellphone(user.getCellphone());
              User userUpdated = userRepository.save(record);
              return userUpdated;
                  }
          );
    }


}
