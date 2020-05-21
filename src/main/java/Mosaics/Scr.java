package Mosaics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*Written by Omer Furman 14/5/2020
 * the class describe screen actions, properties, gates and how to register to the gate
 */

public class Scr {
	
	public int flowControl;
	public int numOfItems;
	public int action;
	
	public long AAAnumerator=0;
	
	public String screenId;
	
	public List<Item> items;
	private List<String> columnNames; // in C# project initialize at the same line
	
	private HashMap<String, Object> dynamicProperties; // in C# project initialize at the same line
	
	
	public Scr()
	{
		dynamicProperties=new HashMap<String, Object>();
		columnNames = new ArrayList<String>(); // in C# is defined by List
		AAAnumerator = Counter.Next();// Counter defined in Mosiacs calss
	}
	
	
	
	
	public String getScreenId() {
		return screenId;
	}




	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}




	public int getFlowControl() {
		return flowControl;
	}




	public void setFlowControl(int flowControl) {
		this.flowControl = flowControl;
	}




	public int getNumOfItems() {
		return numOfItems;
	}




	public void setNumOfItems(int numOfItems) {
		this.numOfItems = numOfItems;
	}




	public int getAction() {
		return action;
	}




	public void setAction(int action) {
		this.action = action;
	}




	public List<Item> getItems() {
		return items;
	}




	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public String getGateName(String currItem)//to continue after the explenation about the Session in C#
	{
		 session// to check with Michal about the meaning of it
		 String gateName=currItem;
				
	}




	public void invokeGate(String currItem, String projectPath, String vars, boolean isRPA )
	{
		isRPA=false;//default value in C# is false
		boolean invoked = false;
		boolean gateExists = false;
		
		LocalDateTime d=LocalDateTime.now();
		LocalDateTime g=LocalDateTime.now();
		LocalDateTime b;
		LocalDateTime c;
		LocalDateTime h;
		LocalDateTime f;
		
		Duration diffEntireFunction;
		Duration diffInits;
		Duration diffPrepareObject;
		Duration diffBefor;
		Duration diffGate;
		Duration diffReturn;
		
		
		
		
		String scrName = screenId;
		String gateName = getGateName(currItem);
		
		Object [] objectToSend;
		b=LocalDateTime.now();
		Object screen = null;
		
		List <Object> objList = new ArrayList<Object>();
		
		session//to continue after the explenation about the Session in C#
		sid//to continue after the explenation about the Session in C#
		Object mos = Mosaics.Session.getMos(sid);// the error will disappire after Session calss be written
		
		
		
		switch(Config.env) //Config is a class, will be written. need to consoult with Michal as Config is saved word
		{
			case Config.languages.NET:
				prepareGateObject(isRPA);// prepareGateObject is a function in Scr will be written
				break;
			case Config.languages.COBOL:
				screen=prepareCobolGateObject();//prepareCobolGateObject will be written
				break;
		}
		c = LocalDateTime.now();
		if(mos.ServerGates!=null)
		{
			HashMap<String, String> currScreenName = getScreenTypeName();//getScreenTypeName will be written
			
			String taskName = currScreenName.get("taskName");//to check with Michal if the meaning is to bring the value of the key "taskname"
			String screenName = currScreenName.get("screenName");
			
			boolean isCms = (taskName=="scmsView");				
			boolean isMdp= (session["MOSCompany"].ToString() == "Acme" && session["MOSProject"].ToString() == "Coyote" && (screenName == "userDetails" || screenName == "userProject"));
			//was copied from the C#, translate it after to Java
			
			Method serverGate = null;
			
			if(isCms)
			{
				mos.currentThread.delta.converBidi=false;
			}
			else
			{
				mos.currentThread.delta.convertBidi=true;
			}
			
			switch (Config.env)
			{
				case Config.languges.NET:
					serverGate = getGateMethod(taskName,screenName,gateName);
					break;
					
				case Config.languages.COBOL:
					serverGate=getCobolGateMethod(screen,gateName);
					break;
			}
			
			
			if (serverGate !=null)
			{
				if(gateName=="finishScreen"&& isMdp)
					objList.add(projectPath+"../../");
			}
			if((vars!="")||(isMdp))
			{
				objList.add(vars);
			}
			objectToSend=objList.toArray();
			
			switch (Config.env)
			{
				case Config.languges.NET:
					if(mos.serverGates.getType()!=null&&mos.ServerGates.getType().getProperty(taskName)!=null)
						{
							gateExists=true;
						}
					break;
					
				case Config.languages.COBOL:
					gateExists=(serverGate!=null);
					break;
			}
			if (gateExists)
			{
				Object currTaskObj=null;
				Object currScreenObj = null;
				switch (Config.env)
				{
					case Config.languges.NET:
						currTaskObj=mos.ServerGates.getType().getProperty(taskName).GetValue(mosServerGates);
						currScreenObj=currTaskObj.GetType.GetField(screenName).GetValue(currTaskObj);
						break;
				}
				try
				{
					d = LocalDateTime.now();
					switch(Config.env)
					{
					case Config.languges.NET:
						serverGate.invoke(currScreenObj, objectToSend);
						break;
					case Config.Languges.COBOL:
						serverGate.invoke(screen, objectToSend);
						break;
					}
				}catch (InvocationTargetException ex)
				{
					if (!(ex.getCause() instanceof EndGateException))
					{
						//throw ex.InnerException;
						RuntimeException e = (RuntimeException) ex.getCause();
						while (e.getCause() != null)
						{
							e = (RuntimeException) e.getCause();
						}
						
						mos.currentThread.message=new Message("",Message.MessageSevirity.OK,false);
						mos.currentThread.message.Text=e.getMessage();
						mos.currentThread.message.Sevirity=Message.MessageSevirity.Error;
					}
					
				}catch (Exception exc)
				{
					objList.add(0, currItem);
					objectToSend=objList.toArray();
					try
					{
						switch (Config.env)
						{
						case Config.languages.NET:
							serverGate.invoke(currScreenObj, objectToSend);
							break;
						}
					}
					catch(Exception ex)
					{
						mos.currentThread.message.Text=ex.getMessage();
						mos.currentThread.message.Sevirity=Message.MessageSevirity.Error;
					}
				}
				h=LocalDateTime.now();
				invoked=true;
				Session.setMos(mos,sid);
				
				switch(Config.env)
				{
					case Config.languages.NET:
						returnFromGate();
						break;
					case Config.languages.COBOL:
						returnFromCobolGate(screen);
						break;
				}
				f= LocalDateTime.now();
				diffEntireFunction=Duration.between(g,f);
				diffInits=Duration.between(g,b);
				diffPrepareObject.between(b,c);
				diffBefor.between(d,c);
				diffGate.between(d,h);
				diffReturn.between(h,f);
				
			}
			
			
			
					
		}
		if(!invoked&&mos.currentThread.isBidiConverted)
		{
			Session.setMos(mos,sid);

		}



	}
	

}
