package br.com.example.springbootawsservicesintegrations.service;

import br.com.example.springbootawsservicesintegrations.model.User;
import br.com.example.springbootawsservicesintegrations.secretsmanager.SecretsManagerService;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final SecretsManagerService secretsManagerService;

    @Autowired
    public UserService(SecretsManagerService secretsManagerService) {
        this.secretsManagerService = secretsManagerService;
    }

    public String getUserPassword() {
        return secretsManagerService.getSecretValue("user-test-password");
    }

    public void createSession(){
        User user = new User("User test", "test@gmail.com", "5511999999999");
        RedissonClient redissonClient = Redisson.create();

    }
}
