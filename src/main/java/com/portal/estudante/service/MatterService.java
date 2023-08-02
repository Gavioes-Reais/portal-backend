package com.portal.estudante.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.estudante.dto.MatterDto;
import com.portal.estudante.entity.Matter;
import com.portal.estudante.repository.MatterRepository;

@Service
public class MatterService {

    @Autowired
    MatterRepository repository;

    public void validateMatter(MatterDto matterDto) throws Exception{

        if(matterDto.name() == null)
            throw new Exception("Campo 'name' é obrigatório");

        if(matterDto.series() == null)
            throw new Exception("Campo 'series' é obrigatório");

        if(matterDto.img_url() == null)
            throw new Exception("Campo 'image-url' é obrigatório");

    }

    public MatterDto findById(Long id) {
		Optional<Matter> obj = repository.findById(id);
		return obj.orElseThrow().convertDTO();
    }

    public MatterDto create(MatterDto matterDTO) {
        Matter matter = convertToEntity(matterDTO);
        Matter savedMatter = repository.save(matter);
        return savedMatter.convertDTO();
    }

    private Matter convertToEntity(MatterDto matterDTO) {
        Matter matter = new Matter();
        matter.setName(matterDTO.name());
        matter.setSeries(matterDTO.series());
        matter.setImg_url(matterDTO.img_url());
        return matter;
    }
    
}
