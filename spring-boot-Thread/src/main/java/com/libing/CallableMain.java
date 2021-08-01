package com.libing;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author lvlibing
 * @create 2021-07-25 17:31
 */
public class CallableMain implements Callable<Boolean> {

    private String url;
    private String fileName;


    @Override
    public Boolean call() throws Exception {
        DownloadFile downloadFile=new DownloadFile();
        downloadFile.getFile(url,fileName);
        System.out.println("下载了"+fileName);
        return true;
    }

    public CallableMain(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableMain thread1=new CallableMain("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%E4%B8%AD%E5%9B%BD&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=32932163,1467719077&os=3675860617,1528171797&simid=19367698,800781779&pn=0&rn=1&di=200090&ln=1697&fr=&fmq=1627202808710_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fpro.user.img4.51sole.com%252FproductImages3%252F20110730%252F894566_20110730155335.jpg%26refer%3Dhttp%253A%252F%252Fpro.user.img4.51sole.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629794807%26t%3D4667925bbf1d15afc5e3f7fcf0ea8144&rpstart=0&rpnum=0&adpicid=0&nojc=undefined","1.jpg");
        CallableMain thread2=new CallableMain("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%E4%B8%AD%E5%9B%BD&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1599231213,2294109150&os=4083130959,226966822&simid=3404654000,125147627&pn=17&rn=1&di=107690&ln=1697&fr=&fmq=1627202808710_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fpic5.997788.com%252Fpic_search%252F00%252F17%252F63%252F68%252Fse17636816.jpg%26refer%3Dhttp%253A%252F%252Fpic5.997788.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629794807%26t%3Db7cc312a682de918dbec8a16c649c693&rpstart=0&rpnum=0&adpicid=0&nojc=undefined","2.jpg");
        CallableMain thread3=new CallableMain("https://image.baidu.com/search/detail?ct=503316480&z=undefined&tn=baiduimagedetail&ipn=d&word=%E5%9B%BE%E7%89%87%20%E4%B8%AD%E5%9B%BD&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=undefined&hd=undefined&latest=undefined&copyright=undefined&cs=1915568693,403879141&os=844184080,860754683&simid=4211715497,740275584&pn=3&rn=1&di=109010&ln=1697&fr=&fmq=1627202808710_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=undefined&height=undefined&face=undefined&is=0,0&istype=0&ist=&jit=&bdtype=0&spn=0&pi=0&gsm=0&objurl=https%3A%2F%2Fgimg2.baidu.com%2Fimage_search%2Fsrc%3Dhttp%253A%252F%252Fimg14.360buyimg.com%252Fn0%252Fjfs%252Ft286%252F329%252F1581840338%252F334410%252F95115a17%252F543e7a4cN03496509.jpg%26refer%3Dhttp%253A%252F%252Fimg14.360buyimg.com%26app%3D2002%26size%3Df9999%2C10000%26q%3Da80%26n%3D0%26g%3D0n%26fmt%3Djpeg%3Fsec%3D1629794807%26t%3Dae2f7a8efd082966369d683781075184&rpstart=0&rpnum=0&adpicid=0&nojc=undefined","3.jpg");
        // 创建执行服务
        ExecutorService ser= Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> r1 = ser.submit(thread1);
        Future<Boolean> r2 = ser.submit(thread2);
        Future<Boolean> r3 = ser.submit(thread3);
        // 获取结果
        Boolean aBoolean = r1.get();
        Boolean aBoolean1 = r2.get();
        Boolean aBoolean2 = r3.get();
        // 关闭服务
        ser.shutdownNow();

    }

    class  DownloadFile{
        public void getFile(String url,String name) throws IOException {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        }
    }

}
