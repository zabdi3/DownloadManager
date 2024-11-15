import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class App {
	 public static void main(String[] args)
	 {
		    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		    executorService.scheduleAtFixedRate(new Runnable()
		    {
		        @Override
		        public void run() 
		        {
		        	_Excute();
		        }
		    }, 0, 5, TimeUnit.SECONDS);
		    
	 }
	 
	 public static void _Excute()
	 {
		 FileToMove("jpg", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Pictures");
		 FileToMove("JPG", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Pictures");
		 FileToMove("png", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Pictures");

		 FileToMove("pdf", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Text");
		 FileToMove("docx", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Text");
		 FileToMove("java", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Text");
		 FileToMove("rtf", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Text");

		 FileToMove("wav", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Audio");
		 FileToMove("mp3", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Audio");
		 
		 
		 FileToMove("zip", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Zip");
		 FileToMove("exe", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\EXE");
		 
		 FileToMove("html", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\HTML");

		 FileToMove("torrent", "C:\\Users\\abdik\\Downloads", "C:\\Users\\abdik\\Downloads\\Torrents");
	 }
	 
	 public static void FileToMove(String type, String Where, String MoveTo) 
	 {
		  Path _target = new File(MoveTo).toPath();
		  File dir = new File(Where);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) 
		  {
		    for (File child : directoryListing) 
		    {
		    	int i = child.getName().lastIndexOf(".");		    	
		    	if (i >= 0) 
		    	{		   		    		
		    	    if(type.equals(child.getName().substring(i+1))) 
		    	    {	    	
		    	    	if(Files.exists(_target) == false) 
		    	    	{
		    	    		new File(MoveTo).mkdir();	
		    	    	}
	    	    		child.renameTo(new File(MoveTo, "." + child.getName()));
		    	    }
		    	}
		    }
		  }
	 }
	 
}