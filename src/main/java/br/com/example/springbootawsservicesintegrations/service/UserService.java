package br.com.example.springbootawsservicesintegrations.service;

import br.com.example.springbootawsservicesintegrations.secretsmanager.SecretsManagerService;
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
}
