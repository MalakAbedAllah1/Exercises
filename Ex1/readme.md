# MiniShell - Java Command Line Shell Implementation

## Overview
MiniShell is a simple implementation of a command-line shell in Java. It provides basic file system navigation and manipulation functionality similar to Unix/Linux shells, allowing users to perform operations like listing directories, creating files and folders, and navigating the file system.

## Features
- **Display current working directory** (`pwd`)
- **List contents of the current directory** (`ls`)
- **Change directory** (`cd`)
- **Create new directories** (`mkdir`)
- **Create new files** (`touch`)
- **Help menu** for command reference (`help`)
- **Exit the shell** (`exit`)

## Implementation Details
The project consists of two main Java classes:
1. **MiniShell.java**: The main application that handles user input and interfaces with the command handler.
2. **ShellCommandHandler.java**: Implements the core functionality for all file system operations.

## File System Operations
This shell implements the following file system operations using Java's `java.io.File` class:
- Directory creation using `File.mkdir()`
- File creation using `File.createNewFile()`
- Directory navigation using `File` objects
- File/directory existence verification using `File.exists()`
- Directory content listing using `File.listFiles()`

## Getting Started

### Compilation
Compile the Java files using javac:
```bash
javac MiniShell.java ShellCommandHandler.java
```

### Running the Application
Run the compiled main class:
```bash
java MiniShell
```

## Usage Guide

Once the shell is running, you'll see a prompt displaying your current directory followed by `>`. You can execute the following commands:

| Command | Description | Usage |
|---------|-------------|-------|
| `pwd` | Print working directory | `pwd` |
| `ls` | List files in current directory | `ls` |
| `cd [dir]` | Change directory | `cd directory_name` or `cd ..` (to go up one level) |
| `mkdir [dir]` | Create new directory | `mkdir directory_name` |
| `touch [file]` | Create new file | `touch file_name` |
| `help` | Display help information | `help` |
| `exit` | Exit the program | `exit` |

## Example Session
```
Welcome to MiniShell! Type 'help' for a list of commands.
/home/user > pwd
this is the Absolute path of you current directory: /home/user
/home/user > mkdir test_folder
Directory created: test_folder
/home/user > cd test_folder
Changed directory to: /home/user/test_folder
/home/user/test_folder > touch hello.txt
File created: hello.txt
/home/user/test_folder > ls
Files and directories in this directory: /home/user/test_folder
[FILE] hello.txt
/home/user/test_folder > cd ..
Changed directory to: /home/user
/home/user > exit
```

## Project Structure
```
MiniShell/
├── MiniShell.java        # Main shell interface
├── ShellCommandHandler.java  # Command implementation
└── README.md             # Project documentation
```

## Implementation Notes

The project uses Java's `File` class instead of the newer `Path` API. Key differences:
- `File` objects represent files or directories and provide basic operations.
- `Path` objects (from java.nio.file package) are more modern and flexible, supporting advanced operations and better handling of different file systems.

## Author
By: Malak AbedAllah
