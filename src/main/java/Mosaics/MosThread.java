package Mosaics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class MosThread {
	
	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	boolean isActive;
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	boolean isPopUp;
	public boolean isPopUp() {
		return isPopUp;
	}
	public void setPopUp(boolean isPopUp) {
		this.isPopUp = isPopUp;
	}
	
	Message message;
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	
	Stack<StackTask>prevTasks;
	public Stack<StackTask> getPrevTasks() {
		return prevTasks;
	}
	public void setPrevTasks(Stack<StackTask> prevTasks) {
		this.prevTasks = prevTasks;
	}
	
	Stack<StackTask> nextTasks;
	public Stack<StackTask> getNextTasks() {
		return nextTasks;
	}
	public void setNextTasks(Stack<StackTask> nextTasks) {
		this.nextTasks = nextTasks;
	}
	
	TaskMap taskMap;
	public TaskMap getTaskMap() {
		return taskMap;
	}
	public void setTaskMap(TaskMap taskMap) {
		this.taskMap = taskMap;
	}
	
	StackScreen currentScreen;
	public StackScreen getCurrentScreen() {
		return currentScreen;
	}
	public void setCurrentScreen(StackScreen currentScreen) {
		this.currentScreen = currentScreen;
	}
	
	String Action;
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	
	Object callerValue;
	public Object getCallerValue() {
		return callerValue;
	}
	public void setCallerValue(Object callerValue) {
		this.callerValue = callerValue;
	}
	
	String callerItemName;
	public String getCallerItemName() {
		return callerItemName;
	}
	public void setCallerItemName(String callerItemName) {
		this.callerItemName = callerItemName;
	}
	
	ArrayList<String> nextTaskNames;
	public ArrayList<String> getNextTaskNames() {
		return nextTaskNames;
	}
	public void setNextTaskNames(ArrayList<String> nextTaskNames) {
		this.nextTaskNames = nextTaskNames;
	}
	
	boolean isInLU;
	public boolean isInLU() {
		return isInLU;
	}
	public void setInLU(boolean isInLU) {
		this.isInLU = isInLU;
	}
	
	boolean isBidiConverted;
	public boolean isBidiConverted() {
		return isBidiConverted;
	}
	public void setBidiConverted(boolean isBidiConverted) {
		this.isBidiConverted = isBidiConverted;
	}
	
	Object delta;
	public Object getDelta() {
		return delta;
	}
	public void setDelta(Object delta) {
		this.delta = delta;
	}
	
	enum contextTypes{NO_TYPE, A, B, C, D};
	public HashMap<String, Object> currentContext;
	
	public MosThread(int tId)
	{
		id=tId;
		isActive=true;
		isPopUp=false;
		prevTasks=new Stack<StackTask>();
		nextTasks = new Stack<StackTask>();
		taskMap = new TaskMap();
		currentScreen = new StackScreen();
		delta = new DLst();
		nextTaskNames=new ArrayList<String>();
		currentContext=new HashMap<String, Object>();
	}
	
	public void clearStack()
	{
		prevTasks=new Stack<StackTask>();
		nextTasks = new Stack<StackTask>();
	}

}
