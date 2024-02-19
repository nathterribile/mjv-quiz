package com.mjv.curso.simplequiz.builder;

import com.mjv.curso.simplequiz.dto.QuestionAlternativeDTO;
import com.mjv.curso.simplequiz.model.QuestionAlternative;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionAlternativeMapper {

    private final ModelMapper modelMapper;

    public QuestionAlternativeMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuestionAlternativeDTO toDTO(QuestionAlternative model) {
        return modelMapper.map(model, QuestionAlternativeDTO.class);
    }

    public QuestionAlternative toEntity(QuestionAlternativeDTO dto) {
        return modelMapper.map(dto, QuestionAlternative.class);
    }

    // Adicionando o método toEntity para List<QuestionAlternativeDTO>
    public List<QuestionAlternative> toEntityList(List<QuestionAlternativeDTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public ArrayList<QuestionAlternativeDTO> toListDTO(List<QuestionAlternative> modelList) {
        return modelList.stream().map(this::toDTO).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<QuestionAlternative> toList(List<QuestionAlternativeDTO> dtosList) {
        return dtosList.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
