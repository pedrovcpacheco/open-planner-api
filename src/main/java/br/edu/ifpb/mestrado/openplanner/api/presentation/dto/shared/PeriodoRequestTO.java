package br.edu.ifpb.mestrado.openplanner.api.presentation.dto.shared;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class PeriodoRequestTO implements Serializable {

    private static final long serialVersionUID = 2856924207775880724L;

    @NotNull
    private LocalDate dataInicio;

    @NotNull
    private LocalDate dataFim;

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

}
