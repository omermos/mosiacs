package Mosaics;

import java.util.HashMap;
import java.util.Set;

public class StackTask {
	
	public Stack<StackScreen>screens;
	public Stack<StackScreen> getScreens() {
		return screens;
	}
	public void setScreens(Stack<StackScreen> screens) {
		this.screens = screens;
	}
	
	String taskName;
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	private HashMap<String, Object>dynamicProperties = new HashMap<String, Object>();
	long AAnumerator=0;
	
	public Set<String> getDynamicProperties()
	{
		Set <String> propertiesList = this.dynamicProperties.keySet();
		
	}
	
	public void addIntellisense()
	{
		for(StackScreen screen : this.screens)
		{
			if(this.getDynamicProperties().contains(screen.id)==false)
			{
				this.dynamicProperties.put(screen.id, screen);
			}
		}
	}
	
	public String getGateName(String action)
	{
		String gateName = action.toLowerCase()+"Task";
		return gateName;
	}
	
	public void prapareGateObject(boolean isRPA)
	{
		int sid = Session.getCurrId();
		Object mos = Session.getMos(sid);
		if(mos.ServerGates!=null)
		{
			mos.serverGates.isRPA = isRPA;
			if(mos.currentThread.message!=null)
			{
				mos.serverGates.getType().getField("message").setValue(mos.ServerGates,mos.currentThread.message);
			}
			else
			{
				mos.servergates.getType().getField("message").sertValue(mos.serverGates,mos.systemMessages.OK());
			}
			mos.serverGates.callerValue = mos.currentThread.callerValue;
			mos.serverGates.callerItemName = mos.currentThread.callerItemName;
			mos.sereverGates.Action = mos.currentThread.Action;
			Object task = mos.currentThread.pervTasks.Peek();//peek is in C#, need to verify what is it
			if(task!=null)
			{
				Object taskName = task.taskName;
				Object screen = task.screens.peek();//peek is in C#, need to verify what is it
				if(screen != null)
				{
					//line 3297 in c# project
				}
			}
		}
	}
}
