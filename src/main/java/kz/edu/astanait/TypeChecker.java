package kz.edu.astanait;

public class TypeChecker implements Check{
    private static TypeChecker instance = new TypeChecker();
    private TypeChecker(){}
    public static TypeChecker getInstance(){
        return instance;
    }
    /*
      TypeChecker object = Typechecker.getInstance();
    */
    @Override
    public String check(String choice) throws NullPointerException{
        switch(choice){
            case "image": return "C:\\Database\\images\\";
            case "music": return "C:\\Database\\music\\";
            case "document": return "C:\\Database\\docs\\";
        }
        return "C:\\Database\\";
    }
}
