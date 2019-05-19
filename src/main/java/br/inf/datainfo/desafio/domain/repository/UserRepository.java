package br.inf.datainfo.desafio.domain.repository;

import br.inf.datainfo.desafio.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("update User nu_cpf set access.status = 'DELETED' where access.nuCpf.id = :nuCpf")
//    @Query("delete from usuario_externo where nu_cpf = :nuCpf")
//    @Modifying
//    void deletedByNuCpf(@Param("nuCpf") String nuCpf);

    User findByNuCpf(String nuCpf);
}
