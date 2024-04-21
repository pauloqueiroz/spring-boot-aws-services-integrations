package br.com.example.springbootawsservicesintegrations.secretsmanager;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;

@Component
public interface SecretsManagerService {

    public String getSecretValue(String secretName);
}
