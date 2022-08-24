import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        switch (args[0]) {
            case "sync":
                sync(args);
                break;
            default:
                System.out.println("No Command founded for : " + args[0]);
        }
    }

    private static void sync(String[] args){
        String sourceDirPath = args[2];
        String targetDirPath = args[4];

        File sourceDir = new File(sourceDirPath);
        File targetDir = new File(targetDirPath);
        //check differ
        Collection<String> targetList = new ArrayList(Arrays.asList(targetDir.list()));
        Collection<String> sourceList = new ArrayList(Arrays.asList(sourceDir.list()));
        targetList.removeAll(sourceList);
        //delete differ
        for (String pathname : targetList) {
            File toDelete = new File(targetDirPath + "\\" + pathname);
            if (toDelete.isDirectory()) {
                deleteDirectory(toDelete);
            } else {
                toDelete.delete();
            }
        }
        //copy non existing
        copyFolder(sourceDir, targetDir);
    }

    private static boolean deleteDirectory(File directoryToBeDeleted) {
        File[] allContents = directoryToBeDeleted.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                deleteDirectory(file);
            }
        }
        return directoryToBeDeleted.delete();
    }

    private static void copyFolder(File source, File destination) {
        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdirs();
            }

            String files[] = source.list();

            for (String file : files) {
                File srcFile = new File(source, file);
                File destFile = new File(destination, file);

                copyFolder(srcFile, destFile);
            }
        } else {
            InputStream in = null;
            OutputStream out = null;

            try {
                in = new FileInputStream(source);
                out = new FileOutputStream(destination);

                byte[] buffer = new byte[1024];

                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            } catch (Exception e) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
