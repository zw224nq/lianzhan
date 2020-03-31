package com.how2java.tmall.web;

import com.how2java.tmall.pojo.CompanyCulture;
import com.how2java.tmall.pojo.CompanySummary;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.service.CompanyCultureService;
import com.how2java.tmall.service.CompanySummaryService;
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
public class CompanySummaryController {
    @Autowired
    CompanySummaryService companySummaryService;


    @GetMapping("/companySummarys")
    public Page4Navigator<Contact> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        Page4Navigator<Contact> page = companySummaryService.list(start, size, 5);
        return page;
    }

    @PostMapping("/companySummarys")
    public Object add(CompanySummary bean, MultipartFile image, HttpServletRequest request) throws Exception {
        companySummaryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }


    public void saveOrUpdateImageFile(CompanySummary bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/CompanyCulture"));
        File file = new File(imageFolder, bean.getId() + ".jpg");
        if (!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/companySummarys/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request) throws Exception {
        companySummaryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/CompanyCulture"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;
    }


    @GetMapping("/companySummarys/{id}")
    public CompanySummary get(@PathVariable("id") int id) throws Exception {
        CompanySummary bean = companySummaryService.get(id);
        return bean;
    }

    @PutMapping("/companySummarys")
    public Object update(@RequestBody CompanySummary bean) throws Exception {
        companySummaryService.update(bean);
        return bean;
    }
}
