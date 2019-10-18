/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicaciónmp3;

/**
 *
 * @author ferna
 */

import java.io.File;

public class AplicaciónMP3 {

    public static void main(String[] args)
    {

        // Aquí la carpeta que queremos explorar
        String path = "C:\\Users\\ferna\\Desktop\\Nueva carpeta\\otraCancion";

        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++)
        {

            if (listOfFiles[i].isFile())
            {
                files = listOfFiles[i].getName();
                if (files.endsWith(".mp3") || files.endsWith(".MP3"))
                {
                    System.out.println(files);
                }
            }
        }
        System.out.println("Fin");
    }
}
