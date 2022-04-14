package br.com.coutomariel.objectmapper.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CarDto {

    private String id;
    private String model;
    private String color;

}

