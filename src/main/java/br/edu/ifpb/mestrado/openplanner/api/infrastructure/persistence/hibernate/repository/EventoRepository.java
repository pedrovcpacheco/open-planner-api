package br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.repository;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.evento.Evento;

public interface EventoRepository extends BaseManyByUsuarioRepository<Evento> {

    void deleteByRelacaoId(Long id);

}
