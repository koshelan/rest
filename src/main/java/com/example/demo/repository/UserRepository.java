package com.example.demo.repository;

import com.example.demo.model.Authorities;
import com.example.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class UserRepository {

    Map<User, List<Authorities>> repository;

    public UserRepository() {
        this.repository = new ConcurrentHashMap<>();
        uploadTestUsers();
    }

    public List<Authorities> getUserAuthorities(User user) {
        return repository.get(user);
    }

    public void addUser(String user, String password, List<Authorities> list) {
        repository.put(new User(user, password), new CopyOnWriteArrayList<Authorities>(list));
    }

    private void uploadTestUsers() {
        addUser("user", "password", List.of(Authorities.READ, Authorities.WRITE));
        addUser("alex", "alex", List.of(Authorities.READ, Authorities.DELETE));
        addUser("max", "max", List.of(Authorities.WRITE));
    }

}
