package com.riwi.library.api.dto.request;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {
     @NotNull(message = "Return date is required")
    @FutureOrPresent(message = "It is not possible to enter a date later than the current date.")
    private LocalDate returnDate;

    @NotBlank(message = "Status must not be null")
    @Size(
            max = 20,
            message = "Status cannot be longer than 20 characters."
    )
    private String status;

    @NotNull(message = "User id is required")
    @Min(value = 1, message = "User id must be greater than 0")
    private Long userId;

    @NotNull(message = "Book id is required")
    @Min(value = 1, message = "Book id must be greater than 0")
    private Long bookId;
}
