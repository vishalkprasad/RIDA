import java.util.Arrays;
import java.util.Map;
import javapasswordsdk.*;
import javapasswordsdk.exceptions.*;
 
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class GPVPasswordSDK {
   
    private PSDKPassword password = null;
    private PSDKPasswordRequest passRequest = null;
    private Properties gpvprop = null;
   
   
    public GPVPasswordSDK(){
        try {
            passRequest = new PSDKPasswordRequest();
            this.setPassRequestParams();
           
        }catch (PSDKException ex) {
            ex.printStackTrace();
        }
    }
   
    public void setPassRequestParams() {
        gpvprop = new Properties();
        InputStream iStream = null;
        String env = null;
        String propFileLocation = null;
       
        try {
            env = System.getenv("CATALINA_HOME");
            try {
                if (env != null) {
                    propFileLocation = env + "/conf/gpv.properties";
                }else {
                    throw new Exception ("Environment Variable CATALINA_HOME is not available.");
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            iStream = new FileInputStream(propFileLocation);
            gpvprop.load(iStream);
            passRequest.setAppID(gpvprop.getProperty("gpv.appID"));
            passRequest.setSafe(gpvprop.getProperty("gpv.safe"));
            passRequest.setFolder(gpvprop.getProperty("gpv.folder"));
            passRequest.setObject(gpvprop.getProperty("gpv.object"));
            passRequest.setReason(gpvprop.getProperty("gpv.reason"));
           
        }catch (IOException e) {
            e.printStackTrace();
        }catch(PSDKException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                if(iStream != null) {
                    iStream.close();
                }
            }catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }
       
    public String getPassword() {
        System.out.println("App ID: " + gpvprop.getProperty("gpv.appID"));
        System.out.println("Safe Name: " + gpvprop.getProperty("gpv.safe"));
        System.out.println("Folder: " + gpvprop.getProperty("gpv.folder"));
        System.out.println("Object Name: " + gpvprop.getProperty("gpv.object"));
        System.out.println("Reason: " + gpvprop.getProperty("gpv.reason"));
        char[] content = null;
       
        try {
            password = PasswordSDK.getPassword(passRequest);
            content = password.getSecureContent();
        }catch (PSDKException ex) {
            ex.printStackTrace();
        }
        return String.valueOf(content);
       
    }
   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        GPVPasswordSDK gpv = new GPVPasswordSDK();
        System.out.println(gpv.getPassword());
 
    }
 
}
 
