import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author linlin
 * @create 2022-05-17 9:48
 */
public class PropertiesTest {
    //Properties：常用来处理配置文件。key和value都是String 类型
    public static void main(String[] args) throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件
        String name = pros.getProperty("name");
        String password = pros.getProperty("password");
        System.out.println("name= "+name+",password="+password);


        if(fis == null){
            fis.close();
        }

    }
}
