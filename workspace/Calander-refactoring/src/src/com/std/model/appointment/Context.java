package src.com.std.model.appointment;

public class Context {
		// takes a state so it updated it.
	   private State state;
	   
	   
	   //a constructor.
	   public Context(){
		   
	      state = null;
	   }
	   /**
	    * a void method to set the state.
	    * @param state
	    */
	   public void setState(State state){
	      this.state = state;		
	   }
	   /**
	    * 
	    * @return the state.
	    */
	   public State getState(){
	      return state;
	   }
}
