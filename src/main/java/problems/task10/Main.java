package problems.task10;

public class Main {
    public static void main(String[] args) {
        String classesPath = "problems.task10.classes";
        InfoClass infoClass = new InfoClass(classesPath + ".Human");
        infoClass.showClassInfo();
        infoClass = new InfoClass(classesPath + ".Lecturer");
        infoClass.showClassInfo();
        infoClass = new InfoClass(classesPath + ".Teacher");
        infoClass.showClassInfo();
    }
}
