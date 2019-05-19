package br.inf.datainfo.desafio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class UserProfile {
    @Bean
    public Map<Integer, String> profile(){
        Map<Integer, String> profile = new HashMap<>();
        profile.put(0, "Aluno");
        profile.put(1, "Gestor Municipal");
        profile.put(2, "Gestor Estadual");
        profile.put(3, "Gestor Nacional");

        return profile;
    }
}
