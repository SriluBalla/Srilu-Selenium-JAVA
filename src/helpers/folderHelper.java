package helpers;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.File;

public class folderHelper {

    @Then("^Get Latest File$")
    public static File verify_latestFile(String path){
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0){
            return dir;
        }

        File lastDownloadFile = files[0];
        for (int i = 1; i < files.length; i++){
            if (lastDownloadFile.lastModified() <files[i].lastModified()){
                lastDownloadFile = files [i];
            }
        }
        return lastDownloadFile;
    }

    @And("^Delete file$")
    public static void delete_file(String file){
        File delFile = new File(file);
        if(delFile.exists()){
            delFile.delete();
        }
    }

}
