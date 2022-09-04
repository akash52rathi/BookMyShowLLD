package com.example.demo;
import com.example.demo.Enum.SeatCategory;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private int seatId;
    private SeatCategory seatCategory;

}
