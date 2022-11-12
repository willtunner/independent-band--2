package com.greecode.IndependentBand.controllers;

import com.greecode.IndependentBand.models.Band;
import com.greecode.IndependentBand.models.response.Response;
import com.greecode.IndependentBand.services.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/band")
@CrossOrigin // Pode receber anotações de diversos fontes no front vai ser a porta 4200
@RequiredArgsConstructor
public class BandController {

    private  final BandService bandService;

    // Busca todos os usuários
    @GetMapping("/bands")
    public ResponseEntity<Response> getUsers() throws InterruptedException {
        //TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("bands", bandService.getBands()))
                        .message("Bandas recuperadas")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save-band")
    public ResponseEntity<Response> saveUser(@RequestBody Band band) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("band", bandService.saveBand(band)))
                        .message("Banda criada")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("deleted: ", bandService.deleteBand(id)))
                        .message("Banda deletada!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping("/band-by-id/{id}")
    public ResponseEntity<Response> findBandById(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("listado: ", bandService.getBandById(id)))
                        .message("Banda listada!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable("id") Long id, @RequestBody Band band) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("update: ", bandService.updateBand(id, band)))
                        .message("Banda atualizada!")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

}
