package dev.webservices.hydroquebec.Controller;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.hydroquebec.Entity.PowerOutage;
import dev.webservices.hydroquebec.Service.PowerOutageService;

@RestController
@RequestMapping("/power")
public class PowerOutageController {

    @Autowired
    private PowerOutageService powerOutageService;

    @PostMapping("/")
    public ResponseEntity<PowerOutage> save(@RequestBody PowerOutage powerOutage) {
        PowerOutage savedOutage = powerOutageService.save(powerOutage);
        return savedOutage != null
                ? new ResponseEntity<>(savedOutage, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping("/")
    public ResponseEntity<PowerOutage> findById(@RequestParam Long id) {
        // Try to find the PowerOutage by ID
        Optional<PowerOutage> powerOutageOptional = powerOutageService.findById(id);

        // Check if the PowerOutage was found
        return powerOutageOptional.map(
                // If found: Return it with a success status code ACCEPTED
                value -> new ResponseEntity<>(value, HttpStatus.ACCEPTED))
                // If not found: Return a response with a NOT_FOUND status code
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
