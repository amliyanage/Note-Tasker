package lk.ijse.gdse.aad68.notetaker.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.UUID;

public class AppUtil {

    public static String createNoteId(){
        return "NOTE-"+UUID.randomUUID();
    }

    public static String createUserId(){
        return "USER"+UUID.randomUUID();
    }

    public static String toBase64ProfilePic(byte [] profilePic){
        return Base64.getEncoder().encodeToString(profilePic);
    }
}
