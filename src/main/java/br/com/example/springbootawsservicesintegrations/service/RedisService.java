package br.com.example.springbootawsservicesintegrations.service;

import br.com.example.springbootawsservicesintegrations.model.User;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RedisService {

    public void createSession(User user){
        // connects to 127.0.0.1:6379 by default
        RedissonClient redisson = Redisson.create();
        UUID uuid = UUID.randomUUID();
        System.out.println("UUID: " +uuid);
        RMap map =  redisson.getMap(uuid.toString());
        map.put("userid", uuid.toString());
        map.put("name", user.name());
        map.put("email", user.email());
        map.put("phoneNumber", user.phoneNumber());

        map.get(uuid);
        redisson.shutdown();
    }
}
