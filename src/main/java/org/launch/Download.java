e org.launch;

import org.to2mbn.jmccc.mcdownloader.MinecraftDownloader;
import org.to2mbn.jmccc.mcdownloader.MinecraftDownloaderBuilder;
import org.to2mbn.jmccc.mcdownloader.download.DownloadCallback;
import org.to2mbn.jmccc.mcdownloader.download.DownloadTask;
import org.to2mbn.jmccc.mcdownloader.download.concurrent.CallbackAdapter;
import org.to2mbn.jmccc.option.MinecraftDirectory;


public class Download {
    public static void DownloadMinecraft(String Version,String Directory)
    {
        MinecraftDownloader downloader= MinecraftDownloaderBuilder.buildDefault();
        downloader.downloadIncrementally(new MinecraftDirectory(Directory), Version, new CallbackAdapter<>()
        {
            @Override
            public void done(org.to2mbn.jmccc.version.Version result)
            {
                System.out.println("Download Mission Succeed!");
                super.done(result);
            }
            public <R>DownloadCallback<R>taskStart(DownloadTask<R> task)
            {
                return new CallbackAdapter<R>()
                {
                    @Override
                    public void done(R result)
                    {
                        System.out.println("Download Package Successfully!");
                        super.done(result);
                    }
                    @Override
                    public void failed(Throwable e)
                    {
                        System.out.println("ERROR:Download Failed!");
                    }
                    @Override
                    public void cancelled()
                    {
                        System.out.println("WARNING:Download Mission Has Been Cancelled!");
                    }
                    public void updateProgress(long done,long total)
                    {
                        System.out.println("INFO:Download Mission Update");
                    }
                    @Override
                    public void retry(Throwable e,int current,int max)
                    {
                        System.out.println("WARNING: The Mission Stops,Retrying...");
                    }
                };
            }
        });
    }
}
