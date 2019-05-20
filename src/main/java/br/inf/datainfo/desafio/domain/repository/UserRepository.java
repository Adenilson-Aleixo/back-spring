package br.inf.datainfo.desafio.domain.repository;

import br.inf.datainfo.desafio.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

//    @Query("update User nu_cpf set access.status = 'DELETED' where access.nuCpf.id = :nuCpf")
//    @Query("delete from usuario_externo where nu_cpf = :nuCpf")
//    @Modifying
//    void deletedByNuCpf(@Param("nuCpf") String nuCpf);

    User findByNuCpf(String nuCpf);

    Page<User> findAll(Pageable pageable);

    @Query(value ="select * from desafio.usuario_externo where no_usuario like %:noUser%", nativeQuery = true)
    Page<User> filterNoUser(Pageable pageable, @Param("noUser") String noUser);

    @Query(value ="select * from desafio.usuario_externo where ic_situacao = :onlyEnable", nativeQuery = true)
    Page<User> filterOnlyEnable(Pageable pageable, @Param("onlyEnable") String onlyEnable);

    @Query(value ="select * from desafio.usuario_externo where ic_perfil_acesso = :icUserProfile", nativeQuery = true)
    Page<User> filterIcUserProfile(Pageable pageable, @Param("icUserProfile") Integer icUserProfile);

    @Query(value ="select * from desafio.usuario_externo where no_usuario like %:noUser% && ic_situacao = :onlyEnable && ic_perfil_acesso = %:icUserProfile%", nativeQuery = true)
    Page<User> filterByNoUserAndOnlyEnableAndIcUserProfile(Pageable pageable, @Param("noUser") String noUser,  @Param("onlyEnable") String onlyEnable, @Param("icUserProfile") Integer icUserProfile);
}
