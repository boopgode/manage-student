package com.devmaster.services.managestudent.mapper;

import com.devmaster.services.managestudent.domain.Adress;
import com.devmaster.services.managestudent.dto.AddressDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddressMapper implements EntityMapper<Adress, AddressDto>{

    @Override
    public Adress toEntity(AddressDto addressDto) {
        return null;
    }

    @Override
    public List<Adress> toEntity(List<AddressDto> d) {
        return null;
    }

    @Override
    public AddressDto toDto(Adress adress) {
        return AddressDto
                .builder()
                .city(adress.getCity())
                .district(adress.getDistrict())
                .name(adress.getName())
                .build();
    }

    @Override
    public List<AddressDto> toDto(List<Adress> e) {
        return null;
    }
}
