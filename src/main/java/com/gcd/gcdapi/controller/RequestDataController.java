package com.gcd.gcdapi.controller;

import com.gcd.gcdapi.mapper.RequestMapper;
import com.gcd.gcdapi.model.RequestData;
import com.gcd.gcdapi.model.dto.RequestDataDto;
import com.gcd.gcdapi.services.RequestDataService;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;


@RestController
@RequestMapping(value = "/api/v1/")
public class RequestDataController {
    private final RequestDataService requestDataService;

    private final RequestMapper requestMapper;

    public RequestDataController(RequestDataService requestDataService) {
        this.requestDataService = requestDataService;
        this.requestMapper = Mappers.getMapper(RequestMapper.class);
    }

    @GetMapping(value = {"/"})
    public ResponseEntity<Set<RequestDataDto>> allRequests() {
        return ResponseEntity.ok(requestMapper.toRequestDataDTOs(requestDataService.findAll()));
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<RequestDataDto> getRequestById(@PathVariable Long id) {
        RequestData requestData = requestDataService.findById(id);
        RequestDataDto requestDataDto = requestMapper.toRequestDataDTO(requestData);
        return new ResponseEntity<>(requestDataDto, HttpStatus.OK);
    }

    @GetMapping(value = {"/get-result/{id}"})
    public RequestData getResultById(@PathVariable Long id) {
        return requestDataService.findById(id);
    }

    @PostMapping(value = {"/calculate-gcd"})
    public ResponseEntity<Long> calculateGcd(@RequestBody RequestDataDto requestDataDto) {
        RequestData requestData = requestMapper.toRequestData(requestDataDto);
        RequestData requestDataToSave = requestDataService.save(requestData);
        return ResponseEntity.status(HttpStatus.CREATED).body(requestDataToSave.getId());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteRequestDataById(@PathVariable Long id) {
        requestDataService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
