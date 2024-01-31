package helpers;

public class envHelper {

    private static String env;

    public static String getBaseURL(String path) throws Throwable {
        return chooseURL(path);
    }

    public static String chooseEnv(){

        env = System.getProperty("ENV");

        if (env == null){
            env = System.getenv("ENV");
            if (env == null){
                env = "qa";
            }
        }
        return env;
    }

    private static String chooseURL(String path) {
        switch (chooseEnv())
        {
            case "dev":    env = "www.google.com" + path; break;
            case "uat":     env = "https://courses.ultimateuat.com" + path;    break;
            case "qa":      env = "https://courses.ultimateqa.com" + path;
        }
        return env;
    }
}
