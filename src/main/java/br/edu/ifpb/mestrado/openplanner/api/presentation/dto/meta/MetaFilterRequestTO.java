package br.edu.ifpb.mestrado.openplanner.api.presentation.dto.meta;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.meta.Status;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification.Operation;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification.SpecField;

public class MetaFilterRequestTO implements Serializable {

    private static final long serialVersionUID = 7793931799975538097L;

    private Long id;

    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate data;

    @SpecField(operation = Operation.LIKE_IGNORE_CASE_UNACCENT)
    private String descricao;

    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
