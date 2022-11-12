package com.greecode.IndependentBand.services;

import com.greecode.IndependentBand.models.Band;
import com.greecode.IndependentBand.models.User;
import com.greecode.IndependentBand.repositories.BandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    // Listar todas as bandas
    public List<Band> getBands() {
        return bandRepository.findAll();
    }
    // Listar uma banda
    public Optional<Band> getBandById(Long id) {
        return bandRepository.findById(id);
    }
    // Salvar banda
    public Band saveBand(@RequestBody Band band) {
        if(band != null){
            return bandRepository.save(band);
        }
        return null;
    }

    public Boolean deleteBand(Long id) {
        log.info( "Deleta banda por id ", id );
        bandRepository.deleteById(id);
        return true;
    }

    // Atualiza usuário
    public Optional<Band> updateBand(Long id, Band band) {
        log.info( "Banda {} ", band.getName(), " Atualizada com sucesso!" );
        return bandRepository.findById(id).map(
                record -> {
                    record.setName(band.getName());
                    record.setGenre(band.getGenre());
                    record.setLike(band.getLike());
                    record.setDislike(band.getDislike());
                    Band bandUpdated = bandRepository.save(record);
                    return bandUpdated;
                }
        );
    }
}
