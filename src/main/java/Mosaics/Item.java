package Mosaics;

import java.awt.Window.Type;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.Bidi;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.format.DecimalStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Written by Omer Furman 13/05/2020
/The class is an Item Object represent Items*/ 

public class Item {
	String itemName;
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	String mask;
	public String getMask() {
		return mask;
	}
	public void setMask(String mask) {
		this.mask = mask;
	}
	
	String style;
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	String control;
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	
	String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	String maxChars;
	public String getMaxChars() {
		return maxChars;
	}
	public void setMaxChars(String maxChars) {
		this.maxChars = maxChars;
	}
	
	String popupTask;
	public String getPopupTask() {
		return popupTask;
	}
	public void setPopupTask(String popupTask) {
		this.popupTask = popupTask;
	}
	
	private boolean _isInScreen=true;
	
	private boolean _grid;
	
	boolean grid;
	public boolean getGrid() {
		return _grid;
	}
	public void setGrid(boolean _grid) {
		boolean changed=(this._grid !=_grid);
		this._grid=_grid;
		if(changed)
		{
			updateDelta();
		}
		
	}
	
	Item gridItem;
	public Item getGridItem() {
		return gridItem;
	}
	public void setGridItem(Item gridItem) {
		this.gridItem = gridItem;
	}
	
	boolean serverGate;
	public boolean isServerGate() {
		return serverGate;
	}
	public void setServerGate(boolean serverGate) {
		this.serverGate = serverGate;
	}
	
	boolean isRealItem;
	public boolean isRealItem() {
		return isRealItem;
	}
	public void setRealItem(boolean isRealItem) {
		this.isRealItem = isRealItem;
	}
	
	boolean isScrollable;
	public boolean isScrollable() {
		return isScrollable;
	}
	public void setScrollable(boolean isScrollable) {
		this.isScrollable = isScrollable;
	}

	boolean progressBar;
	public boolean isProgressBar() {
		return progressBar;
	}
	public void setProgressBar(boolean progressBar) {
		this.progressBar = progressBar;
	}

	boolean confirmation;
	public boolean isConfirmation() {
		return confirmation;
	}
	public void setConfirmation(boolean confirmation) {
		this.confirmation = confirmation;
	}

	boolean isEditableGrid;
	public boolean isEditableGrid() {
		return isEditableGrid;
	}
	public void setEditableGrid(boolean isEditableGrid) {
		this.isEditableGrid = isEditableGrid;
	}

	List <AltPanel>alternatePanels;
	public List<AltPanel> getAlternatePanels() {
		return alternatePanels;
	}
	public void setAlternatePanels(List<AltPanel> alternatePanels) {
		this.alternatePanels = alternatePanels;
	}
	
	List<DynamicAttributes>dynamicAttributes;	
	public List<DynamicAttributes> getDynamicAttributes() {
		return dynamicAttributes;
	}
	public void setDynamicAttributes(List<DynamicAttributes> dynamicAttributes) {
		this.dynamicAttributes = dynamicAttributes;
	}

	List <Item> children;
	public List<Item> getChildren() {
		return children;
	}
	public void setChildren(List<Item> children) {
		this.children = children;
	}

	List <Item> gridHeaders;
	public List<Item> getGridHeaders() {
		return gridHeaders;
	}
	public void setGridHeaders(List<Item> gridHeaders) {
		this.gridHeaders = gridHeaders;
	}
	
	ArrayList <Item> gridItems;
	public ArrayList<Item> getGridItems() {
		return gridItems;
	}
	public void setGridItems(ArrayList<Item> gridItems) {
		this.gridItems = gridItems;
	}
	
	List <Item> gridSelectors;
	public List<Item> getGridSelectors() {
		return gridSelectors;
	}
	public void setGridSelectors(List<Item> gridSelectors) {
		this.gridSelectors = gridSelectors;
	}
	
