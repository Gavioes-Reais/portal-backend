package com.portal.estudante.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public MatterDto create(MatterDto matterDTO) {
        Matter matter = convertToEntity(matterDTO);
        Matter savedMatter = repository.save(matter);
        return savedMatter.convertDTO();
    }

    public MatterDto getById(Long id) {
		Optional<Matter> obj = repository.findById(id);
		return obj.orElseThrow().convertDTO();
    }

    public List<MatterDto> getAllMatters() {
        List<Matter> allMatters = repository.findAll();
        return allMatters.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public MatterDto updateMatter(MatterDto updatedMatterDto) {
        return repository.findById(updatedMatterDto.id())
                .map(existingMatter -> {
                    updateEntity(existingMatter, updatedMatterDto);
                    Matter savedMatter = repository.saveAndFlush(existingMatter);
                    return convertToDto(savedMatter);
                })
                .orElse(null);
    }

    private Matter convertToEntity(MatterDto matterDTO) {
        Matter matter = new Matter();
        matter.setName(matterDTO.name());
        matter.setSeries(matterDTO.series());
        matter.setImg_url(matterDTO.img_url());
        return matter;
    }

    private MatterDto convertToDto(Matter matter) {
        return new MatterDto(
            matter.getId(),
            matter.getName(),
            matter.getSeries(),
            matter.getImg_url()
        );
    }

    private void updateEntity(Matter existingMatter, MatterDto updatedMatterDto) {
        existingMatter.setName(updatedMatterDto.name());
        existingMatter.setSeries(updatedMatterDto.series());
        existingMatter.setImg_url(updatedMatterDto.img_url());
    }
    
}
