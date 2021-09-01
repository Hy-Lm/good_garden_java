package com.yiyuan.shopservice.controller;


import com.yiyuan.shopservice.entity.Carshop;
import com.yiyuan.shopservice.service.CarshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-31
 */
@RestController
@CrossOrigin  //解决跨域
@RequestMapping("/shopservice/carshop")
public class CarshopController {


    @Autowired
    private CarshopService carshopService;

    //上传图片
    @PostMapping("upload")
    public String upload(@RequestParam MultipartFile uploadFile, Model model){


        if (uploadFile.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = uploadFile.getOriginalFilename();  // 文件名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String originalFilename = uploadFile.getOriginalFilename();
        String filePath = "D:\\IDEA\\yiyuan_parent\\service\\service_shop\\src\\main\\resources\\static\\images\\"; // 上传后的路径
        fileName = UUID.randomUUID() + originalFilename; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            uploadFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filename =   fileName;
        model.addAttribute("filename", filename);
//        return  fileName;
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        System.out.println(address);
        String hostAddress = address.getHostAddress();
//        return "http://"+hostAddress+":"+"/images/"+fileName;
        return "http://192.168.7.152:8083"+"/images/"+fileName;


    }
    //添加店铺
    @PostMapping("addShop")
    public boolean addshop(@RequestParam String name,String score,String address,String space,String img,String time,String tel){
        Carshop carshop = new Carshop();
        carshop.setName(name);
        carshop.setScore(score);
        carshop.setAddress(address);
        carshop.setSpace(space);
        carshop.setImg(img);
        carshop.setTime(time);
        carshop.setTel(tel);


        boolean save = carshopService.save(carshop);

        return  save;
    }

    //查询店铺
    @GetMapping("findShop")
    public List<Carshop> findShop(){

        return carshopService.list(null);

    }

    //删除店铺
    @PostMapping("deleteByid")
    public String deleteShop(@RequestParam int id,String imgPath){

        boolean b = carshopService.removeById(id);
        File file = new File("D:\\IDEA\\yiyuan_parent\\service\\service_img\\src\\main\\resources\\static\\images\\"+imgPath);
        if(file.exists()){//文件是否存在
            file.delete();//存在删除
        }else{

            return "图片不存在";
        }
        return b+"删除是否成功";
    }

    //修改店铺
    @PutMapping("update/{id}")
    public boolean update(@RequestBody Carshop carshop,@PathVariable int id){

        carshop.setId(id);
        boolean b = carshopService.updateById(carshop);
        return b;
    }
}

