package git.green.common.controller;

/*
 * project:  common
 * author:   Administrator
 * created:  13/12/2021 4:20 PM
 */


import git.green.common.model.Thread;
import git.green.common.model.ThreadResponse;
import git.green.common.model.User;
import git.green.common.repository.ThreadRepository;
import git.green.common.repository.ThreadResponseRepository;
import git.green.common.repository.UserRepository;
import net.bytebuddy.build.Plugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private ThreadRepository threadRepo;
    @Autowired
    private ThreadResponseRepository threadResponseRepo;
    @Autowired
    private UserRepository userRepository;
    public static User currentUser;

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @GetMapping("/responses")
    public List<ThreadResponse> getResponses(){
        System.out.println("getThreads() was called"  + " printed at " + formatter.format(new Date()));
        List<ThreadResponse> responses = threadResponseRepo.findAll();
        return responses;
    }


    @GetMapping("/threads")
    public List<Thread> getThreads(@RequestParam String category){
        System.out.println("getThreads() was called"  + " printed at " + formatter.format(new Date()));
        if(category.equals("All") || category.isEmpty()){
            return threadRepo.findAll();
        }
        return threadRepo.findByCategory(category);
    }

    @GetMapping("/threads/keyword")
    public List<Thread> getThreadsByKeyword(@RequestParam String keyword){
        System.out.println("getThreads(keyword) was called"  + " printed at " + formatter.format(new Date()));
        return threadRepo.findByContentContaining(keyword);
    }

    @PostMapping("/createthread")
    public Thread createThread(@RequestParam String title, @RequestParam String content, @RequestParam String category){
        System.out.println("thread title: " + title);
        System.out.println("thread content: " + content);
        System.out.println("thread category: " + category);
        Thread thread = new Thread();
        thread.setTitle(title);
        thread.setContent(content);
        thread.setCategory(category);
        thread.setCreatedAt(formatter.format(new Date()));
        currentUser = userRepository.findByUserNameAndPassword("hgd", "hgd");
        thread.setUser(currentUser);
        if(thread.getUser() != null){
            System.out.println("User: " + currentUser.getName() + " at " + thread.getCreatedAt());
        }else {
            System.out.println("No user object!");
        }
        threadRepo.save(thread);
        return thread;
    }


    @PostMapping("/reply")
    public ThreadResponse replyToThread(@RequestParam String threadId, @RequestParam String content){
        ThreadResponse response = new ThreadResponse();
        //System.out.println( + " printed at " + LocalDateTime.now());
        System.out.println("threadId: " + threadId);
        System.out.println("reply content: " + content);
        Thread thread = null;
                Optional<Thread> threadOp = threadRepo.findById(Long.parseLong(threadId));
        if(threadOp.isPresent()){
            thread = threadOp.get();
        }
        response.setThread(thread);
        response.setContent(content);
        response.setCreatedAt(formatter.format(new Date()));
        currentUser = userRepository.findByUserNameAndPassword("hgd", "hgd");
        response.setUser(currentUser);
        if(response.getUser() != null){
            System.out.println("User: " + currentUser.getName() + " at " + response.getCreatedAt());
            threadResponseRepo.save(response);
        }else {
            System.out.println("No user object!");
            threadResponseRepo.save(response);
        }
        return response;
    }

}
