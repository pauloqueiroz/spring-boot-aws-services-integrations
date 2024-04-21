package br.com.example.springbootawsservicesintegrations.secretsmanager;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.services.secretsmanager.model.SecretsManagerException;

public class SecretsManagerServiceImpl implements SecretsManagerService {


	@Override
    public String getSecretValue(String secretName) {
        try {
            SecretsManagerClient secretsClient = getSecretsManagerClient();
            GetSecretValueRequest valueRequest = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse valueResponse = secretsClient.getSecretValue(valueRequest);
            String secret = valueResponse.secretString();
            System.out.println(secret);
            return secret;

        } catch (SecretsManagerException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
        return null;
    }

    private static SecretsManagerClient getSecretsManagerClient() {
        return SecretsManagerClient.builder()
                .region(Region.SA_EAST_1)
                .build();
    }

}
