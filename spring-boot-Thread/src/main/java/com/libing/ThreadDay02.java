package com.libing;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author lvlibing
 * @create 2021-07-25 16:29
 */
@Getter
@Setter
public class ThreadDay02 extends Thread {
// 使用多线程下载网络文件

    private String url;
    private String nameFile;

public ThreadDay02(String url,String name){
    this.url = url;
    this.nameFile = name;
}
    public static void main(String[] args) {
        ThreadDay02 thread1=new ThreadDay02("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%E4%B8%AD%E5%9B%BD&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=32932163,1467719077&os=3675860617,1528171797&simid=19367698,800781779&pn=0&rn=1&di=200090&ln=1697&fr=&fmq=1627202808710_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fpro.user.img4.51sole.com%252FproductImages3%252F20110730%252F894566_20110730155335.jpg%26refer%3Dhttp%253A%252F%252Fpro.user.img4.51sole.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629794807%26t%3D4667925bbf1d15afc5e3f7fcf0ea8144&rpstart=0&rpnum=0&adpicid=0&nojc=undefined","1.jpg");
        ThreadDay02 thread2=new ThreadDay02("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%E4%B8%AD%E5%9B%BD&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1599231213,2294109150&os=4083130959,226966822&simid=3404654000,125147627&pn=17&rn=1&di=107690&ln=1697&fr=&fmq=1627202808710_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fpic5.997788.com%252Fpic_search%252F00%252F17%252F63%252F68%252Fse17636816.jpg%26refer%3Dhttp%253A%252F%252Fpic5.997788.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629794807%26t%3Db7cc312a682de918dbec8a16c649c693&rpstart=0&rpnum=0&adpicid=0&nojc=undefined","2.jpg");
        ThreadDay02 thread3=new ThreadDay02("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%E4%B8%AD%E5%9B%BD&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1915568693,403879141&os=844184080,860754683&simid=4211715497,740275584&pn=3&rn=1&di=109010&ln=1697&fr=&fmq=1627202808710_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fimg14.360buyimg.com%252Fn0%252Fjfs%252Ft286%252F329%252F1581840338%252F334410%252F95115a17%252F543e7a4cN03496509.jpg%26refer%3Dhttp%253A%252F%252Fimg14.360buyimg.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629794807%26t%3Dae2f7a8efd082966369d683781075184&rpstart=0&rpnum=0&adpicid=0&nojc=undefined","3.jpg");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        DownloadFile downloadFile=new DownloadFile();
        try {
            downloadFile.getFile(url,nameFile);
            System.out.println("下载了文件"+nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class  DownloadFile{

        public void getFile(String url,String name) throws IOException {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }
    }


}
