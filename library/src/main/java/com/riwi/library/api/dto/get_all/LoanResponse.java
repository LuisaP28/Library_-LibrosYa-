package com.riwi.library.api.dto.get_all;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class LoanResponse {
    private Long id;

    private LocalDate loanDate;

    private LocalDate returnDate;

    private String status;
}
