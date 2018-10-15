/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rems;

/**
 *
 * @author Anandhu Anil
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import org.omg.CORBA.portable.InputStream;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class calltime implements Job{
    String r;
    int i;
    public void execute(JobExecutionContext jec) throws JobExecutionException {
      Connection con = dbclaz.dbConnector();
       
        System.out.println("The sheduler is running and on the go");
        System.out.println("The timee is "+ new Date());
         String pattern = "yyyy-MM-dd HH:mm";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
         String date = simpleDateFormat.format(new Date());
         String d = date.substring(0,10);
         String t = date.substring(11,16);
        try {
            String query ="SELECT * FROM `myrem` WHERE `day`=? AND `time`= ?";
					PreparedStatement pst= con.prepareStatement(query);
					pst.setString(1, d);
					pst.setString(2, t);
					ResultSet rs=pst.executeQuery();
					int count =0;
					while(rs.next())
					{
                                        
					count++;
                                        r=rs.getString("Reminder");
                                        i=rs.getInt("id");
					}
					if(count == 1)
					{
					music();
                                        int dg=JOptionPane.YES_NO_OPTION;
                                        int dr = JOptionPane.showConfirmDialog(null,r,"Times Up",dg);
                                        
                                         JOptionPane.showMessageDialog(null, r);
                                         if(dr==JOptionPane.YES_NO_OPTION)
                                         {
                                             AudioPlayer.player.stop();
                                             String sq="DELETE FROM `myrem` WHERE `id`=?";
                                             PreparedStatement ss=con.prepareStatement(sq);
                                             ss.setInt(1, i);
                                             ss.execute();
                                             new Home().setVisible(true);
                                             
                                             
                                             
                                         }
                                         
                                         
						
					}
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    public static void music() {
    
        String fpath;
        fpath = "src\\audio\\alarm.wav";
          FileInputStream m;
          try {
              m= new FileInputStream(new File(fpath));
              AudioStream audios=new AudioStream(m);
              AudioPlayer.player.start(audios);
          } catch (IOException e) {
              e.printStackTrace();
          }
    
    }
    
}
