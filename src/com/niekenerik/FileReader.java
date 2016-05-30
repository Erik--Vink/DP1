package com.niekenerik;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FileReader {

    private HashMap<String, String> nodes;
    private HashMap<String, ArrayList<String>> nodeLinks;

    public FileReader(){
        nodes = new HashMap<>();
        nodeLinks = new HashMap<>();
    }

    public HashMap<String, String> getNodes() {
        return nodes;
    }

    public HashMap<String, ArrayList<String>> getNodeLinks() {
        return nodeLinks;
    }

    public Boolean readFile(String naam){
        boolean node = false;
        boolean nodeLink = false;
        InputStream fis =  FileReader.class.getResourceAsStream("testFiles/" + naam);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                if(!line.contains("#") && line.length() > 0){
                    //regel bevat geen # dus is een niet comment line
                    //onnodige tekens uit de lijn halen
                    line = line.replace(";" , "");
                    line = line.replaceAll("\\s","");
                    if(node){
                        // de regel bevat een naam van een node en het type
                        String[] part = line.split(":");
                        nodes.put(part[0],part[1]);
                    } else if(nodeLink) {
                        // de regel bevat een naam van een node en de link
                        String[] part = line.split(":");
                        String[] links = part[1].split(",");
                        ArrayList<String> setLinks = new ArrayList<>();
                        Collections.addAll(setLinks, links);
                        nodeLinks.put(part[0], setLinks);
                    }
                } else {
                    if(line.contains("Description of all the nodes")){
                        node = true;
                        nodeLink = false;
                    } else if(line.contains("Description of all the edges")){
                        node = false;
                        nodeLink = true;
                    }

                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public ArrayList<String> getFileNames(String path){
        File folder = new File(FileReader.class.getResource("").getPath() + path);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> fileNames = new ArrayList<>();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                fileNames.add(listOfFile.getName());
            }
        }

        return fileNames;
    }

}