	List <Item> gridTotal;
	public List<Item> getGridTotal() {
		return gridTotal;
	}
	public void setGridTotal(List<Item> gridTotal) {
		this.gridTotal = gridTotal;
	}
	
	String _attribute;
	String attribute;
	public String getAttribute() {
		return _attribute;
	}
	public void setAttribute(String _attribute) {
		boolean changed = (this._attribute!=_attribute.trim());
		this._attribute=_attribute.trim();
		if(changed)
		{
			
			updateDelta();//explicitAttributeSet:true)--will complete after updateDelta will build
		}
		 
	 
	}
	
	public final void setAttributeInternally(String value)
	{
				boolean changed = (!value.equals(_attribute));
				_attribute = value;
				if (changed)
				{
					updateDelta();
				}
	}
	
	String originalAttrubute;
	boolean blockedForward;
	public boolean isBlockedForward() {
		return blockedForward;
	}
	public void setBlockedForward(boolean blockedForward) {
		this.blockedForward = blockedForward;
	}
	
	boolean blockedBackward;
	public boolean isBlockedBackward() {
		return blockedBackward;
	}
	public void setBlockedBackward(boolean blockedBackward) {
		this.blockedBackward = blockedBackward;
	}
	
	boolean forwardBlocker;
	public boolean isForwardBlocker() {
		return forwardBlocker;
	}
	public void setForwardBlocker(boolean forwardBlocker) {
		this.forwardBlocker = forwardBlocker;
	}

	boolean backwardBlocker;
	public boolean isBackwardBlocker() {
		return backwardBlocker;
	}
	public void setBackwardBlocker(boolean backwardBlocker) {
		this.backwardBlocker = backwardBlocker;
	}
	
	private int _selectedRowIndex;
	
	int selectedRowIndex;
	public int getSelectedRowIndex() {
		return selectedRowIndex;
	}
	public void setSelectedRowIndex(int selectedRowIndex) {
		boolean changed = (_selectedRowIndex != selectedRowIndex);
		_selectedRowIndex=selectedRowIndex;
		if (changed)
		{
			updateDelta();
		}
	}
	
	int firstEmptyIndex=-1;
	
	private String _value;
	private String _defaultValue;
	private String _minValue;
	private String _maxValue;
	
	
	private void updateDelta()//overload function for updateDelta with emptyBrackets
	{
		this.updateDelta(false);
	}
	private void updateDelta(boolean explicitAttributeSet)
	{
		if(isRealItem && _isInScreen)
		{
			int sid = Session.getCurrId();
			MosStack mos = Session.getMos(sid);
			mos.currentThread.delta._addDelta(this,explicitAttributeSet);
			Session.setMos(mos,sid);
		}
	}
	

