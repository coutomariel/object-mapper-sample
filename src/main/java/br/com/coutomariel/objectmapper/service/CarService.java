package br.com.coutomariel.objectmapper.service;

import br.com.coutomariel.objectmapper.dto.CarDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String javaToJson(CarDto carDto) throws JsonProcessingException {
        return objectMapper.writeValueAsString(carDto);
    }

    public CarDto jsonToJava(String json) throws JsonProcessingException {
        return objectMapper.readValue(json, CarDto.class);
    }

    public String jsonNode(String json) throws JsonProcessingException {
        JsonNode jsonNode = objectMapper.readTree(json);
        return jsonNode.get("model").asText();
    }
}
