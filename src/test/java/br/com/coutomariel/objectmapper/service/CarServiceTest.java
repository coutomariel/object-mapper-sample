package br.com.coutomariel.objectmapper.service;

import br.com.coutomariel.objectmapper.dto.CarDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Test
    public void givenJavaObjectReturnJson() throws JsonProcessingException {
        CarDto carDto = CarDto.builder()
                .id(UUID.randomUUID().toString())
                .model("Palio")
                .color("Prata")
                .build();

        String json = carService.javaToJson(carDto);
        assertThat(json, containsString("Palio"));
    }

    @Test
    public void givenJsonReturnJavaObject() throws JsonProcessingException {
        String json = "{\"id\":\"38231c8b-5c18-45d3-8492-b67cadcc6ada\",\"model\":\"pegeout 207\",\"color\":\"prata\"}";
        var carDTO = carService.jsonToJava(json);
        assertThat(carDTO.getColor(), equalTo("prata"));
    }

    @Test
    public void givenJsonVerifyModel() throws JsonProcessingException {
        String json = "{\"id\":\"38231c8b-5c18-45d3-8492-b67cadcc6ada\",\"model\":\"pegeout 207\",\"color\":\"red\"}";
        var carDTO = carService.jsonNode(json);
        assertThat(carDTO, equalTo("pegeout 207"));
    }

}