package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // Bu class'ı configreader.getProperty kullanmak için yaptık.

    // BU CLASS'I HAZİR OLUSTURDUK IHTIYAC OLDUGUNDA COPY-PASTE YAPIP KULLAN HAZIR SABLON

    public static Properties properties; // Her yerden kullanmak için public yaptık, aşağıda kullanabilmek için static yaptık.

    static { // Alttaki method çalışmadan en önce bu çalışır.
        String dosyaYolu = "configuration.properties";
        // configuration.properties sağ tıklayıp,Copy-Path/Reference tıklayıp Path From Content Root'a tıklayarak yolu kopyalarız.

        try {
            FileInputStream fis =new FileInputStream(dosyaYolu);
            /*
            fis dosyayolunu tanimladigimiz configuration.properties dosyasini okudu
             */
            properties = new Properties(); // properties objesini oluşturduk.
            properties.load(fis); // fis'in okudugu dosyalari properties'e yukledi

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){  // TestMethod'UNDAN BURAYA KEY GELECEK
        // String oluşturma sebebimiz, properties'deki değerlerde String

        /*
        test method'undan yolladigimiz string key degerini alip
        Properties class'indan getProperty() method'unu kulanarak
        bu key' ait value bize getirdi
         */

        return properties.getProperty(key);  // BURADA DA VALUE ALIP DONECEK
                                           /*
                                           TARGET altinda olusturduğumuz configuration.propertiers
                                           kısmından key leri aliyor ve donup value degerlerini de aliyor
                                            */
    }
}
