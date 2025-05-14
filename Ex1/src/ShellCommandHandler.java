import java.io.File;
import java.io.IOException;

public class ShellCommandHandler {
    private File currentDirectory;
    //-----------------------------------------------------
    public ShellCommandHandler() {
        //--Initialize currentDirectory to the user's current working directory--//
        String userDir = System.getProperty("user.dir");
        this.currentDirectory = new File(userDir);
    }
    //-----------------------------------------------------
    public void printWorkingDirectory() {
        //--Print the absolute path of the current directory--//
        System.out.println("this is the Absolute path of you current directory: " + currentDirectory.getAbsolutePath());
    }
    //-----------------------------------------------------
    public void listDirectory() {
        //--List all files and directories in the current directory--//
        File[] filesList = currentDirectory.listFiles();
        if (filesList != null && filesList.length > 0) {
            System.out.println("Files and directories in this directory: " + currentDirectory.getAbsolutePath());
            for (File file : filesList) {
                if (file.isDirectory()) {
                    System.out.println("[DIR ] " + file.getName());
                }
                else if (file.isFile()) {
                    System.out.println("[FILE] " + file.getName());
                }
            }
        }
        else {
            System.out.println("This directory is empty or cannot be accessed.");
        }
    }
    //----------------------------------------------------
    public void changeDirectory(String name1) {
        //--Implement the change directory command--//
        if (name1 == null || name1.trim().isEmpty()) {
            //--If name is null, show usage message: "Usage: cd [directory_name]"--//
            System.out.println("Usage: cd [directory_name]");
            return;
        }

        if (name1.equals("..")) {
            //--If name is "..", move to parent directory if possible--//
            File Parent = currentDirectory.getParentFile();
            if (Parent != null && Parent.exists()) {
                currentDirectory = Parent;
                System.out.println("Changed directory to: " + currentDirectory.getAbsolutePath());
            }
            else {
                System.out.println("Already at the root directory. Cannot move up.");
            }
        }
        else {
            //--Otherwise, try to move to the specified directory--//
            File newDir = new File(currentDirectory, name1);
            if (newDir.exists() && newDir.isDirectory()) {
                currentDirectory = newDir;
                System.out.println("Changed directory to: " + currentDirectory.getAbsolutePath());
            }
            else {
                //--If directory doesn't exist, print error message: "Directory not found: [name]"--//
                System.out.println("Directory not found: " + name1);
            }
        }
    }
    //-------------------------------------------------
    public void makeDirectory(String name1) {
        //--Implement the make directory command--//
        if (name1 == null || name1.trim().isEmpty()) {
            //--If name is null, show usage message: "Usage: mkdir [directory_name]"--//
            System.out.println("Usage: mkdir [directory_name]");
            return;
        }

        File newDir = new File(currentDirectory, name1);
        if (newDir.exists()) {
            if (newDir.isDirectory()) {
                //--If directory already exists, print: "Directory already exists."--//
                System.out.println("the Directory is already existed.");
            }
            else {
                System.out.println("A file with that name is already existed.");
            }
            return;
        }

        if (newDir.mkdir()) {
            //--If directory creation is successful, print: "Directory created: [name]"--//
            System.out.println("Directory created: " + name1);
        }
        else {
            //--If directory creation fails, print: "Failed to create directory."--//
            System.out.println("Failed to create directory.");
        }
    }
    //-----------------------------------------------
    public void createFile(String name1) {
        //--Implement the create file command--//
        if (name1 == null || name1.trim().isEmpty()) {
            //--If name is null, show usage message: "Usage: touch [file_name]"--//
            System.out.println("Usage: touch [file_name]");
            return;
        }

        File newFile = new File(currentDirectory, name1);

        if (newFile.exists()) {
            if (newFile.isFile()) {
                //--If file already exists, print: "File already exists."--//
                System.out.println("File already exists.");
            }
            else {
                System.out.println("A directory with that name already exists.");
            }
            return;
        }

        try {
            if (newFile.createNewFile()) {
                //--If file creation is successful, print: "File created: [name]"--//
                System.out.println("File created: " + name1);
            }
            else {
                System.out.println("Failed to create file.");
            }
        }
        catch (IOException e) {
            //--If file creation fails, print error message with exception details--//
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
    //-------------------------------------------------------------
    public void printHelp() {
        //--Implement help command to print information about all available commands--//
        //--List all commands with their descriptions--//
        System.out.println("Here are some Available Commands you can use:");
        System.out.println("  cd [directory_name]    : Change current directory (Use '..' to move to parent directory)");
        System.out.println("  mkdir [directory_name] : Create a new directory");
        System.out.println("  touch [file_name]      : Create a new file");
        System.out.println("  ls                     : List files and directories in the current directory");
        System.out.println("  pwd                    : Print current working directory path");
        System.out.println("  help                   : Show this help message");
        System.out.println("  exit                   : Exit the program");
    }
    //-----------------------------------------------------------
    public File getCurrentDirectory() {
        //--Return the current directory--//
        return currentDirectory;
    }
}
