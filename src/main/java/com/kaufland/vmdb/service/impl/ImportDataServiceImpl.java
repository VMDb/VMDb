package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Service // add interface
public class ImportDataServiceImpl {

    private CommentService commentService;

    private RestTemplate restTemplate; // configure


    public ImportDataServiceImpl(CommentService commentService) {
        this.commentService = commentService;
    }

    public void fromJSON() {
        // TODO: ....
    }


}

@RestController
@RequestMapping("/import")
class ImportController {

    private ImportDataServiceImpl importDataService;

    public ImportController(ImportDataServiceImpl importDataService) {
        this.importDataService = importDataService;
    }

    @PostMapping("/omdb")
    public void importFromOMDB(){
        this.importDataService.fromJSON();

    }

}
