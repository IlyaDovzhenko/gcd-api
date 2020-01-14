package com.gcd.gcdapi.model.dto;

import com.gcd.gcdapi.model.RequestData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RequestDataDto {
    private Long id;
    private Long firstNumber;
    private Long secondNumber;

    public RequestDataDto(RequestData requestData) {
        this.id = requestData.getId();
        this.firstNumber = requestData.getFirstNumber();
        this.secondNumber = requestData.getSecondNumber();
    }
}
