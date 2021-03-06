package br.edu.ifpb.mestrado.openplanner.api.presentation.dto.viagem;

import java.io.Serializable;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.viagem.Status;
import br.edu.ifpb.mestrado.openplanner.api.domain.model.viagem.Tipo;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification.Operation;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification.SpecField;
import br.edu.ifpb.mestrado.openplanner.api.presentation.dto.shared.PeriodoFilterRequestTO;

public class ViagemFilterRequestTO implements Serializable {

    private static final long serialVersionUID = -2693360313523783449L;

    private Long id;

    private Tipo tipo;

    private PeriodoFilterRequestTO periodo;

    @SpecField(operation = Operation.LIKE_IGNORE_CASE_UNACCENT)
    private String destino;

    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public PeriodoFilterRequestTO getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoFilterRequestTO periodo) {
        this.periodo = periodo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
