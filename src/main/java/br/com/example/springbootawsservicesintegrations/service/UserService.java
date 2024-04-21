package br.com.example.springbootawsservicesintegrations.service;

import br.com.example.springbootawsservicesintegrations.secretsmanager.SecretsManagerService;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    SecretsManagerService secretsManagerClient;

    public String getUserPassword() {
        return secretsManagerClient.getSecretValue("user-test-password");
    }
}
