package com.restaurant.dtos;

import com.restaurant.enums.ReservationStatus;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
@RequiredArgsConstructor
public class ReservationDto {

    private Long id;

    private String tableType;

    private String description;

    private Date dateTime;

    private ReservationStatus reservationStatus;

    private Long customerId;

    private String customerName;

}
