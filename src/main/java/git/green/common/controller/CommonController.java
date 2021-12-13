package git.green.common.controller;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:20 PM
 */


import git.green.common.model.Thread;
import git.green.common.model.ThreadResponse;
import git.green.common.repository.ThreadRepository;
import git.green.common.repository.ThreadResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ThreadRepository threadRepo;
    @Autowired
    private ThreadResponseRepository threadResponseRepo;

    @GetMapping("/responses")
    public List<ThreadResponse> getResponses(){
        return threadResponseRepo.findAll();
    }


    @GetMapping("/threads")
    public List<Thread> getThreads(){
        return threadRepo.findAll();
    }

}
