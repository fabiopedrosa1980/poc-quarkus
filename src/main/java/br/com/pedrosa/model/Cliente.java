package br.com.pedrosa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente extends PanacheEntity {

    @NotEmpty(message = "Nome é obrigatorio")
    public String nome;

    @NotNull(message = "Idade é obrigatorio")
    public Integer idade;

    @Schema(hidden = true)
    public Long getId() {
        return id;
    }

}
