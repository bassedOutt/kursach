package com.polytech.kursova.controller;

import com.polytech.kursova.dto.CaseDto;
import com.polytech.kursova.dto.CommentDto;
import com.polytech.kursova.dto.mapper.EntityMapper;
import com.polytech.kursova.entity.CaseId;
import com.polytech.kursova.entity.Comment;
import com.polytech.kursova.repository.CaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/case")
@RequiredArgsConstructor
public class CasesController {

    private final CaseRepository repository;

    private static final EntityMapper mapper = EntityMapper.INSTANCE;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CaseDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toCaseDto)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public CaseDto findById(@PathVariable CaseId id) {
        return mapper.toCaseDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer with id " + id + " not found")));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CaseDto save(CaseDto entity) {
        return mapper.toCaseDto(repository.save(mapper.fromCaseDto(entity)));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public CaseDto update(CaseDto entity) {
        return mapper.toCaseDto(repository.save(mapper.fromCaseDto(entity)));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(CaseDto caseDto) {
        repository.delete(mapper.fromCaseDto(caseDto));
    }
}