	String value;
	public String getValue() { //!!!--pay attantion that the getValue return the value of "_value" not "value"--!!!
		return _value;
	}
	public void setValue(String value) {
		String dateRe;
		String zeroRe;
		String rowRegex;
		 boolean dateEmpty; 
		String tempValue = value != null? value.toString():"";
		String oldValue=_value;
		boolean oldIsEmpty=valueIsEmpty;
		if(tempValue=="")
		{
			valueIsEmpty=true;
			_value="";
			if (!oldIsEmpty)
			{
				updateDelta();
			}
			return;
		}
		if(control != null&&control.toLowerCase().contains("checkbox")&&tempValue=="??")
		{
			valueIsEmpty=true;
			_value=tempValue;
			if(!oldIsEmpty)
			{
				updateDelta();
			}
			return;
		}
		dateRe=new String ("^[dmy\\/]*($");
		zeroRe = new String ("^0+$");
		
		
		
		dateEmpty = (mask!=null && dateRe.matches(mask)&&(tempValue == "" || zeroRe.matches(tempValue)));
		if (dateEmpty)
		{
			valueIsEmpty=true;
		}
		else
		{
			valueIsEmpty=false;
		}
		
		Pattern regex=Pattern.compile("^[x0]\\[(\\d+)\\]$");
		Matcher doMatch = regex.matcher(mask);
		
		if(mask!=null && doMatch.matches() && tempValue.length()>Integer.parseInt(doMatch.group(1)))
		{
			_value=tempValue.substring(0,Integer.parseInt(doMatch.group(1)));
		}
		else
		{
			_value=tempValue;
		}
		Pattern rowRegex1 = Pattern.compile("_Row(\\d+)$");
		doMatch = rowRegex1.matcher(itemName);
		if (grid && gridItem != null && doMatch.matches() && !valueIsEmpty && _isInScreen)
		{
			int rowIndex = Integer.parseInt(doMatch.group(1));
			if(rowIndex>=gridItem.firstEmptyIndex)
			{
				gridItem.firstEmptyIndex=rowIndex+1;
			}
		}
		if(grid && gridItem == null)
		{
			String a="";
		}
		if((oldValue==null && _value != null) || oldValue != _value || (oldIsEmpty && !valueIsEmpty))
		{
			updateDelta();
		}
	 
	 boolean valueIsEmpty = true;
     boolean defaultValueIsEmpty = true;
     boolean minValueIsEmpty = true;
     boolean maxValueIsEmpty = true;	 

	}
	
	String defaultValue;
	public String getDefaultValue() {
		return _defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		_defaultValue=defaultValue;
		defaultValueIsEmpty=false;
	}
	
	String minValue;
	public String getMinValue() {
		return _minValue;
	}
	public void setMinValue(String minValue) {
		if(minValue==null)
			_minValue=minValue.toString()+"";
		if(minValue=="")
			return;
		minValueIsEmpty=false;
	}
	
	String maxValue;
	public String getMaxValue() {
		return _maxValue;
	}
	public void setMaxValue(String maxValue) {
		_maxValue=maxValue;
		maxValueIsEmpty=false;
	}
	
    boolean valueIsEmpty = true;
    boolean defaultValueIsEmpty = true;
    boolean minValueIsEmpty = true;
    boolean maxValueIsEmpty = true;
     
    
    String valuePicker;
	public String getValuePicker() {
		return valuePicker;
	}
	public void setValuePicker(String valuePicker) {
		this.valuePicker = valuePicker;
	}
    
	int tabIndex;
	public int getTabIndex() {
		return tabIndex;
	}
	public void setTabIndex(int tabIndex) {
		this.tabIndex = tabIndex;
	}
	
	String origTabIndex;
	public String getOrigTabIndex() {
		return origTabIndex;
	}
	public void setOrigTabIndex(String origTabIndex) {
		this.origTabIndex = origTabIndex;
	}
	
	ArrayList <OptionL> _options;
	ArrayList <OptionL> options;
	public ArrayList <OptionL> getOptions() {
		return this._options;
	}
	public void setOptions(ArrayList <OptionL> options) {
		boolean changed = (_options!=options);
		_options=options;
		if(changed)
		{
			updateDelta();
		}
		
	}
	
	
	public boolean isEmpty()
	{
		if ("Grid CheckBox"==control)
		{
			return "!!" !=value;
		}
		if ("dateFormat"==type)
		{
			String regex = new String ("^0*$");
			return regex.matches(value);
		}
		//to check how to do the type
		if (value.toString()=="" || value.toString()=="0")
		{
			return true;
		}
		return false;
	}
	
