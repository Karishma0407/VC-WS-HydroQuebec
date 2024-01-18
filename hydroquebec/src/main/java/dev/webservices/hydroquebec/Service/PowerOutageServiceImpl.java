package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.hydroquebec.Entity.PowerOutage;
import dev.webservices.hydroquebec.Repository.PowerOutageRepository;

@Service
public class PowerOutageServiceImpl implements PowerOutageService {

    @Autowired
    private PowerOutageRepository powerOutageRepository;

    @Override
    public PowerOutage save(PowerOutage powerOutage) {

        return powerOutageRepository.save(powerOutage);
    }

    @Override
    public Optional<PowerOutage> findById(Long id) {

        return powerOutageRepository.findById(id);
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

}
