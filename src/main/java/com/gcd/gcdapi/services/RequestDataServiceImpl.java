package com.gcd.gcdapi.services;

import com.gcd.gcdapi.model.RequestData;
import com.gcd.gcdapi.repository.RequestDataRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RequestDataServiceImpl implements RequestDataService {

    private RequestDataRepository requestDataRepository;

    public RequestDataServiceImpl(RequestDataRepository requestDataRepository) {
        this.requestDataRepository = requestDataRepository;
    }

    @Override
    public Set<RequestData> findAll() {
        Set<RequestData> requestDataSet = new HashSet<>();
        requestDataRepository.findAll().forEach(requestDataSet::add);
        return requestDataSet;
    }

    @Override
    public RequestData findById(Long id) {
        return requestDataRepository.findById(id).orElse(null);
    }

    @Override
    public RequestData save(RequestData requestData) {
        return requestDataRepository.save(requestData);
    }

    @Override
    public void delete(RequestData requestData) {
        requestDataRepository.delete(requestData);
    }

    @Override
    public void deleteById(Long id) {
        requestDataRepository.deleteById(id);
    }
}
