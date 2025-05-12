import java.util.Scanner;

public class MiniShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShellCommandHandler handler = new ShellCommandHandler();

        System.out.println("Welcome to MiniShell! Type 'help' for a list of commands.");

        while (true) {
            System.out.print(handler.getCurrentDirectory().getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];
            String argument = parts.length > 1 ? parts[1] : null;

            // - pwd: Print working directory
            if ( command.equals("pwd")){
                handler.printWorkingDirectory();
            }
            // - ls: List files in current directory
            else if ( command.equals("ls")){
                handler.listDirectory();
            }
            // - cd: Change directory
            else if ( command.equals("cd")){
                handler.changeDirectory(argument);
            }
            // - mkdir: Create new directory
            else if ( command.equals("mkdir")){
                handler.makeDirectory(argument);
            }
            // - touch: Create new file
            else if ( command.equals("touch")){
                handler.createFile(argument);
            }
            // - help: Show help information
            else if ( command.equals("help")){
                handler.printHelp();
            }
            else{
                System.out.println("unavailable command. Type 'help' to see available commands.");
            }
            // - exit: Exit the program
            if (command.equals("exit")) {
                return;
            }
        }
    }
}