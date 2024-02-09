import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConnMaker {
    String PC_Name;
    String Database_Name;
    String Security_Check;

    ConnMaker(String pc , String database_Name , String Security){
        this.PC_Name=pc;
        this.Database_Name = database_Name;
        this.Security_Check = Security;
    }
    public String MakeString(){
        return "Server="+PC_Name+";Database="+Database_Name+";Integrated_Security="+Security_Check+"";
    }

    public void getConnectionFile(String connectionString) throws IOException {

        File newFile = new File("ConnectionString.json");

        try{

            newFile.createNewFile();

        }catch (Exception e){

            System.out.println("unable to create this file because :"+e);

        }

        FileWriter writefile = new FileWriter("ConnectionString.json");

        writefile.write("" +
                "{\n" +
                "  \"ConnectionStrings\": {\n" +
                "    \"myDb1\": \""+connectionString+"\"\n"+
                "  }\n" +
                "}");

        writefile.close();
    }

    public static void main(String[] args) throws IOException {

        ConnMaker obj = new ConnMaker("Desktop-RF95T7","wadood","True");

        String result =
                obj.MakeString();
        obj.getConnectionFile(result);
    }
}
