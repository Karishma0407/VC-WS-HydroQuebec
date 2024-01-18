package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import dev.webservices.hydroquebec.Entity.PowerOutage;

public interface PowerOutageService {

    PowerOutage save(PowerOutage powerOutage);

    Optional<PowerOutage> findById(Long id);

    void update(Long id);

    void delete(Long id);

}
