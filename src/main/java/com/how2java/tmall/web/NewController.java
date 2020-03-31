package com.how2java.tmall.web;



import com.how2java.tmall.pojo.New;

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
import java.util.List;

@RestController
public class NewController {


    @Autowired
    NewService newService;


    /**
     * defaultValue:每页显示数字
     *
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/news")
    public Page4Navigator<New> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<New> page = newService.list(start,size,5);
        return page;
    }

    @PostMapping("/news")
    public Object add(New bean, MultipartFile image, HttpServletRequest request) throws Exception {
        newService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }


    public void saveOrUpdateImageFile(New bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/new"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/news/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        newService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/new"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }




    @GetMapping("/news/{id}")
    public New get(@PathVariable("id") int id) throws Exception {
        New bean=newService.get(id);
        return bean;
    }
    @PutMapping("/news")
    public Object update(@RequestBody New bean) throws Exception {
        newService.update(bean);
        return bean;
    }
   //根据id找姓名
    @GetMapping("/name/{id}")
     public List<New> findNameById(@PathVariable("id") int id) throws  Exception{
        List<New> bean=newService.findNameById(id);
        return bean;

    }
    //所有内容
    @GetMapping("/contents")
    public  List<New> findContent(){
    List<New> bean=newService.findContent();
        return bean;
    }

    @GetMapping("/titles")
    public  List<New> findTitle(){
        List<New> bean=newService.findTitle();
        return bean;
    }



}
