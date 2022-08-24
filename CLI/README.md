
Steps to run in command prompt :
- Simply build the java program than you can see the .jar file in the artifacts directory(out/artifacts). Recommended to access it via file explorer.
- Open the terminal in the directory, and type this command in the command prompt. "java -jar jarName.jar sync -s yourPath\sourceDir -d yourPath\targetDir".
- sync : command to do by the java application
- jarName : the name of your .jar file
- -s : the command followed by the source path
- yourPath\sourceDir : path to source directory to sync (E.g. E:\Accelbyte\source_dir_a)
- -d : the command followed by the destination path
- yourPath\targetDir : path to target directory to sync (E.g. E:\Accelbyte\target_dir)

Note that after the .jar file is generated, it can be moved to anywhere as long as the java command is accessible. 

Note that not every error handling is implemented. The program would simply put out the Exception happening in the application.