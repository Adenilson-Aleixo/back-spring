package br.inf.datainfo.desafio.domain.service;

import br.inf.datainfo.desafio.domain.Utils.CpfUtils;
import br.inf.datainfo.desafio.domain.entity.User;
import br.inf.datainfo.desafio.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private CpfUtils cpfUtils;

    @Autowired
    private Environment env;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(final User newUser) throws IOException{
        if (!cpfUtils.isValid(newUser.getNuCpf())) {
            throw new IOException(env.getProperty("user.MN035"));
        }

        User existUser = userRepository.findByNuCpf(newUser.getNuCpf());

        if (existUser != null && existUser.getNuCpf().equals(newUser.getNuCpf())) {
            throw new IOException(env.getProperty("user.MN034"));
        }

        return userRepository.save(newUser);
    }

    public User update(final User updateUser)throws IOException{
        if (!cpfUtils.isValid(updateUser.getNuCpf())) {
            throw new IOException(env.getProperty("user.MN035"));
        }

        return userRepository.save(updateUser);
    }

    public void delete(String nuCpf){
        User user = userRepository.findByNuCpf(nuCpf);
        userRepository.delete(user);
    }

    public void disableUser(String nuCpf, Boolean onlyEnable) {
        User user = userRepository.findByNuCpf(nuCpf);

        if (onlyEnable){
            user.setIcSituation("A");
        } else {
            user.setIcSituation("I");
        }
        userRepository.save(user);
    }
}
