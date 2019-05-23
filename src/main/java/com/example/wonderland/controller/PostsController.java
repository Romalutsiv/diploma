package com.example.wonderland.controller;

import com.example.wonderland.domain.DishType;
import com.example.wonderland.domain.Post;
import com.example.wonderland.domain.User;
import com.example.wonderland.repos.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepo postRepo;

    @GetMapping
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model,
                       @PageableDefault(sort = { "id"}, direction = Sort.Direction.DESC) Pageable pageable) {


        Page<Post> posts;

        posts = postRepo.findAll(pageable);

        model.addAttribute("posts", posts);
        model.addAttribute("types", DishType.values());
        model.addAttribute("url", "/posts");

        return "posts";
    }

    @PostMapping
    public String add(
            @AuthenticationPrincipal User user,
            @Valid Post post,
            BindingResult bindingResult,
            Model model
    ) {
        post.setAuthor(user);
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("post", post);
            return "createpost";
        } else {
            postRepo.save(post);
        }

        return "redirect:/posts";
    }

    @GetMapping("{post}")
        public String oneNews(
                @PathVariable Post post,
                Model model
    ){
        model.addAttribute("post", post);
        model.addAttribute("types", DishType.values());
        model.addAttribute("url", "/posts");
        return "post";
    }

    @GetMapping("delete/{post}")
    public String deletePost(
            @PathVariable Post post
    ){
        postRepo.delete(post);
        return "redirect:/posts";
    }

    @GetMapping("edit/{post}")
    public String edit(@PathVariable Post post,
                       Model model){
        model.addAttribute("post", post);
        return "editPost";
    }

    @PostMapping("edit")
    public String editPost(
            @RequestParam String name,
            @RequestParam String text,
            @Valid Post post,
            BindingResult bindingResult,
            Model model
    ){
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("post", post);
            return "editPost";
        }else {
            post.setName(name);
            post.setText(text);
            postRepo.save(post);
        }
        return "redirect:/posts";
    }

}
