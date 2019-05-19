package br.inf.datainfo.desafio.domain.repository;

import br.inf.datainfo.desafio.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

//    @Query("update User nu_cpf set access.status = 'DELETED' where access.nuCpf.id = :nuCpf")
//    @Query("delete from usuario_externo where nu_cpf = :nuCpf")
//    @Modifying
//    void deletedByNuCpf(@Param("nuCpf") String nuCpf);

    User findByNuCpf(String nuCpf);

    Page<User> findAll(Pageable pageable);
}
