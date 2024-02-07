package helpers;

public class environment {

    private static String env;

    public static String getBaseURL(String path) throws Throwable {
        return chooseURL(path);
    }

    public static String chooseEnv(){

        env = System.getProperty("ENV");

        if (env == null){
            env = System.getenv("ENV");
            if (env == null){
                env = "prod";
            }
        }
        return env;
    }

    private static String chooseURL(String path) {
        switch (chooseEnv())
        {
            case "dev":    env = "https://dev.google.com/" + path; break;
            case "qa":      env = "https://qa.google.com/" + path; break;
            case "uat":     env = "https://uat.google.com/" + path; break;
            case "prod":    env = "https://www.google.com/" + path;
        }
        return env;
    }
}
