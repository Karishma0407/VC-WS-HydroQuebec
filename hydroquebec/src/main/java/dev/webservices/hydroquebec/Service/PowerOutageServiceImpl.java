package dev.webservices.hydroquebec.Service;

import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.webservices.employeelib.Entity.Employee;
import dev.webservices.hydroquebec.Entity.PowerOutage;
import dev.webservices.hydroquebec.Repository.PowerOutageRepository;

@Service
public class PowerOutageServiceImpl implements PowerOutageService {

    @Autowired
    private PowerOutageRepository powerOutageRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public PowerOutage save(PowerOutage powerOutage) {

        // // save associated Employee entities
        // if (powerOutage.getEmployee() != null) {
        // powerOutage.getEmployee().forEach(employeeService::save);
        // }
        return powerOutageRepository.save(powerOutage);
    }

    @Override
    public Optional<PowerOutage> findById(Long id) {
        return powerOutageRepository.findById(id);
    }

    @Override
    public void update(Long id) {
        Optional<PowerOutage> powerOutage = powerOutageRepository.findById(id);
        powerOutage.ifPresent(value -> powerOutageRepository.save(value));
    }

    @Override
    public void delete(Long id) {
        Optional<PowerOutage> powerOutage = powerOutageRepository.findById(id);
        powerOutage.ifPresent(value -> powerOutageRepository.delete(value));
    }

}
