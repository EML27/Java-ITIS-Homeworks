package com.company.task1;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class TreeSaverXML implements TreeSaverFacade {

    private TreeSaverXML(){}

    private static TreeSaverXML instance;
    public static TreeSaverXML getInstance(){
        if (instance==null){
            instance = new TreeSaverXML();
        }
        return instance;
    }

    @Override
    public MyTree readTree() {
        File file = new File("save0.xml");
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
        }catch (FileNotFoundException e){
            System.out.println("unable to find save file");
        }

        XMLDecoder in = new XMLDecoder(fis);
        MyTree res = (MyTree) in.readObject();
        try {
            fis.close();
        }catch (IOException e){}

        in.close();
        return res;
    }

    @Override
    public void writeTree(MyTree tree) {
        File file = new File("save0.xml");
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(file);
        }catch (FileNotFoundException e){
            System.out.println("unable to create save file");
        }

        XMLEncoder out = new XMLEncoder(fos);
        out.writeObject(tree);
        out.flush();
        out.close();

    }


}
