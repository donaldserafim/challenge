package com.texoit.challenge.controller;


import com.texoit.challenge.ReadFileUtils;
import com.texoit.challenge.dto.Award;
import com.texoit.challenge.dto.Winner;
import com.texoit.challenge.service.AwardsManagerService;
import com.texoit.challenge.service.LoadMovieService;
import com.texoit.challenge.service.MovieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AwardController.class)
public class AwardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AwardsManagerService awardsManagerService;

    @MockBean
    private MovieService movieService;

    @MockBean
    private LoadMovieService loadMovieService;

    @Test
    public void shouldReturnWinners() throws Exception {

        Winner winnerMax = new Winner();
        winnerMax.setPreviousWin(2002);
        winnerMax.setFollowingWin(2015);
        winnerMax.setInterval(13);
        winnerMax.setProducer("Matthew Vaughn");

        Winner winnerMin = new Winner();
        winnerMin.setPreviousWin(1990);
        winnerMin.setFollowingWin(1991);
        winnerMin.setInterval(1);
        winnerMin.setProducer("Joel Silver");

        Award award = new Award();
        award.setMin(Arrays.asList(winnerMin));
        award.setMax(Arrays.asList(winnerMax));

        when(awardsManagerService.getWinners()).thenReturn(award);
        mockMvc.perform(get("/award/winners")).andExpect(status().isOk())
                .andExpect(content().json(ReadFileUtils.readFileAndReturnLines("contracts/award.json")));
    }

    @Test
    public void shouldCallWrong() throws Exception {

        Winner winnerMax = new Winner();
        winnerMax.setPreviousWin(2002);
        winnerMax.setFollowingWin(2015);
        winnerMax.setInterval(13);
        winnerMax.setProducer("Matthew Vaughn");

        Winner winnerMin = new Winner();
        winnerMin.setPreviousWin(1990);
        winnerMin.setFollowingWin(1991);
        winnerMin.setInterval(1);
        winnerMin.setProducer("Joel Silver");

        Award award = new Award();
        award.setMin(Arrays.asList(winnerMin));
        award.setMax(Arrays.asList(winnerMax));

        when(awardsManagerService.getWinners()).thenReturn(award);
        mockMvc.perform(get("/award/winnerss")).andExpect(status().is4xxClientError());
    }
}
