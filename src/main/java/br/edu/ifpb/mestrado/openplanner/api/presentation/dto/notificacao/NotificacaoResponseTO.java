package br.edu.ifpb.mestrado.openplanner.api.presentation.dto.notificacao;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.notificacao.TipoNotificacao;

public class NotificacaoResponseTO implements Serializable {

    private static final long serialVersionUID = -701297302922423644L;

    private Long id;

    private LocalDateTime dataHora;

    private TipoNotificacao tipo;

    private String descricao;

    private Boolean email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public TipoNotificacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoNotificacao tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getEmail() {
        return email;
    }

    public void setEmail(Boolean email) {
        this.email = email;
    }

}
