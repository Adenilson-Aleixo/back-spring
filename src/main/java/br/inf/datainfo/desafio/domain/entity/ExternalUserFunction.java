package br.inf.datainfo.desafio.domain.entity;

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
@Table(name = "FUNCAO_USUARIO_EXTERNO")
public class ExternalUserFunction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="co_funcao", unique = true)
    private Long coFunction;

    @NotNull(message="Function name can't be empty")
    @Column(name="no_funcao", length=50)
    private String noFunction;

//    @OneToMany(mappedBy = "userFunction")
//    private Set<User> users;
}
