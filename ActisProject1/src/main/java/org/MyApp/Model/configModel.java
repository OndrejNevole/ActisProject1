package org.MyApp.Model;

import java.io.*;
import java.util.Properties;

public class configModel {
    public static Properties getConf() {
        try (InputStream input = new FileInputStream("config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("db.url"));
            System.out.println(prop.getProperty("db.user"));
            System.out.println(prop.getProperty("db.password"));

            return prop;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static void setConf(String DbAddress, String User, String Pass) {

        try (OutputStream output = new FileOutputStream("config.properties")) {
            
            Properties prop = new Properties();

            prop.setProperty("db.address", DbAddress);
            prop.setProperty("db.user", User);
            prop.setProperty("db.pass", Pass);

            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
