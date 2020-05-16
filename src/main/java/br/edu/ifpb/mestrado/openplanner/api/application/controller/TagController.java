package br.edu.ifpb.mestrado.openplanner.api.application.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.mestrado.openplanner.api.domain.model.tag.Tag;
import br.edu.ifpb.mestrado.openplanner.api.domain.service.TagService;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.facade.ModelMapperFacade;
import br.edu.ifpb.mestrado.openplanner.api.infrastructure.persistence.hibernate.specification.SpecificationFactory;
import br.edu.ifpb.mestrado.openplanner.api.presentation.dto.tag.TagFilterRequestTO;
import br.edu.ifpb.mestrado.openplanner.api.presentation.dto.tag.TagResponseTO;

@RestController
@RequestMapping("/tags")
public class TagController {

    private TagService tagService;

    private ModelMapperFacade modelMapperFacade;

    public TagController(TagService tagService, ModelMapperFacade modelMapperFacade) {
        super();
        this.tagService = tagService;
        this.modelMapperFacade = modelMapperFacade;
    }

    @GetMapping
    public ResponseEntity<Page<TagResponseTO>> findAll(TagFilterRequestTO tagFilterRequestTO, Pageable pageable) {
        Specification<Tag> specification = new SpecificationFactory<Tag>().create(tagFilterRequestTO, Tag.class);
        Page<Tag> page = tagService.findAll(specification, pageable);
        Page<TagResponseTO> responseTOPage = modelMapperFacade.map(page, TagResponseTO.class);

        return ResponseEntity.ok(responseTOPage);
    }

}
