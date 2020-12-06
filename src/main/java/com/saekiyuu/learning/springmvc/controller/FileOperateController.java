package com.saekiyuu.learning.springmvc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileOperateController {

    @RequestMapping(value = "/upload-page")
    public String uploadPage() {
        return "upload";
    }

    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request, @RequestParam MultipartFile file)
            throws IllegalStateException, IOException {
        if (file.isEmpty()) {
            return "upload-failure";
        } else {
            String path = request.getServletContext().getRealPath("/images/");
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists())
                filepath.getParentFile().mkdirs();
            System.out.println("Filepath: " + path + File.separator + filename);
            file.transferTo(new File(path + File.separator + filename));
            return "upload-success";
        }
    }
}
