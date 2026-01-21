package com.vancura.cz.vystavovac;

import com.vancura.cz.vystavovac.model.Posuzovatel;
import com.vancura.cz.vystavovac.repository.PosuzovatelRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PosuzovatelTest {
    @Test
    void mockoPosuzovatel(){
        PosuzovatelRepository posuzovatelRepository = mock(PosuzovatelRepository.class);

        when(posuzovatelRepository.findById(6L)).thenReturn(Optional.of(new Posuzovatel(6L)));

        Optional<Posuzovatel> posuzovatel = posuzovatelRepository.findById(6L);

        assertEquals(6L,posuzovatel.get().getId());
    }
}
