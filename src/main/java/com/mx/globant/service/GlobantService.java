package com.mx.globant.service;

import com.mx.globant.Entity.History;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GlobantService {

    public ResponseEntity getAllCharacters();

    public ResponseEntity getCharacterByID(Integer id);

    public List<History> getHistoryDB();

}
