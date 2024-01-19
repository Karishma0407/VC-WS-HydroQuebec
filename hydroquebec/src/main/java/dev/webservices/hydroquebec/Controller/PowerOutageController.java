package dev.webservices.hydroquebec.Controller;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.webservices.hydroquebec.Entity.PowerOutage;
import dev.webservices.hydroquebec.Service.PowerOutageService;

@RestController
@RequestMapping("/powerOutage")
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
    public ResponseEntity<PowerOutage> getPowerOutageById(@RequestParam Long id) {

        // Check if the PowerOutage was found
        return powerOutageService.findById(id).map(
                // If found: Return it with a success status code ACCEPTED
                value -> new ResponseEntity<>(value, HttpStatus.OK))
                // If not found: Return a response with a NOT_FOUND status code
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/")
    public ResponseEntity<PowerOutage> delete(@RequestParam Long id) {

        if (powerOutageService.findById(id).isPresent()) {
            powerOutageService.delete(id);
            return new ResponseEntity<>(powerOutageService.findById(id).get(), HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }

    }

}
