package br.inf.datainfo.desafio.domain.entity;

import br.inf.datainfo.desafio.domain.repository.deserializer.UserDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIO_EXTERNO")
@JsonDeserialize(using = UserDeserializer.class)
public class User implements Serializable {

    @Id
    @Column(name = "nu_cpf", unique = true, nullable = false)
    private String nuCpf;

    @NotNull(message="User name can't be empty")
    @Column(name="no_usuario", length=60)
    private String noUser;

    @NotNull(message="Email can't be empty")
    @Column(name="de_email", length=255)
    private String deEmail;

    @NotNull(message="Situation can't be empty")
    @Column(name="ic_situacao", length=1)
    private String icSituation;

    @NotNull(message="User profile can't be empty")
    @Column(name="ic_perfil_acesso")
    private Integer icUserProfile;

    @ManyToOne
    @JoinColumn(name = "co_funcao", nullable = false, foreignKey = @ForeignKey(name = "FK_eprtb008_eprtb016"))
    private ExternalUserFunction externalUserFunction;

    @Column(name="nu_telefone")
    private String nuPhone;
}
