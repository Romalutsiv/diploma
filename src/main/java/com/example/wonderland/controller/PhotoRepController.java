package com.example.wonderland.controller;

import com.example.wonderland.domain.PhotoReport;
import com.example.wonderland.repos.PhotoRepo;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/report")
public class PhotoRepController {
    @Autowired
    PhotoRepo photoRepo;
    @Value("${upload.path}")
    private String uploadpath;


    @GetMapping
    public String main(Model model,
                       @PageableDefault(sort = { "id"}, direction = Sort.Direction.DESC)Pageable pageable){
        Page<PhotoReport> reports;
        reports = photoRepo.findAll(pageable);

        model.addAttribute("reports", reports);
        model.addAttribute("url", "/report");
        return "photoReport";
    }


    @PostMapping
    public String add(
            @RequestParam("file") MultipartFile[] file,
            @Valid PhotoReport report,
            BindingResult bindingResult,
            Model model
    ) throws IOException, SQLException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorsMap = ControllerUtil.getErrors(bindingResult);

            model.mergeAttributes(errorsMap);
            model.addAttribute("report", report);
            return "createphotorep";
        } else {
            String[] str = new String[file.length];
            String files = "";
            for (int i = 0; i < file.length; i++) {


                if (file[i] != null) {
                    File uploadDir = new File(uploadpath);

                    if (!uploadDir.exists()) {
                        uploadDir.mkdir();
                    }
                    String uuidFile = UUID.randomUUID().toString();
                    String resultFileName = uuidFile + "." + file[i].getOriginalFilename();

                    file[i].transferTo(new File(uploadpath + "/" + resultFileName));
                    str[i] = resultFileName;
                }

            }


            for (int j = 0; j < str.length; j++) {
                files += str[j] + "|";
            }
            report.setFilenames(files);
        }
            photoRepo.save(report);


            return "redirect:/report";

    }

    @GetMapping("{report}")
    public String oneNews(
            @PathVariable PhotoReport report,
            Model model
    ){
        model.addAttribute("report", report);
        return "oneReport";
    }

    @GetMapping("delete/{report}")
    public String deletePost(
            @PathVariable PhotoReport report
    ){
        photoRepo.delete(report);
        return "redirect:/report";
    }

    @GetMapping("deletephoto")
    public String deletePhoto(
            @RequestParam(name="report", required = false) Long id,
            @RequestParam(name="filename", required = false) String filename,
            Model model
    ){
        File f = new File(uploadpath + "/" + filename);
        f.delete();
        Optional<PhotoReport> report = photoRepo.findById(id);
        String filesstr = report.get().getFilenames();
        String[] files = filesstr.split("\\|");
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i]);
        }
        list.remove(filename);
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result += list.get(i) + "|";
        }

        report.get().setFilenames(result);

        photoRepo.save(report.get());
        model.addAttribute("report", report.get());
        return "oneReport";
    }

    @GetMapping("edit/{report}")
    public String edit(@PathVariable PhotoReport report,
                       Model model){
        model.addAttribute("report", report);
        return "editReport";
    }

    @PostMapping("edit")
    public String update(@RequestParam String name,
                         @RequestParam("file") MultipartFile[] file,
                         @RequestParam PhotoReport report) throws IOException {

        String[] str = new String[file.length];
        String files = "";
        for (int i = 0; i < file.length; i++) {


            if (file[i] != null) {
                File uploadDir = new File(uploadpath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdir();
                }
                String uuidFile = UUID.randomUUID().toString();
                String resultFileName = uuidFile + "." + file[i].getOriginalFilename();

                file[i].transferTo(new File(uploadpath +"/" + resultFileName));
                str[i] = resultFileName;
            }

        }

        files = report.getFilenames();


        for (int j = 0; j < str.length; j++) {
            files += str[j] + "|";}

        report.setFilenames(files);
        report.setName(name);

        photoRepo.save(report);


        return "redirect:/report";
    }



}
