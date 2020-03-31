package com.how2java.tmall.web;

import com.how2java.tmall.pojo.CompanyCulture;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.service.CompanyCultureService;
import com.how2java.tmall.service.ContactService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class CompanyCultureController {

    @Autowired
    CompanyCultureService CompanyCultureService;



    @GetMapping("/companyCultures")
    public Page4Navigator<Contact> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Contact> page = CompanyCultureService.list(start,size,5);
        return page;
    }

    @PostMapping("/companyCultures")
    public Object add(CompanyCulture bean, MultipartFile image, HttpServletRequest request) throws Exception {
        CompanyCultureService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }


    public void saveOrUpdateImageFile(CompanyCulture bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/CompanyCulture"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/companyCultures/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        CompanyCultureService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/CompanyCulture"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }




    @GetMapping("/companyCultures/{id}")
    public CompanyCulture get(@PathVariable("id") int id) throws Exception {
        CompanyCulture bean=CompanyCultureService.get(id);
        return bean;
    }
    @PutMapping("/companyCultures")
    public Object update(@RequestBody CompanyCulture bean) throws Exception {
        CompanyCultureService.update(bean);
        return bean;
    }
}
