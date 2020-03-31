
package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.pojo.User;
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
public class ContactController {
    @Autowired   ContactService contactService;



    @GetMapping("/contacts")
    public Page4Navigator<Contact> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Contact> page = contactService.list(start,size,5);
        return page;
    }

    @PostMapping("/contacts")
    public Object add(Contact bean, MultipartFile image, HttpServletRequest request) throws Exception {
        contactService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }


    public void saveOrUpdateImageFile(Contact bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/contact"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/contacts/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        contactService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/contact"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }




    @GetMapping("/contacts/{id}")
    public Contact get(@PathVariable("id") int id) throws Exception {
        Contact bean=contactService.get(id);
        return bean;
    }
    @PutMapping("/contacts")
    public Object update(@RequestBody Contact bean) throws Exception {
        contactService.update(bean);
        return bean;
    }

}

