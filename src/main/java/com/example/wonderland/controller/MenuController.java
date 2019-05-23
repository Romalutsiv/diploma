package com.example.wonderland.controller;

import com.example.wonderland.domain.Dish;
import com.example.wonderland.domain.DishType;
import com.example.wonderland.repos.DishRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    DishRepo dishRepo;
    @Value("${upload.path}")
    private String uploadpath;


    @GetMapping
    public String main(Model model, @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable){
        Page<Dish> dishes = dishRepo.findAll(pageable);
        model.addAttribute("dishes", dishes);
        model.addAttribute("url", "/menu");
        model.addAttribute("types", DishType.values());
        return "menuList";
    }

    @PostMapping()
    public String add(
            @RequestParam("file") MultipartFile file,
            @RequestParam String type,
            @Valid Dish dish,
            BindingResult bindingResult,
            Model model,
            Pageable pageable
    ) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("dish", dish);
            return "createdish";
        } else {
            if (file != null) {
                File uploadDir = new File(uploadpath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }

                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file.getOriginalFilename();

                file.transferTo(new File(uploadpath + "/" + resultFileName));
                dish.setFilename(resultFileName);
                dish.setDishType(DishType.valueOf(type));
                int in = dish.getDishType().ordinal();
                String str = dish.getDishType().toString(in);
                dish.setDishTypeStr(str);
            }
        }

        dishRepo.save(dish);
        Page<Dish> dishes = dishRepo.findAll(pageable);
        model.addAttribute("dishes", dishes);
        model.addAttribute("url", "/menu");
        model.addAttribute("types", DishType.values());
        return "menuList";
    }

    @GetMapping("{dishtype}")
    public String menuByType(
            @PathVariable("dishtype") String dishtype,
            Model model,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable
    ){
        Page<Dish> dishes = dishRepo.findByDishType(DishType.valueOf(dishtype), pageable);
        model.addAttribute("dishes", dishes);
        model.addAttribute("url", "/menu/{dishtype}");
        model.addAttribute("types", DishType.values());

        return "menuList";
    }

    @GetMapping("show/{dish}")
    public String oneNews(
            @PathVariable Dish dish,
            Model model
    ){
        model.addAttribute("dish", dish);
        return "dish";
    }

    @GetMapping("delete/{dish}")
    public String deletePost(
            @PathVariable Dish dish
    ){
        dishRepo.delete(dish);
        return "redirect:/menu";
    }

    @GetMapping("edit/{dish}")
    public String edit(@PathVariable Dish dish,
                       Model model){
        model.addAttribute("dish", dish);
        return "editDish";
    }

    @PostMapping("edit")
    public String editDish(
            @RequestParam String text,
            @RequestParam String name,
            @RequestParam("file") MultipartFile file,
            @RequestParam String weight,
            @RequestParam String price,
            @RequestParam String type,
            @RequestParam Dish dish
    ) throws IOException {
        dish.setName(name);
        dish.setText(text);
        dish.setDishType(DishType.valueOf(type));
        dish.setDishTypeStr(type);
        dish.setPrice(price);
        dish.setWeight(weight);

        if(file != null){
            File uploadDir = new File(uploadpath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadpath +"/" + resultFileName));
            dish.setFilename(resultFileName);
        }

        dishRepo.save(dish);

        return "redirect:/menu";
    }

}
