package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.pojo.New;
import com.how2java.tmall.pojo.Recruit;
import com.how2java.tmall.service.NewService;
import com.how2java.tmall.service.RecruitService;
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
public class RecruitController {



    @Autowired
    RecruitService recruitService;


    /**
     * defaultValue:每页显示数字
     *
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/recruits")
    public Page4Navigator<Recruit> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Recruit> page = recruitService.list(start,size,5);
        return page;
    }

    @PostMapping("/recruits")
    public Object add(Recruit bean, MultipartFile image, HttpServletRequest request) throws Exception {
        recruitService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }


    public void saveOrUpdateImageFile(Recruit bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/recruit"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/recruits/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        recruitService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/recruit"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }




    @GetMapping("/recruits/{id}")
    public Recruit get(@PathVariable("id") int id) throws Exception {
        Recruit bean=recruitService.get(id);
        return bean;
    }
    @PutMapping("/recruits")
    public Object update(@RequestBody Recruit bean) throws Exception {
        recruitService.update(bean);
        return bean;
    }


}
