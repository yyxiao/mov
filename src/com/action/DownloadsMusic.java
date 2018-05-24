package com.action;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * DownloadsMusic
 * com.action
 *
 * @author Xander
 * @Description 通过网易云音乐listid获取歌曲id
 * @Date 2018-05-21 下午5:59
 * The word 'impossible' is not in my dictionary.
 */
public class DownloadsMusic {

    public static void main(String[] args) throws Exception {
        Map<String, String> maps = new HashMap<>();
        //获取请求连接
        Connection con = Jsoup.connect("http://music.163.com/playlist?id=8479576");
        //把String转化成document格式
        Document doc = con.header("Referer", "http://music.163.com/").header("Host", "music.163.com").get();
        //获取所有符合条件的节点集
        Elements elements = doc.select("ul[class=f-hide] a");

        //使用java8stream、forEach将数据放入maps，并对数据进行处理
        elements.stream().forEach(w -> maps.put(w.text(), w.attr("href").split("=")[1]));

        //下载歌单到本地
        for (Map.Entry<String, String> entry : maps.entrySet()) {
            downloadByUrl(entry.getValue(), entry.getKey());
        }

//        Jsoup.connect("http://music.163.com/playlist?id=362498513")
//                .header("Referer", "http://music.163.com/")
//                .header("Host", "music.163.com").get().select("ul[class=f-hide] a")
//                .stream().map(w -> w.text() + "-->" + w.attr("href").split("=")[1])
//                .forEach(System.out::println);
    }


    /**
     * 下载文件
     *
     * @param newUrl
     * @param name
     */
    public static void downloadByUrl(String newUrl, String name) throws Exception {
        //本地保存
        FileOutputStream fs = new FileOutputStream("/Users/xiaoyy/Downloads/music/" + name + ".mp3");
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        URL url = new URL("http://music.163.com/song/media/outer/url?id=" + newUrl + ".mp3");

        try {
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
        } finally {
            System.out.println("download success.The name is " + name);
            fs.close();
        }
    }

}
