package com.saekiyuu.learning.springmvc.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileOperateController {

    @RequestMapping(value = "/upload-page")
    public String uploadPage() {
        return "upload-page";
    }

    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request, @RequestParam MultipartFile file, Model model)
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
            model.addAttribute("file", file);
            return "download-page";
        }
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename)
            throws IOException {
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        String downloadfile = new String(filename.getBytes("UTF-8"), "iso-8859-1");
        headers.setContentDispositionFormData("attachment", downloadfile);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
