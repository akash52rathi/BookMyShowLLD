package com.example.demo;

import com.example.demo.Enum.SeatStatus;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private int startShowTime;
    private Map<Integer, SeatStatus> SeatStatus;

    public void setSeatStatus(Integer SheatId,SeatStatus seatStatus) {
        SeatStatus.put(SheatId,seatStatus);
    }
}
