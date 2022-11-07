package br.com.alura.comex.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class GenericController {

    protected URI construirURI(UriComponentsBuilder uriBuilder, String path,Long id){
        return uriBuilder.path(path).buildAndExpand(id).toUri();
    }
}