	public void clearGrid()
	{
		if(grid)
		{
			int columnsCount=gridHeaders.size();
			int rowsCount = gridItems.size()/columnsCount;
			for (int i=0;i<rowsCount;i++)
			{
				clearGridRow(i);
			}
			selectedRowIndex=-1;
			firstEmptyIndex=getFirstEmptyIndex(true);
		}
		
	}
	public void clearGridRow(int index)
	{
		if(grid)
		{
			int columnsCount=gridHeaders.size();
			int rowsCount=gridItems.size()/columnsCount;
			if(index>=rowsCount)
			{
				return;
			}
			int startIndex = index * columnsCount;
			int endIndex = (index+1) * columnsCount ;
			for (int i=startIndex;i<endIndex;i++)
			{
				gridItems.get(i).setValue(defaultValue);
				if (gridItems.get(i).getValue().toString()=="0")
				{
					gridItems.get(i).setValue("");
				}
				gridItems.get(i).setAttributeInternally(gridItems.get(i).originalAttrubute);
			}
			firstEmptyIndex =  getFirstEmptyIndex(true);
		}
	}
	
	public boolean columnContains(String colName,String val)
	{
		boolean res = false;
		if (grid)
		{
			for (Item currItem : gridItems) {
				int startIdx = currItem.itemName.indexOf("_")+1;
				String currColName = currItem.itemName.substring(startIdx, currItem.itemName.lastIndexOf("_")-startIdx);
				String currVal = currItem._value;
				if(currColName == colName && currVal == val)
				{
					return true;
				}
			}
		}
		return res;
	}
	public boolean isRowActive (int rowIndex)
	{
		int columnsCount = gridHeaders.size();
		for (int col = 0;col<columnsCount;col++)
		{
			Item columnItem = gridItems.get(columnsCount*rowIndex+col);
			if (!columnItem.isEmpty()&&"Grid checkbox"!=columnItem.control)
			{
				return true;
			}
		}
		return false;
	}
	
	public int countActiveRows()
	{
		int columnsCount = gridHeaders.size();
		int rowsCount = gridItems.size()/columnsCount;
		
		for (int i=0;i<rowsCount;i++)
		{
			if(!isRowActive(i))
			{
				return i;
			}
		}
		return rowsCount;
	}
	
	public Object getRow(Integer idx)
	{
		Object newRow =new Object();// in C# the line is new ExpandoObject() as IDictionary<string, Object>; need explantion
		String rowNumRegex=new String("_Row(\\d+)$");
		String gridRegex = new String ("^\\w+?_");
		
		Pattern rowNumRegexPattern=Pattern.compile(rowNumRegex);
		Matcher rowNumRegexMatcher;
		
		
		for (int i=0;i<gridItems.size();i++)
		{
			rowNumRegexMatcher = rowNumRegexPattern.matcher(gridItems.get(i).itemName);
			if(rowNumRegexMatcher.group(1)==idx.toString())
			{
				String newName = rowNumRegex.replace(gridItems.get(i).itemName,"");
				newName = gridRegex.replace(newName, "");
				newRow.add(newName,gridItems.get(i));
			}
		}
		return newRow;

	}
	
	public Object NewRow()
	{
		if(grid)
		{
			if(firstEmptyIndex==-1)
			{
				firstEmptyIndex=1;
			}
			if(!isIdxInGrid(firstEmptyIndex))
			{
				this.addRow();// what?????????? not understand the the C#
				
			}
			Object row=this.getRow(firstEmptyIndex);
			return row;
		}
		return null;
	}
	public boolean isIdxInGrid(int idx)
	{
		if(grid)
		{
			Pattern rowNumRegex = Pattern.compile("Row(||d+)$");
			Matcher doMatch = rowNumRegex.matcher(gridItems.get(gridItems.size()-1).itemName);
			int maxRowIdx = Integer.parseInt(doMatch.group(1));
			return (idx<=maxRowIdx);
		}
		return false;
	}
	public int getFirstEmptyIndex()
	{
		return this.getFirstEmptyIndex(false);
	}
	
