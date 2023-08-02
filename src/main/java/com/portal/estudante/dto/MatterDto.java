package com.portal.estudante.dto;

import com.portal.estudante.entity.Matter;

public record MatterDto(Long id, String name, String series, String img_url) {
    public Matter toEntity() {
        Matter matter = new Matter();
        matter.setId(this.id());
        matter.setName(this.name());
        matter.setSeries(this.series());
        matter.setImg_url(this.img_url());
        return matter;
    }
}

