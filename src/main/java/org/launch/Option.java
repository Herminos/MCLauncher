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
        System.out.println("Type \"d\" to set the Minecraft game directory(defaults to \"minecraft\"(Warning:Most Windows computer's Minecraft directory is\".minecraft\"))");
        System.out.println("Type \"advhelp\" to get the advance option-setting help");
    }
    public static void GetAdvanceHelp()
    {
        System.out.println("Type \"maxm\" to set the JVM's MaxMemory");
        System.out.println("Type \"minm\" to set the JVM's MinMemory");
    }
    public static void SetOptions()
    {
        System.out.println("Set Options");
        String version="1.11.2";
        String Directory="minecraft";
        String PlayerName="ID";
        int MaxMemory=0;
        int MinMemory=0;
        while(true)
        {
            Scanner scanner=new Scanner(System.in);
            String input=scanner.next();
            System.out.println(input);
            if(Objects.equals(input, "v"))
            {
                System.out.println("Set Version");
                Scanner scanner1=new Scanner(System.in);
                version=scanner1.nextLine();
                System.out.println("New Version:"+version);
            }
            else if(Objects.equals(input, "n"))
            {
                System.out.println("Set Playername");
                Scanner scanner1=new Scanner(System.in);
                PlayerName=scanner1.nextLine();
                System.out.println("New Playername:"+PlayerName);
            }
            else if(Objects.equals(input, "d"))
            {
                System.out.println("Set Directory");
                Scanner scanner1=new Scanner(System.in);
                Directory=scanner1.nextLine();
                System.out.println("New Directory:"+Directory);
            }
            else if(Objects.equals(input,"maxm"))
            {
                System.out.println("Set JVM's MaxMemory(MB)(0 for default)");
                Scanner scanner1=new Scanner(System.in);
                MaxMemory=scanner1.nextInt();
                if(Objects.equals(MaxMemory,0))
                    System.out.println("New JVM's MaxMemory: default");
                else
                    System.out.println("New JVM's MaxMemory: "+MaxMemory);
            }
            else if(Objects.equals(input,"minm"))
            {
                System.out.println("Set JVM's MinMemory(MB)(0 for default)");
                Scanner scanner1=new Scanner(System.in);
                MinMemory=scanner1.nextInt();
                if(Objects.equals(MaxMemory,0))
                    System.out.println("New JVM's MinMemory: default");
                else
                    System.out.println("New JVM's MinMemory: "+MinMemory);
            }
            else if(Objects.equals(input, "help"))
            {
                GetHelp();
            }
            else if(Objects.equals(input,"advhelp"))
            {
                GetAdvanceHelp();
            }
            else if(Objects.equals(input, "launch"))
            {
                LaunchGame(version,PlayerName,Directory,MaxMemory,MinMemory);
                break;
            }
            else
            {
                System.out.println("Unknown Command,Type \"help\" to check your syntax");
            }
        }
    }
}
