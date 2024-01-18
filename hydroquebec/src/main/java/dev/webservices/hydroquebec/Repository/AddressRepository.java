package dev.webservices.hydroquebec.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.addresses.Entity.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {

}
