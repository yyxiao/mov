package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

/**
 * UploadFile
 *
 * @author xiaoyy
 * hadoop uploadFile
 * @Date 2017-01-04 下午12:02
 * The word 'impossible' is not in my dictionary.
 */
public class UploadFile {

    public static void main(String[] args) {
        try {
            String localStr = args[0];
            String dst = args[1];
            //in对应的是本地文件系统的目录
            InputStream in = new BufferedInputStream(new FileInputStream(localStr));
            Configuration conf = new Configuration();
            //获得hadoop系统的连接
            FileSystem fs = FileSystem.get(URI.create(dst), conf);

            //out对应的是Hadoop文件系统中的目录
            OutputStream out = fs.create(new Path(dst));
            //4096是4k字节
            IOUtils.copyBytes(in, out, 4096, true);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
