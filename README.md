# Download Organizer

## What does it do?
This Java program is designed to periodically move files from a source directory (in this case, C:\\Users\\abdik\\Downloads) to destination directories based on their file type (extension). The program achieves this by running a task at fixed intervals (every 5 seconds).

1. Main Execution (MainProgram Class):
    - The program starts execution from the main method.
    - It creates a ScheduledExecutorService with a single thread (newSingleThreadScheduledExecutor()) to schedule tasks at fixed intervals.
    - A task (an instance of Runnable) is scheduled to run every 5 seconds (scheduleAtFixedRate() method).
    - This scheduled task calls the _Excute() method every 5 seconds.
2. _Excute() Method:
    - This method calls the FileToMove() method multiple times to move files based on their extensions (e.g., .jpg, .png, .pdf, etc.).
    - For each file type (such as "jpg", "pdf", "zip"), it attempts to move the matching files from C:\\Users\\abdik\\Downloads to corresponding directories like C:\\Users\\abdik\\Downloads\\Pictures, C:\\Users\\abdik\\Downloads\\Text, C:\\Users\\abdik\\Downloads\\Audio, etc.
    - The method checks for different file extensions and categorizes files accordingly.
3. FileToMove() Method:
    - Parameters:
        - type: The file extension to search for (e.g., "jpg", "pdf", "zip").
        - Where: The source directory where the files are located (in this case, C:\\Users\\abdik\\Downloads).
        - MoveTo: The target directory where the matched files should be moved.
    - Functionality:
        - The method creates a Path object for the target directory (MoveTo).
        - It retrieves the list of files in the Where directory using listFiles().
        - It then checks each file in the directory:
        - If a file has an extension (checked by the lastIndexOf(".") method), it compares the file extension with the provided type.
        - If the file extension matches, it checks if the target directory exists; if not, it creates it using mkdir().
        - Finally, it moves (renames) the file by using renameTo(), placing the file in the appropriate target directory.
4. Key Observations:
    - Directory Creation: If the target directory (like Pictures, Text, etc.) does not exist, it will be created.
    - File Moving: Files are moved by renaming them and putting them in the correct folder based on their extensions.
    - File Types: The program handles various file types, such as image files (jpg, png), document files (pdf, docx), audio files (wav, mp3), compressed files (zip), and more.
    - Repetition: The task runs every 5 seconds, which means the program checks for new files and moves them as they appear in the source directory.

Example Execution Flow:
    1. The program starts and begins checking the source directory (C:\\Users\\abdik\\Downloads) every 5 seconds.
    2. It looks for files with extensions like .jpg, .png, .pdf, etc.
    3. If a .jpg file is found, it moves it to C:\\Users\\abdik\\Downloads\\Pictures.
    4. If a .pdf file is found, it moves it to C:\\Users\\abdik\\Downloads\\Text.
    5. This process continues in a loop every 5 seconds.