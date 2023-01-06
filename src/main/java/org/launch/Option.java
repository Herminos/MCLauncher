package org.launch;

import java.util.Objects;
import java.util.Scanner;

import static org.launch.Launch.LaunchGame;

public class Option
{
    public static void GetHelp()
    {
        System.out.println("Type \"v\" to set the version(defaults to 1.11.2)");
        System.out.println("Type \"n\" to set the playername(defaults to \"ID\")");
        System.out.println("Type \"d\" to set the Minecraft game directory(defaults to \"minecraft\"(Warning:Most Windows computer's Minecraft directory is\".minecraft\")");
    }
    public static void SetOptions()
    {
        System.out.println("Set Options");
        String version="1.11.2";
        String Directory="minecraft";
        String PlayerName="ID";
        while(true)
        {
            Scanner scanner=new Scanner(System.in);
            String input=scanner.next();
            System.out.println(input);
            if(Objects.equals(input, "v"))
            {
                System.out.println("Set version");
                Scanner scanner1=new Scanner(System.in);
                version=scanner1.nextLine();
            }
            else if(Objects.equals(input, "n"))
            {
                System.out.println("Set playername");
                Scanner scanner1=new Scanner(System.in);
                PlayerName=scanner1.nextLine();
            }
            else if(Objects.equals(input, "d"))
            {
                System.out.println("Set directory");
                Scanner scanner1=new Scanner(System.in);
                Directory=scanner1.nextLine();
            }
            else if(Objects.equals(input, "help"))
            {
                GetHelp();
            }
            else if(Objects.equals(input, "launch"))
            {
                LaunchGame(version,PlayerName,Directory);
                break;
            }
        }
    }
}
