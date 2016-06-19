package game;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.github.ToK.server.main.Main;

/**
 *  Class Save
 *  
 *  The classes SaveAdmin and SavePlayer save the created player in a binary document.
 *  
 *  @author Constantin Schulte
 *  @version 0.0
 */

abstract class SaveAdmin {
	public static void save(Admin adminToSave){
		  try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("player_"+Main.IP+".bin"))){
			  out.writeObject(adminToSave);
			  System.out.println("Speichern erfolgreich");
		  }catch(Exception e){
			  System.err.println("Speichern fehlgeschlagen");
		  }
	  }
}

abstract class SavePlayer {
	public static void save(NormalPlayer playerToSave){
		  try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("player_"+Main.IP+".bin"))){
			  out.writeObject(playerToSave);
			  System.out.println("Speichern erfolgreich");
		  }catch(Exception e){
			  System.err.println("Speichern fehlgeschlagen");
		  }
	  }
}
