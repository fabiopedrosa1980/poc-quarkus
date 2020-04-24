package br.com.pedrosa.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {

    @Schema(hidden = true)
    public Long getId() {
        return id;
    }

    public String nome;

    public Integer idade;

}