	public int getFirstEmptyIndex(boolean calculate)
	{
		if(firstEmptyIndex!=-1 && !calculate)
		{
			return firstEmptyIndex;	
		}
		int maxNumberOfRows = gridItems.size()/gridHeaders.size();
		for (int i =1;i<=maxNumberOfRows;i++)
		{
			boolean isEmpty = this.isRowEmpty(i);
			if(isEmpty)
			{
				firstEmptyIndex=i;
				return i;
			}
		}
		firstEmptyIndex = maxNumberOfRows +1;
		return maxNumberOfRows;
		
	}
	public void appendRow (Object row)
	{
		Matcher matcher;
		if (grid)
		{
			Pattern firstRowRegex = Pattern.compile("Row1$");
			Pattern rowNumRegex = Pattern.compile("Row(\\d+$");
			matcher = rowNumRegex.matcher(gridItems.get(gridItems.size()).itemName);
			String maxRowIdx = matcher.group(1);
			String newRowIdx = (Object) this.getFirstEmptyIndex().toString();//return to this.
			
			if (Integer.parseInt(newRowIdx)<=Integer.parseInt(maxRowIdx))
			{
				int startIdx=-1;
				int finishIdx= -1;
				boolean isInRow = false;
				for (int i =0;i<row.size();i++)//to check with Michal, in c# line 1268
				{
					matcher = rowNumRegex.matcher(gridItems.get(i).itemName);
					if(!isInRow && matcher.group(1)==newRowIdx)
					{
						startIdx=i;
						isInRow = true;
					}
					else if(isInRow && matcher.group(1)!=newRowIdx)
					{
						finishIdx = i;
						isInRow = false;
						break;
					}
				}
				List <Item> newGridItems = gridItems.subList(0, startIdx);
				newGridItems.add(row);//to check this also with Michal, line 1282 in C#
				newGridItems.add(gridItems.subList(finishIdx, gridItems.size()-finishIdx));
			}
			String stringRowNumRegex=rowNumRegex.toString();
			for(int i =0;i<row.size;i++)
			{
				row[i].itemname = stringRowNumRegex.replace(row[i].itemName,"Row"+ newRowIdx);
			}
			
		}
	}	
	
	public boolean isRowEmpty(int idx)
	{
		String rowToCheck =Integer.toString(idx);
		Pattern rowNumRegex = Pattern.compile("Row(\\d+)$");
		Matcher matcherForRowNumRegex;
		
		for(int i=0;i<gridItems.size();i++)
		{
			matcherForRowNumRegex = rowNumRegex.matcher(gridItems.get(i).itemName);
			String itemRow = matcherForRowNumRegex.group(1);
			
			if(itemRow == rowToCheck)
			{
				//Pattern dateRe = Pattern.compile("^[dmy\\/]*$");
				//Pattern zeroRe = Pattern.compile("^0+$");
				String dateRe = "^[dmy\\/]*$";
				String zeroRe = "^0+$";
				

				boolean dateEmpty=(dateRe.matches(gridItems.get(i).mask) 
						&& (gridItems.get(i).toString()=="" || zeroRe.matches(gridItems.get(i).toString())));
				boolean checkBoxEmpty = ((gridItems.get(i).toString()=="??"
						|| gridItems.toString()=="") && gridItems.get(i).control.indexOf("CheckBox")>-1);
				if(!gridItems.get(i).valueIsEmpty&&!checkBoxEmpty)
				{
					return false;
				}
				
			}
				
		}		
		return true;
	}
	
	public void setYear(int year)
	{
		setYear(Integer.toString(year));
	}
	
	public void setYear(String year)//why not to do it in year format?
	{
		int curYear = Integer.parseInt(year);
		if (2>=year.length() && curYear !=0)
		{
			if (curYear > 30)
			{
				year = "19"+year;
			}
			else
			{
				year = "20"+year;
			}
		}
		if (""==value || null == value)
		{
			value = "00000101";
		}
		value = year+value.substring(4);
	}
	
	public void setMonth(int month)
	{
		setMonth(String.format("%tC", month));
	}
	
