package com.de.dhbw.ravensburg.myonlineshopdatabase.RestTests.aufgabe1;

import com.de.dhbw.ravensburg.myonlineshopdatabase.ManualTestBean;
import com.de.dhbw.ravensburg.myonlineshopdatabase.dto.OwnerDTO;
import com.de.dhbw.ravensburg.myonlineshopdatabase.mapper.OwnerMapper;
import com.de.dhbw.ravensburg.myonlineshopdatabase.model.Owner;
import com.de.dhbw.ravensburg.myonlineshopdatabase.repository.CarRepository;
import com.de.dhbw.ravensburg.myonlineshopdatabase.repository.OwnerRepository;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.OwnerService;
import com.de.dhbw.ravensburg.myonlineshopdatabase.service.OwnerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Objects;
import java.util.Optional;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ServiceITTest {

    @Autowired
    private OwnerService ownerService;
    @MockBean
    private OwnerMapper ownerMapper;
    @MockBean
    private OwnerRepository ownerRepository;
    @MockBean
    private CarRepository carRepository;
    @MockBean
    private ManualTestBean manualTestBean;


    /**
     * Testet, ob der Service die Repository aufruft
     */
    @Test
    public void shouldGetEmployeeWhenIdExists(){
        Owner owner = new Owner();
        owner.setName("Hans Peter");
        owner.setAddress("88214 Ravensburg, Germany");
        owner.setId(1L);
        ownerRepository = mock(OwnerRepository.class);
        ownerMapper = mock(OwnerMapper.class);
        ownerService = new OwnerServiceImpl(ownerRepository,carRepository,ownerMapper);

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        when(ownerMapper.ownerDTOToOwner(any())).thenReturn(owner);

        Owner result = ownerMapper.ownerDTOToOwner(ownerService.getOwnerById(1L));

        assert(owner.getId() == result.getId());
        assert(Objects.equals(owner.getName(), result.getName()));
        assert(Objects.equals(owner.getAddress(), result.getAddress()));

        verify(ownerRepository,times(1)).findById(any(Long.class));

    }

    /**
     * Testet, ob der Mapper genutzt wird
     */
    @Test
    public void shouldGetEmployeeWhenIdExistsWithMapper(){
        try {
            Owner owner = new Owner();
            owner.setName("Hans Peter");
            owner.setAddress("88214 Ravensburg, Germany");
            owner.setId(1L);

            OwnerDTO ownerDTO = new OwnerDTO();
            ownerDTO.setId(owner.getId());
            ownerDTO.setName(owner.getName());
            ownerDTO.setAddress(owner.getAddress());

            ownerRepository = mock(OwnerRepository.class);
            ownerMapper = mock(OwnerMapper.class);
            ownerService = new OwnerServiceImpl(ownerRepository,carRepository,ownerMapper);

            when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
            when(ownerMapper.ownerToOwnerDTO(any(Owner.class))).thenReturn(ownerDTO);

            OwnerDTO result = ownerService.getOwnerById(1L);


            assert(ownerDTO.getId() == result.getId());
            assert(Objects.equals(ownerDTO.getName(), result.getName()));
            assert(Objects.equals(ownerDTO.getAddress(), result.getAddress()));

            verify(ownerMapper,times(1)).ownerToOwnerDTO(any());

            assert(1 == result.getId());
            assert("Hans Peter".equals(result.getName()));
            assert("88214 Ravensburg, Germany".equals(result.getAddress()));
        }catch (NullPointerException e){
            fail();
        }
    }


}