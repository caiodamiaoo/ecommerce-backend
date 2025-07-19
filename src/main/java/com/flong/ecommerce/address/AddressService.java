package com.flong.ecommerce.address;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public Address findAddressById(Long id) {
        return addressRepository.findById(id).orElse(null);
    }
}