	public void setMonth(String month)
	{
		if(""==value || null == value)
		{
			value="00000101";
		}
		if (8==value.length())
		{
			value= value.substring(0,4)+month+value.substring(6);
		}
		else
		{
			value=value.substring(0,4)+month;
		}
	}
	public void setDay(int day)
	{
		String dayString = String.format("%td", day);
		
		if(""==value)
		{
			value="00000101";
		}
		value=value.substring(0,6)+dayString;
	}
	
	public String getYear()
	{
		String year = "";
		if(value.trim().length()>4)
		{
			year = value.substring(0,4);
		}
		return year;
	}
	
	public String getMonth()
	{
		String month="";
		if(value.trim().length()>=6)
		{
			month=value.substring(4,2);
		}
		return month;
	}
	
	public String getDay()
	{
		String day = "";
		if(value.trim().length()==8)
		{
			day = value.substring(6, 2);
		}
		return day;
	}
	
	boolean encoded = false;
	boolean decoded = false;
	
	@SuppressWarnings("deprecation")
	public void encodedValues()
	{
		encoded = true;
		value = URLEncoder.encode(value);
		defaultValue = URLEncoder.encode(defaultValue);
		mask = URLEncoder.encode(mask);
		for (int i=0;i<alternatePanels.size();i++)
		{
			AltPanel alt = alternatePanels.get(i);
			alt.option = URLEncoder.encode(alt.option);
		}
		for (int i =0 ; i< dynamicAttributes.size();i++)
		{
			DynamicAttributes attr = dynamicAttributes.get(i);
			attr.option = URLEncoder.encode(attr.option);
		}
		for ( int i =0; i <options.size();i++)
		{
			OptionL opt = options.get(i);
			opt.option = URLEncoder.encode(opt.option);
			opt.id = URLEncoder.encode(opt.id);
		}
	}
	
	public void decodeValues()
	{
		value = URLDecoder.decode(value);
		defaultValue = URLDecoder.decode(defaultValue);
		mask = URLDecoder.decode(mask);
		for (int i=0;i<alternatePanels.size();i++)
		{
			AltPanel alt = alternatePanels.get(i);
			alt.option = URLDecoder.decode(alt.option);
		}
		for (int i =0 ; i< dynamicAttributes.size();i++)
		{
			DynamicAttributes attr = dynamicAttributes.get(i);
			attr.option = URLDecoder.decode(attr.option);
		}
		for ( int i =0; i <options.size();i++)
		{
			OptionL opt = options.get(i);
			opt.optioni = URLEncoder.encode(opt.option);
			opt.id = URLDecoder.decode(opt.id);
		}
	}
	
	public Item getShallowClone()
	{
		Item clone = null;
		try {
			clone = (Item)this.clone();
		} catch (CloneNotSupportedException e) {
			System.out.println("couldn't clone in getShallowClone()");
			e.printStackTrace();
		}
		clone._isInScreen=false;
		return clone;
	}
	
	public void attachedToScreen()
	{
		this._isInScreen = true;
	}
	
