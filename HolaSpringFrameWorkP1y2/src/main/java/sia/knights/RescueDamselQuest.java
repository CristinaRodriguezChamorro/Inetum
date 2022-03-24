package sia.knights;

import java.io.PrintStream;

public class RescueDamselQuest implements Quest {
  private PrintStream stream;

  public RescueDamselQuest() {}	
  
  public RescueDamselQuest(PrintStream stream) {
	    this.stream = stream;
  }
	 
  
public void embark() {
	  
	  stream.println("Embarking on a quest to rescue the damsel.");
  }

}
