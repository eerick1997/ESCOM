package DataBases.SQLite;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Converter implements Serializable {
    //Constants
    private static final String TAG = "Converter.java";


    /**This method convert an object into a byte array
     * this method receive just an argument type Object
     * and returns an array of bytes
     * @param object: This object we gonna convert into bytes
     * @return byte[]
     * **/
    public byte[] toBytes(Object object){
        Log.d(TAG, "toBytes() called with: object = [" + object + "]");
        byte[] bytes = null;
        //Probably we catch an exception
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(object);
            bytes = outputStream.toByteArray();
        } catch (Exception e) {
            Log.e(TAG, "toBytes: ", e);
        }
        Log.d(TAG, "toBytes() returned: " + bytes);
        return bytes;
    }

    /**
     * This method convert a byte array into an object
     * we use this method to force SQLite to be oriented object
     *
     * @param bytes: byte array
     * @return Object
     **/
    public Object getObject(byte[] bytes) {
        Log.d(TAG, "getObject() called with: bytes = [" + bytes + "]");
        Object object = null;
        //Probably we catch an exception
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            object = objectInputStream.readObject();
        } catch (Exception e) {
            Log.e(TAG, "getObject: ", e);
        }
        Log.d(TAG, "getObject() returned: " + object);
        return object;
    }

    public String getIdStation(@NonNull String name, @NonNull String line){
        Log.d(TAG, "getIdStation() called with: name = [" + name + "], line = [" + line + "]");
        String id = null;
        try{
            if(name.contains(" "))
                name = name.replace(" ", "_");
            if(name.contains("ñ"))
                name = name.replace("ñ", "ni");
            if(line.contains(" "))
                line = line.replace(" ", "_");

            id = "ic_" + name + "_" + line;
        } catch (Exception e){
            Log.e(TAG, "getIdStation: ", e);
        }
        id += ".png";
        Log.d(TAG, "getIdStation() returned: " + id);
        return id;
    }
}
