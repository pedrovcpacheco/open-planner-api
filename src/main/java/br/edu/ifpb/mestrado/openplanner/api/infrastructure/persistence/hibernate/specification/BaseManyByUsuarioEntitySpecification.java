package br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.usuario.Usuario;
import br.edu.ifpb.mestrado.openplanner.api.domain.model.usuario.Usuario_;
import br.edu.ifpb.mestrado.openplanner.api.domain.shared.BaseManyByUsuarioEntity_;
import br.edu.ifpb.mestrado.openplanner.api.domain.shared.BaseOneByUsuarioEntity;

public class BaseManyByUsuarioEntitySpecification {

    public static <T extends BaseOneByUsuarioEntity> Specification<T> usuarioId(Long id) {
        return Specification
                .where((root, query, criteriaBuilder) -> {
                    Join<T, Usuario> joinUsuario = root.join(BaseManyByUsuarioEntity_.USUARIO);

                    return criteriaBuilder.equal(joinUsuario.get(Usuario_.ID), id);
                });
    }

}
