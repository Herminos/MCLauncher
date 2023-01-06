package org.launch;

import org.to2mbn.jmccc.auth.OfflineAuthenticator;
import org.to2mbn.jmccc.exec.GameProcessListener;
import org.to2mbn.jmccc.launch.LaunchException;
import org.to2mbn.jmccc.launch.Launcher;
import org.to2mbn.jmccc.launch.LauncherBuilder;
import org.to2mbn.jmccc.option.LaunchOption;
import org.to2mbn.jmccc.option.MinecraftDirectory;

import java.io.IOException;

public class Launch {
    public static void LaunchCore(String version,String PlayerName,String Directory,int MaxMemory,int MinMemory) throws IOException, LaunchException
    {

        Launcher launcher= LauncherBuilder.create()
                .setDebugPrintCommandline(true).setNativeFastCheck(false).build();
        LaunchOption option=new LaunchOption(version,new OfflineAuthenticator
                (PlayerName), new MinecraftDirectory(Directory));
        option.setMaxMemory(MaxMemory);
        option.setMinMemory(MinMemory);
        GameProcessListener ConsoleListener= new GameProcessListener()
        {
            @Override
            public void onLog(String log)
            {
                System.out.println("[INFO]:"+log);
            }

            @Override
            public void onErrorLog(String log)
            {
                System.out.println("[ERROR]:"+log);
            }

            @Override
            public void onExit(int code)
            {
                System.out.println("[EXIT]:The process exit with exit code: "+code);
            }
        };
        launcher.launch(option,ConsoleListener);
    }
    public static void LaunchGame(String version,String PlayerName,String Directory,int MaxMemory,int MinMemory)
    {
        try
        {
            LaunchCore(version,PlayerName,Directory,MaxMemory,MinMemory);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        catch(LaunchException e)
        {
            System.out.println(e);
        }
    }
}
