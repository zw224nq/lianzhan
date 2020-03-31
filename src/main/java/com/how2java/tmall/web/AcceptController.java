package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Accept;
import com.how2java.tmall.pojo.Contact;
import com.how2java.tmall.pojo.New;
import com.how2java.tmall.service.AcceptService;
import com.how2java.tmall.service.NewService;
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
public class AcceptController {

    @Autowired
    AcceptService acceptService;


    /**
     * defaultValue:每页显示数字
     *
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/accepts")
    public Page4Navigator<Contact> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Contact> page = acceptService.list(start,size,5);
        return page;
    }

    @PostMapping("/accepts")
    public Object add(Accept bean, MultipartFile image, HttpServletRequest request) throws Exception {
        acceptService.add(bean);
       saveOrUpdateImageFile(bean, image, request);
        return bean;
    }


    public void saveOrUpdateImageFile(Accept bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/new"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/accepts/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        acceptService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/accept"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }




    @GetMapping("/accepts/{id}")
    public Accept get(@PathVariable("id") int id) throws Exception {
        Accept bean=acceptService.get(id);
        return bean;
    }
    @PutMapping("/accepts")
    public Object update(@RequestBody Accept bean) throws Exception {
        acceptService.update(bean);
        return bean;
    }
}
