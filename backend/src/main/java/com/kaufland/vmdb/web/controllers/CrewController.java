package com.kaufland.vmdb.web.controllers;

import com.kaufland.vmdb.dto.HumanModel;
import com.kaufland.vmdb.service.ActorService;
import com.kaufland.vmdb.service.DirectorService;
import com.kaufland.vmdb.service.ProducerService;
import com.kaufland.vmdb.service.WriterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Vladimir Ivanov
 * @date: 26/02/2019
 * File Purpose:
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CrewController {

    private final ActorService actorService;
    private final WriterService writerService;
    private final DirectorService directorService;
    private final ProducerService producerService;

    public CrewController(ActorService actorService, WriterService writerService, DirectorService directorService, ProducerService producerService) {
        this.actorService = actorService;
        this.writerService = writerService;
        this.directorService = directorService;
        this.producerService = producerService;
    }


    @RequestMapping(value = "/crew",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<HumanModel>> getCrew(@RequestParam("role") String role){
        if(role.equalsIgnoreCase("actor")){
            return ResponseEntity.ok(actorService.findAllDTO());
        }else if(role.equalsIgnoreCase("director")){
            return ResponseEntity.ok(directorService.findAllDTO());
        }else if(role.equalsIgnoreCase("writer")){
            return ResponseEntity.ok(writerService.findAllDTO());
        }else if(role.equalsIgnoreCase("producer")){
            return ResponseEntity.ok(producerService.findAllDTO());
        }else{
            return ResponseEntity.status(500).build();
        }
    }

}
