package com.cnpc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class FileController {
    private static String UPLOADED_FOLDER = "E://temp//";
    Date date = new Date(  );

    @GetMapping("/")
    public String file(){
        return "file";
    }
    @GetMapping("/more")
    public String uploadMore() {
        return "fileMore";
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute( "message","没有需要上传的文件，请选择！" );
            return "redirect:success";
        }
        try {
            byte[] bytes = file.getBytes();
//            long date = System.currentTimeMillis();
//            Date date1 = new Date( date );
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMddHHmmss" );
//            String date2 = simpleDateFormat.format( date1 );
            Path path = Paths.get( UPLOADED_FOLDER+file.getOriginalFilename() );
            Files.write( path,bytes );

            redirectAttributes.addFlashAttribute
                    ( "message","文件 '"+file.getOriginalFilename()+"'上传成功！" );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:success";
    }

    @PostMapping("/uploadMore")
    public String fileMore(@RequestParam("file") MultipartFile[] files,
                           RedirectAttributes redirectAttributes){
        if(files.length == 0){
            redirectAttributes.addFlashAttribute( "message","没有需要上传的文件，请选择！" );
            return "redirect:success";
        }
        for (MultipartFile file : files){
            try{
                byte[] bytes = file.getBytes();
//                long date = System.currentTimeMillis();
//                Date date1 = new Date( date );
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMddHHmmss" );
//                String date2 = simpleDateFormat.format( date1 );
                Path path = Paths.get( UPLOADED_FOLDER+file.getOriginalFilename() );
                Files.write( path,bytes );
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute
                ( "message","所以文件上传成功！" );
        return "redirect:success";
    }

    @GetMapping("/success")
    public String uploadStatus() {
        return "success";
    }

}
