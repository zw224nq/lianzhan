package com.how2java.tmall.web;

import com.how2java.tmall.pojo.Line;
import com.how2java.tmall.service.LineService;

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
public class LineController {
   @Autowired
    LineService lineService;

    /**
     * defaultValue:每页显示数字
     *
     * @param start
     * @param size
     * @return
     * @throws Exception
     */
    @GetMapping("/lines")
    public Page4Navigator<Line> list(@RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "2") int size) throws Exception {
        start = start<0?0:start;
        Page4Navigator<Line> page = lineService.list(start,size,5);
        return page;
    }

    @PostMapping("/lines")
    public Object add(Line bean, MultipartFile image, HttpServletRequest request) throws Exception {
        lineService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    public void saveOrUpdateImageFile(Line bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/new"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }

    @DeleteMapping("/lines/{id}")
    public String delete(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        lineService.delete(id);
        File imageFolder= new File(request.getServletContext().getRealPath("img/accept"));
        File file = new File(imageFolder,id+".jpg");
        file.delete();
        return null;
    }

    @GetMapping("/lines/{id}")
    public Line get(@PathVariable("id") int id) throws Exception {
        Line bean=lineService.get(id);
        return bean;
    }
    @PutMapping("/lines")
    public Object update(@RequestBody Line bean) throws Exception {
        lineService.update(bean);
        return bean;
    }

}
