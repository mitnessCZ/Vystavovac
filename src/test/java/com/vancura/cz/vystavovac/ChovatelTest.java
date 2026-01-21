package com.vancura.cz.vystavovac;

import com.vancura.cz.vystavovac.model.Chovatel;
import com.vancura.cz.vystavovac.repository.ChovatelRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChovatelTest {
    @Test
    void mockoChovatel(){
        ChovatelRepository chovatelRepository = mock(ChovatelRepository.class);
        Chovatel chovatel = new Chovatel();
        chovatel.setId(3L);
        when(chovatelRepository.findById(3L)).thenReturn(Optional.of(new Chovatel()));
        Optional<Chovatel> result = chovatelRepository.findById(3L);
        assertEquals(3L,chovatel.getId());
    }
}
