package Mosaics;

import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.Type;

import Mosaics.Message.MessageSeverity;

public class MosStack {
	boolean abort;
	boolean isAbort() {
		return abort;
	}
	public void setAbort(boolean abort) {
		this.abort = abort;
	}
	
	MosThread currentThread;
	public MosThread getcurrentThread() {
		return currentThread;
	}
	public void setcurrentThread(MosThread currentThread) {
		this.currentThread = currentThread;
	}
	
	ArrayList<MosThread>threads;
	public ArrayList<MosThread> getThreads() {
		return threads;
	}
	public void setThreads(ArrayList<MosThread> threads) {
		this.threads = threads;
	}

	Object messages;
	public Object getMessages() {
		return Messages;
	}
	public void setMessages(String companyName,String projectName) { 
		boolean isMdp = (companyName =="Acme" && projectName == "Coyote");
		if(isMdp)
		{
			messagesType = Type.getType("MosaicsAtAcmeCoyote.Messages");
			systemMessages = Type.getType("MosiacsAtAcmeCoyote.SystemMessages");
		}
		else if (!MosUtils.isMosaics())
		{
			if(companyName!="" && projectName!="")
			{
				//to sit with Michal, no asembley varable in Java and about all this function
			}
		}
	}
	
	public MosStack(String taskMapString,int ThreadId, Boolean isRPA)
	{
		// to sit with Michal, in C# it's defined as real thread, need to verify it
	}
	public MosStack (int threadId, boolean isRPA )
	{
		// to sit with Michal, in C# it's defined as real thread, need to verify it	
	}
	
	public void addIntellisense()//need to complete this function
	{
		foreach(StackTask task : currentThread.prevTask)
		{
			if(getDynamicProperties().)//get back to that after that
			{
				dynamicProperties.put(task.taskName, task);
			}
			else
				if(!dynamicProperties.containsValue(task))
				{
					dynamicProperties.put(task.taskName, task);
				}
		}
		foreach(StackTask task : currentThread.nextTasks)
		{
			if (task.taskName.equals(this.getDynamicProperties())
		}
	}
	
	public void clearIntellisense()
	{
		dynamicProperties.clear();
	}
	
	public void updateCurrentThread(int threadId)// to complete after the mosThread
	{
		MosThread newThread = getThreadById(threadId);
		boolean isExistingThread = (newThread !=null);
		if(isExistingThread)
		{
			currentThread=newThread;
		}
		else
		{
			newThread = new MosThread(threadId);
			currentThread = newThread;
			threads.Add(currentThread);
		}
	}
	
	public Method getGateMethod (Type appGatesType, String gateName)
	{
		Type gatesType = Type.getType(gateAttribute);
		Method prop;//to sit with Michal about that;
		return prop;
	}
	
	public void returnFromAppGate(Object gatesObject)
	{//to sit with Michal about all this function, in C# line 2869
		try
		{
			Object sysdate = gatesObject.get_ext_curr_date();
			serverGates.varsToSend.add("systemDate",sysDate);
		}
		catch (Exception ex) {
			Object res = ((Object)gatesObject).
		}
		
		
		
	}
	
	public void invokeAppGate(Type appGatesType, String gateName, boolean mosAbort, boolean isRPA)
	{
		Object [] objectToSend;
		ArrayList<Object> objList = new ArrayList<Object>();
		String sid = Session.getCurrId();
		Method method ;//to sit with Michal, line 2903
		Object aggGates;//to sit with Michal, line 2904
		
		if (serverGates!=null)
		{
			Method serverGate = getGateMethod(appGatesType, gateName);
			if(serverGate!=null)
			{
				try
				{
					this.currentThread.message = new Message("",MessageSeverity.OK,false);
					 Object[] args = new Object[] { this.currentThread, false, isRPA };
					 serverGate.invoke(aggGates, args);
					 mosAbort=(boolean)args[1];
				}catch (InvocationTargetException ex) {
					if(!(ex.equals(EndGateException)))
					{
						if(serverGates.message==null)//need to fix the serverGates*********note for 20.5.2020
						{
							serverGates.message = new Message("",Message.MessageSeverity.OK,false);
						}
						/*this is c# code: need to convert it to java
						 * ServerGates.message.Text = ex.InnerException.Message;
                            ServerGates.message.Severity = Message.MessageSeverity.Error;
						 */
					}
				}
				returnFromAppGate(appGates);
			}
		}
		Session.setMos(mos, sid);
	}

		
	
	Object systemMessages;
	public Object getSystemMessages() {
		return systemMessages;
	}
	public void setSystemMessages(Object systemMessages) {
		this.systemMessages = systemMessages;
	}
	
	private Object messagesType;
	public Object getMessagesType() {
		return messagesType;
	}
	public void setMessagesType(Object messagesType) {
		this.messagesType = messagesType;
	}
	
	private Object systemMessagesType;
	public Object getSystemMessagesType() {
		return systemMessagesType;
	}
	public void setSystemMessagesType(Object systemMessagesType) {
		this.systemMessagesType = systemMessagesType;
	}
	
	Scr screenItem;
	public Scr getScreenItem() {
		return screenItem;
	}
	public void setScreenItem(Scr screenItem) {
		this.screenItem = screenItem;
	}
	
	Object serverGates;
	public Object getServerGates() {
		return serverGates;
	}
	public void setServerGates(Object serverGates) {
		this.serverGates = serverGates;
	}
	
	private HashMap<String, Object> dynamicProperties;
	//in the C# project the dynamicProperties has the functions: trySetMamber, TryInvokeMemnber.getDYnamicProperties,getDynamicproperty;
	public HashMap<String, Object> getDynamicProperties() {
		return dynamicProperties;
	}
	public void setDynamicProperties(HashMap<String, Object> dynamicProperties) {
		this.dynamicProperties = dynamicProperties;
	}
	
	public MosThread getThreadById (int threadId) //to complete after building MosThread class
	{
		MosThread thrd = threads.
	}
	
	public MosThread getLatestThreadByTask(String taskId)//to complete after building MosThread class
	{
		
	}
	
	
	
	
	
	

}
