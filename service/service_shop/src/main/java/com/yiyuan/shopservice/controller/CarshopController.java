package com.yiyuan.shopservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yiyuan.shopservice.entity.Carshop;
import com.yiyuan.shopservice.entity.InfoPage;
import com.yiyuan.shopservice.service.CarshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
        StringBuffer str = new StringBuffer();
        Random random = new Random();
        for(int i = 0;i<6;i++){
            str.append(random.nextInt(10));

        }
        String string=str.toString();

        String str2="yy"+string;
        System.out.println(str2);
        carshop.setShopid(str2);

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
        File file = new File("D:\\IDEA\\yiyuan_parent\\service\\service_shop\\src\\main\\resources\\static\\images\\"+imgPath);
        System.out.println(file);
        if(file.exists()){//文件是否存在
            file.delete();//存在删除
        }else{

            return "图片不存在";
        }
        return b+"boolean";
    }

    //修改店铺
    @RequestMapping(method = RequestMethod.POST,value = "update",produces = "application/json;charset=UTF-8")
    public boolean update(@RequestBody Carshop carshop){
//        Integer id = carshop.getId();
//
//        carshop.setId(id);
       boolean b = carshopService.updateById(carshop);
        System.out.println(carshop);


//        boolean b = carshopService.updateById(carshop);
        return b;

    }


//    @PutMapping("update/{id}")
//    public boolean update(@RequestBody Carshop carshop,@PathVariable int id){
//        carshop.setId(id);
//        carshopService.updateById(carshop);
//        return true;
//    }

    //分页查询
    @PostMapping("page")
    public InfoPage page(@RequestParam int current,int size){
        Page<Carshop> page = new Page<>(current,size);
        IPage<Carshop> iPage = carshopService.page(page, null);
        long total = page.getTotal();
        InfoPage infoPage = new InfoPage();
        infoPage.setTotal(total);
        infoPage.setIPage(iPage);
        return infoPage;
    }

    //根据id的查询
    @PostMapping("selectById")
    public List<Carshop> selectById(@RequestParam int id){

        Carshop byId = carshopService.getById(id);


        ArrayList<Carshop> list = new ArrayList<>();
        list.add(byId);
        return list;

    }

    //模糊查询
    @PostMapping("like")
    public List like(@RequestParam String name){

        QueryWrapper<Carshop> wrapper = new QueryWrapper<>();

        QueryWrapper<Carshop> like = wrapper.like("name", name);
        List<Carshop> list = carshopService.list(like);
        return list;
    }
    //登录

}

