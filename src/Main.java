import java.io.IOException;
public class Main {
    public static void main (String[] args) throws IOException{
        String userSource = "C:\\Users\\timfe\\IdeaProjects\\java-au\\Generator\\src\\solution.txt";
        String source = "C:\\Users\\timfe\\IdeaProjects\\java-au\\Generator\\src\\LinkedList.md";
        String userSolutionContent = IOUtils.readFile(userSource);
        String odlFileContent = IOUtils.readFile(source);
        String newFileContent = Generate.getNewContent(userSolutionContent, odlFileContent, source);
        if (newFileContent != null){
            IOUtils.writeToFile(source, newFileContent);
        }
    }
}