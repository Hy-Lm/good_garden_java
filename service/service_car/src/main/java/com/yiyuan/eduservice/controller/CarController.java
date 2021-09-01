package com.yiyuan.eduservice.controller;


import com.yiyuan.eduservice.entity.Car;


import com.yiyuan.eduservice.service.CarService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-08-16
 */
@RestController
@CrossOrigin  //解决跨域
@RequestMapping("/educar/car")
public class CarController {


    //注入srvice
    @Autowired
    private CarService carService;
    //查询信息
    @GetMapping("findAll")
    public List<Car> findAll(){

        return carService.list(null);

    }

//    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");



    //上传图片
    @PostMapping("upload")
    public String upload(@RequestParam MultipartFile uploadFile,Model model)  {

//        /**
//         * 上传图片
//         */
//        //图片上传成功后，将图片的地址写到数据库
//        //保存图片的路径（这是存在我项目中的images下了，你们可以设置路径）
//        String filePath = "D:\\IDEA\\yiyuan_parent\\service\\service_car\\src\\main\\resources\\static";
//        //获取原始图片的拓展名
//        String originalFilename = uploadImg.getOriginalFilename();
//        //新的文件名字
//        String newFileName = UUID.randomUUID() + originalFilename;
//        //封装上传文件位置的全路径
//        File targetFile = new File(filePath, newFileName);
//        //把本地文件上传到封装上传文件位置的全路径
//        try {
//            uploadImg.transferTo(targetFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        car.setImg(newFileName);
//        /**
//         * 保存商品
//         */
//        carService.save(car);
//        System.out.println(filePath);
//        return "redirect:/product/list";



        if (uploadFile.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = uploadFile.getOriginalFilename();  // 文件名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String originalFilename = uploadFile.getOriginalFilename();
        String filePath = "D:\\IDEA\\yiyuan_parent\\service\\service_car\\src\\main\\resources\\static\\images\\"; // 上传后的路径
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
       return  "http://192.168.7.152:8081"+"/images/"+fileName;


//        //获取文件名
//        String filename = uploadFile.getOriginalFilename();
//        System.out.println(filename);
//        //获取文件后缀名
//        String suffixName = filename.substring(filename.lastIndexOf("."));
//
//        //重新生成文件名
//        filename = UUID.randomUUID()+suffixName;
//        //添加日期目录
//        String format = sd.format(new Date());
//
//        //指定本地文件夹存储图片
//        String filePath = "D:/IDEA/yiyuan_parent/service/service_car/src/main/resources/static/";
//        File file = new File(filePath,filename);
//        if (!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//
//        try {
//            //将图片保存到static文件夹里
//            file.createNewFile();
//            uploadFile.transferTo(new File(filePath+filename));
////                return  filePath +filename;
//            return  "http://192.168.7.52:8081"+filePath+"/"+filename;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "false";
//        }







//        if(file==null){
//            return new HashMap(0);
//        }
//        Map map = new HashMap<>(2);
//        // 原文件名称
//        String filename = file.getOriginalFilename();
//        // 创建临时文件
//        File tempFile = File.createTempFile("tem", null);
//        file.transferTo(tempFile);
//        tempFile.deleteOnExit();
//
//        // 文件输入流
//        FileInputStream inputStream = new FileInputStream(tempFile);
//
//        byte[] buffer = new byte[(int)tempFile.length()];
//        inputStream.read(buffer);
//        inputStream.close();



//        // 转换为base64编码格式
//        String base64 = new sun.misc.BASE64Encoder().encode(buffer);
//
//        // 上面方法中获得的base64编码中，包含有换行符，统一全部替换掉
//        base64 = base64.replaceAll("[\\s*\t\n\r]", "");

//        // 返回值
//        map.put("filename", filename);
//        map.put("file", buffer);
//
//        System.out.println(
//                map
//        );
//        return map;


    }



    //添加
    @ApiOperation(value="车辆添加")
    @PostMapping("addCar")
    public boolean addCar(@RequestParam String name, String tel, String idcar, String km, String gotime ,String img) throws IOException {

        Car car = new Car();
        car.setName(name);
        car.setTel(tel);
        car.setIdcar(idcar);
        car.setKm(km);
        car.setGotime(gotime);
        car.setImg(img);
        boolean save = carService.save(car);
        return save;
    }
    //删除
    @PostMapping("deleteById")
    public boolean deleteById(@RequestParam int id,String imgPath){
        boolean b = carService.removeById(id);

//        File file1 = new File(imgPath);
//        "yiyuan_parent\\service\\service_car\\src\\main\\resources\\static\\images\\"+imgPath

        File file = new File("D:\\IDEA\\yiyuan_parent\\service\\service_car\\src\\main\\resources\\static\\images\\"+imgPath);

//        System.out.println(file1.getAbsolutePath());
//        String path = file.getAbsolutePath();
//        System.out.println(path);
     if(file.exists()){//文件是否存在
         file.delete();//存在删除
      }else{

           return false;
      }
        return b;
    }

    //默认车辆
    @PostMapping("active")
    public void active(@RequestParam int id){
        Car car = new Car();
        int active = car.getActive();
        if(active==1){
            active=0;

        }else{
            active=1;
        }
//        carService.updateBatchById(1,2);
    }
}

