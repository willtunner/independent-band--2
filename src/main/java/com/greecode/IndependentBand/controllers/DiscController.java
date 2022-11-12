package com.greecode.IndependentBand.controllers;

import com.greecode.IndependentBand.models.Disc;
import com.greecode.IndependentBand.models.User;
import com.greecode.IndependentBand.models.response.Response;
import com.greecode.IndependentBand.repositories.BandRepository;
import com.greecode.IndependentBand.services.DiscService;
import com.greecode.IndependentBand.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/disc")
@CrossOrigin // Pode receber anotações de diversos fontes no front vai ser a porta 4200
@RequiredArgsConstructor
public class DiscController {

    private final DiscService discService;

    // Busca todos os usuários
    @GetMapping("/discs")
    public ResponseEntity<Response> getDiscs() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("discos", discService.getDiscs()))
                        .message("Discos recuperados")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save-disc/band/{id}")
    public ResponseEntity<Response> saveUser(@RequestBody Disc disc, @PathVariable("id") Long bandId) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("disc", discService.saveDisc(disc, bandId)))
                        .message("Disco criado")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
