package br.edu.ifpb.mestrado.openplanner.api.application.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.usuario.Usuario;
import br.edu.ifpb.mestrado.openplanner.api.domain.service.UsuarioService;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.facade.ModelMapperFacade;
import br.edu.ifpb.mestrado.openplanner.api.presentation.dto.usuario.UsuarioPublicEmailRequestTO;
import br.edu.ifpb.mestrado.openplanner.api.presentation.dto.usuario.UsuarioPublicRequestTO;
import br.edu.ifpb.mestrado.openplanner.api.presentation.dto.usuario.UsuarioPublicSenhaTokenRequestTO;

@RestController
@RequestMapping("/public/usuarios")
public class UsuarioPublicController {

    private UsuarioService usuarioService;

    private ModelMapperFacade converterService;

    public UsuarioPublicController(UsuarioService usuarioService, ModelMapperFacade converterService) {
        this.usuarioService = usuarioService;
        this.converterService = converterService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UsuarioPublicRequestTO requestTO) {
        Usuario usuario = converterService.map(requestTO, Usuario.class);
        usuarioService.save(usuario);
    }

    @PostMapping("/ativacao")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activate(@RequestBody UsuarioPublicSenhaTokenRequestTO requestTO) {
        usuarioService.activate(requestTO.getToken());
    }

    @PatchMapping("/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateSenhaByResetToken(@RequestBody UsuarioPublicSenhaTokenRequestTO requestTO) {
        usuarioService.updateSenhaByResetToken(requestTO.getToken(), requestTO.getSenha());
    }

    @PostMapping("/recuperacao/senha")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void recoverSenha(@Valid @RequestBody UsuarioPublicEmailRequestTO requestTO) {
        usuarioService.recoverSenha(requestTO.getEmail());
    }

    // TODO implementar método recoverLogin
//    @PostMapping("/recuperacao/login")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void recoverLogin(@Valid @RequestBody UsuarioEmailRequestTO requestTO) {
//        usuarioService.recoverLogin(requestTO.getEmail());
//    }

}
