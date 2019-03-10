package com.eren.testdome;

import java.util.LinkedList;

// https://www.testdome.com/questions/java/path/12283?visibility=1&skillId=4&orderBy=Difficulty
public class Path {
    private String path;
    private final String FOLDER_SEP = "/";
    private final String PARENT_FOLDER_SEP = "..";

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        String[] folders = path.split("/");
        LinkedList<String> folderList = new LinkedList<>();
        for(String folder: folders) {
            if(folder != null && folder.length() > 0) {
                if (folder.equals(PARENT_FOLDER_SEP)) {
                    folderList.removeLast();
                } else {
                    folderList.add(folder);
                }
            }
        }
        StringBuffer realPath = new StringBuffer();
        for(String folder : folderList) {
            realPath.append(FOLDER_SEP).append(folder);
        }
        this.path = realPath.toString();
        return path;
    }

    public void cd(String newPath) {
        if(newPath.startsWith(FOLDER_SEP)) {
            path = newPath;
        } else {
            path = path.concat(FOLDER_SEP).concat(newPath);
        }
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        path.cd("../../x/..");
        System.out.println(path.getPath());
    }
}