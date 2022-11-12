package com.greecode.IndependentBand.services;

import com.greecode.IndependentBand.models.Music;
import com.greecode.IndependentBand.models.User;
import com.greecode.IndependentBand.repositories.MusicRepository;
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
public class MusicService {

    private final MusicRepository musicRepository;

    // Listar todos as musicas
    public List<Music> getMusics() {
        log.info( "Lista todas musicas" );
        return musicRepository.findAll();
    }
    // Listar um usuário
    public Optional<Music> getMusicById(Long id) {
        log.info( "Lista musica por id {}", id );
        return musicRepository.findById(id);
    }
    // Salvar usuário
    public Music saveMusic(@RequestBody Music music) {
        log.info( "Musica {}", music.getNameMusic(), " salva com sucesso!" );
        if(music != null){
            return musicRepository.save(music);
        }
        return null;
    }
    // Deleta usuário
    public Boolean deleteMusic(Long id) {
        log.info( "Deleta musica por id ", id );
        musicRepository.deleteById(id);
        return true;
    }

    // Atualiza usuário
    public Optional<Music> updateMusic(Long id, Music music) {
        log.info( "Musica {} ", music.getNameMusic(), " Atualizada com sucesso!" );
        return musicRepository.findById(id).map(
                record -> {
                    record.setNameMusic(music.getNameMusic());
                    record.setDescription(music.getDescription());
                    record.setLyric(music.getLyric());
                    record.setReleaseDate(music.getReleaseDate());
                    Music musicUpdated = musicRepository.save(record);
                    return musicUpdated;
                }
        );
    }
}
