package com.example.demo;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Theatre {
    private int theatreId;
    private String address;
    private City city;
    private List<Screen> screenList;
    private List<Show> ShowList;

    public Show getShowById(int showId)
    {
        for(Show show:ShowList)
        {
            if(show.getShowId()==showId)
                return show;
        }
        return null;
    }

}
