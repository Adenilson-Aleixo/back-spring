package br.inf.datainfo.desafio.domain.repository;

import br.inf.datainfo.desafio.domain.entity.ExternalUserFunction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExternalUserFunctionRepository extends JpaRepository<ExternalUserFunction, Long> {

    ExternalUserFunction findByCoFunction(final Long externalUserId);
}
