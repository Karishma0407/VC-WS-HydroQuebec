package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.addresses.Entity.Address;
import dev.webservices.employeelib.Entity.Employee;
import dev.webservices.hydroquebec.Repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<Address> addressId = addressRepository.findById(id);
        addressId.ifPresent(value -> addressRepository.save(value));
    }

    @Override
    public void delete(Long id) {
        Optional<Address> addressId = addressRepository.findById(id);
        addressId.ifPresent(value -> addressRepository.delete(value));
    }
}
