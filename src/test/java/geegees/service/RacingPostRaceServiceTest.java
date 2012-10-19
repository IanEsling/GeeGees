package geegees.service;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RacingPostRaceServiceTest {


    RacingPostRaceService racingPostRaceService = new RacingPostRaceService();

    @Test
    public void getRaces() {
        assertTrue("no races", racingPostRaceService.getRaces().size() > 0);
    }
}
