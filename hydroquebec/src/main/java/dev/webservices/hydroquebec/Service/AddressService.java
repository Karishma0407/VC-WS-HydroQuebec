package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import dev.webservices.addresses.Entity.Address;

public interface AddressService {

    Address save(Address address);

    Optional<Address> findById(Long id);

    void update(Long id);

    void delete(Long id);
}
