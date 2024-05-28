package com.mx.globant.service;

import com.marvel.dto.MarvelResponse;
import com.marvel.exception.MarvelException;
import com.marvel.service.MarvelService;
import com.mx.globant.Entity.History;
import com.mx.globant.Util.TypeAction;
import com.mx.globant.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobantServiceImpl implements GlobantService {

    @Autowired
    private MarvelService marvelService;

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public ResponseEntity getAllCharacters() {
        try {
            MarvelResponse marvelResponse = marvelService.getAllCharaters();
            saveRegister(TypeAction.CONSULT, "Consult all characters: " + marvelResponse.getTotal());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marvelResponse);

        } catch (MarvelException ex) {
            Logger.getLogger(GlobantServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            saveRegister(TypeAction.ERROR, "Error to consult the all characters, Error: " + ex.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());

        } catch (Exception err) {
            Logger.getLogger(GlobantServiceImpl.class.getName()).log(Level.SEVERE, null, err);

            saveRegister(TypeAction.ERROR, "Error to consult the all characters, Error-general: " + err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error to get the all Characters, Error: " + err.getMessage());
        }
    }

    @Override
    public ResponseEntity getCharacterByID(Integer id) {

        saveRegister(TypeAction.CONSULT, "Consulta CharacterID: " + id);

        try {

            MarvelResponse charaterById = marvelService.getCharaterById(id.toString());

            saveRegister(TypeAction.CONSULT, "CharacterID: " + charaterById.getTotal());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(charaterById);

        } catch (MarvelException err) {
            Logger.getLogger(GlobantServiceImpl.class.getName()).log(Level.SEVERE, null, err);

            saveRegister(TypeAction.ERROR, "Error to get the Character by ID:" + id + ", Error: " + err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(err.getMessage());

        } catch (Exception err) {
            Logger.getLogger(GlobantServiceImpl.class.getName()).log(Level.SEVERE, null, err.getMessage());

            saveRegister(TypeAction.ERROR, "Error to get the Character by ID:" + id + ", Error: " + err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error to get the Character by ID:" + id + ", Error: " + err.getMessage());
        }

    }

    @Override
    public List<History> getHistoryDB() {
        return historyRepository.findAll();
    }

    @Transactional
    public void saveRegister(TypeAction typeAction, String details) {
        try {
            System.out.println("Save register in DB: H2");

            History historyEntity = new History();
            historyEntity.setAction(typeAction.toString());
            historyEntity.setDetails(details);
            historyEntity.setDate(new Date().toString());

            History save = historyRepository.save(historyEntity);

            System.out.println("Register save successfully: " + save.toString());

        } catch (Exception err) {
            System.err.println("Error to save the register in DB: " + err.getMessage());
        }
    }

}
