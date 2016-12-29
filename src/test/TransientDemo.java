import com.entity.UserInfo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * TransientDemo
 * <p>
 * PACKAGE_NAME
 * Serializable and transient demo
 *
 * @author xiaoyy
 *         2016-12-16 下午2:55
 *         The word 'impossible' is not in my dictionary.
 */
public class TransientDemo {
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("towry", "123456");
        System.out.println(userInfo);
        try {
            // Serializable, but transient attribute isn't serializable.
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
            outputStream.writeObject(userInfo);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // read UserInfo.out
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("UserInfo.out"));
            UserInfo userInfo1 = (UserInfo) inputStream.readObject();
            // transient pwd is null.
            System.out.println(userInfo1.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
