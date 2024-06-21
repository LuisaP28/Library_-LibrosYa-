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
public class ReservationResponse{
    private Long id;

    private LocalDate reservationDate;

    private String status;
}
