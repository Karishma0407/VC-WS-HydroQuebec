package dev.webservices.hydroquebec.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.webservices.hydroquebec.Entity.PowerOutage;

@Repository
public interface PowerOutageRepository extends CrudRepository<PowerOutage, Long> {

}
