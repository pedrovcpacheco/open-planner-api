package br.edu.ifpb.mestrado.openplanner.api.domain.service;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.notificacao.Notificacao;

public interface NotificacaoService extends BaseManyByUsuarioService<Notificacao> {

    void switchLida(Long id);

}
