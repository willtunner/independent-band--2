package com.greecode.IndependentBand.services;

import com.greecode.IndependentBand.models.Band;
import com.greecode.IndependentBand.models.Disc;
import com.greecode.IndependentBand.models.User;
import com.greecode.IndependentBand.repositories.BandRepository;
import com.greecode.IndependentBand.repositories.DiscRepository;
import com.greecode.IndependentBand.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class DiscService {

    private final DiscRepository discRepository;
    private final BandRepository bandRepository;

    // Listar todos os discos
    public List<Disc> getDiscs() {
        log.info( "Lista todos os discos" );
        return discRepository.findAll();
    }
    // Listar um disco
    public Optional<Disc> getDiscById(Long id) {
        log.info( "Lista disco por id {}", id );
        return discRepository.findById(id);
    }
    // Salvar disco
    public Disc saveDisc(@RequestBody Disc disc, Long bandId) {
        log.info( "Disc {}", disc.getName() + " salvo com sucesso!" );
        Band band = bandRepository.findById(bandId).orElse(null);
        if(disc != null){
            disc.setBand(band);
            return discRepository.save(disc);
        }
        return null;
    }
}
