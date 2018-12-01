package docker;

import java.io.IOException;

public class MySqlDockerContainer {
    private static boolean mySqlContainerStarted;
    private static MySqlDockerContainer mySqlDockerContainer = new MySqlDockerContainer();
    private final DockerCompose dockerCompose = new DockerCompose("src/itest/resources/docker/docker-compose.yml");

    private MySqlDockerContainer(){
    }

    public static MySqlDockerContainer instance() {  return mySqlDockerContainer; }

    public synchronized void startMySqlContainerIfDown(){
        try {
            if(!mySqlContainerStarted){
                dockerCompose.downAndUp();
                mySqlContainerStarted= true;
            }
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }

    public synchronized void stopMySqlContainerIfUp(){
        try{
            dockerCompose.down();
            mySqlContainerStarted = false;
        } catch (IOException e){
            throw new IllegalStateException(e);
        }
    }
}
