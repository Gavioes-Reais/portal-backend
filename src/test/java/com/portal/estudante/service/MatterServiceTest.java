package com.portal.estudante.service;

import com.portal.estudante.dto.MatterDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatterServiceTest {

    @Rule
    public ErrorCollector error = new ErrorCollector();

    MatterService service = new MatterService();
    @Test
    public void validateMatterNameNulo(){

        MatterDto matterDto = new MatterDto(
                1l,
                null,
                "1",
                "https://localhost:5050/teste"

        );

        try{
            service.validateMatter(matterDto);
        } catch (Exception e){
            assertThat(e.getMessage(), is("Campo 'name' é obrigatório"));
        }
    }

    @Test
    public void validateMatterSeriesNulo(){

        MatterDto matterDto = new MatterDto(
                1l,
                "Desenvolvimento web",
                null,
                "https://localhost:5050/teste"

        );

        try{
            service.validateMatter(matterDto);
        } catch (Exception e){
            assertThat(e.getMessage(), is("Campo 'series' é obrigatório"));
        }
    }

    @Test
    public void validateMatterImgNulo(){

        MatterDto matterDto = new MatterDto(
                1l,
                "Desenvolvimento web",
                "1",
                null

        );

        try{
            service.validateMatter(matterDto);
        } catch (Exception e){
            assertThat(e.getMessage(), is("Campo 'image-url' é obrigatório"));
        }
    }

}