	public void addRow()
	{
		if(grid)
		{
			List<Item> templateRow = new ArrayList<Item>();
			String regex = new String("Row(\\d+)$");
			Pattern pattern = Pattern.compile(regex);
			
			int maxRow = 0;
			for (int i =0;i<gridItems.size();i++)
			{
				Item itm = gridItems.get(i);
				if(itm.itemName.lastIndexOf("Row1")>-1&&itm.itemName.lastIndexOf("Row1")==itm.itemName.length()-1)
				{
					Item newItem = null;
					try {
						newItem = (Item)itm.clone();
					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(newItem!=null)
						templateRow.add(newItem);
				}
				Matcher res = pattern.matcher(itm.itemName);
				if(res.group().length()>1)
				{
					int rowNum = Integer.parseInt(res.group(1).toString());
					maxRow = Math.max(rowNum, maxRow);
				}
			}
			String newRow = Integer.toString(maxRow+1);
			for (int i=0;i<templateRow.size();i++)
			{
				Item newItem = templateRow.get(i);
				newItem.itemName = regex.replace(newItem.itemName, "Row"+newRow);
				newItem.value="";
				newItem.setAttributeInternally(newItem.originalAttrubute);
			}
			//stopped at line 1606 
			gridItems.addAll(templateRow);
		}
	}
	
	private Object ParseInt(String value)
	{
		if(value=="")
		{
			return 0;
		}
		return (int)Math.round(Float.parseFloat(value));
	}
	
	private Object ParseDecimal (String value)
	{
		if (value=="")
		{
			return 0;
		}
		return Float.parseFloat(value);
	}
	
	private Object ParseDate(String value, String dateFormat)//not understand why the dateFormat is needed
	{
		if(value=="")
		{
			return "00000000";
		}
		return value;
	}
	
	public static boolean isNumericType(Object o)
	{
		switch (o.getClass().getTypeName())
		 {
							case "Byte":
							case "SByte":
							case "UInt16":
							case "UInt32":
							case "UInt64":
							case "Int16":
							case "Int32":
							case "Int64":
							case "Decimal":
							case "Double":
							case "Single":
								return true;
							default:
								return false;
		 }
	}

	public static String maskToDateFormat(String mask)
	{
		String dateFormat = new String ();
		if("dd/mm/yyyy"==mask || "mm/dd/yyyy"==mask)
		{
			dateFormat ="yyyyMMdd";
		}
		else if ("mm/yyyy"==mask)
		{
			dateFormat="yyyyMM";
		}
		else if("yyyy"==mask)
		{
			dateFormat="yyyy";
		}
		return dateFormat;
	}
	
	public void uncastValues()
	{
		if("dateFormat"==type)
		{
			String dateFormat = maskToDateFormat(mask);
		}
	}
	
	public void convertVisualToLogical()
	{
		if (type=="String")
		{
			value=BidiVisual.convertVisualToLogical(value.toString()).Trim();
		}
	}
	
	public void convertLogicalToVisual()
	{
		convertVisualToLogical();
	}
	
	public boolean isChecked()
	{
		return (value=="!!" || value =="כ");
	}
	
	public void check()
	{
		boolean changed = (this.value!="!!");
		this.value="!!";
		if(changed)
		{
			updateDelta();
		}
		return;
	}
	public void unCheck()
	{
		boolean changed = (this.value!="??");
		this.value = "??";
		if(changed)
		{
			updateDelta();
		}
		return;
	}
	
	public void select(String option)
	{
		this.value=option;
		return;
	}
	
	public OptionL getSelectedOption()
	{
		for (OptionL opt : _this.options) 
			{
				if(opt.id==this.value)
				{
					return opt;
				}
			}
			return null;
	}
	
	public void addOption(String option,String id,int idx)
	{
		OptionL opt = new OptionL();
		opt.option = BidiVisual.convertVisualToLogical(option);
		opt.id = id;
		opt.idx = idx;
		this.options.add(opt);
		updateDelta();
		return;
	}
	
	public void removeOption()
	{
		removeOption(null, null, -999);
	}
	
	public void removeOption(String option, String id,int idx)
	{
		int i = -1;
		for (int j=0;j<this.options.size();j++)
		{
			if((option!=null && option ==this.options.get(j).option)||
			(id !=null && id == this.options.get(j).id)||
			(idx!=999 && idx == this.options.get(j).idx))
			{
				i=j;
				break;
			}
		}
		if (i!=-1)
		{
			this.options.remove(i);
		}
		updateDelta();
		return;
	}
		
	public void removeAllOptions()
	{
		this.options.clear();
	}
	
	public boolean hasOption(String option)
	{
		for (OptionL opt : options) 
		{
			if(opt.option == option)
				{
					return true;
				}
			
			} 
		return false;
		}	
	
}
