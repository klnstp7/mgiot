package com.migen.iotcloud.entity;

/**
 * 
 * @author fengy
 * 
 */
public class FirstShow
{
	private String	name;
	private String	value;
	private String	group	= "机器信息";
	private String	editor	= "text";

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public String getGroup()
	{
		return group;
	}

	public void setGroup(String group)
	{
		this.group = group;
	}

	public String getEditor()
	{
		return editor;
	}

	public void setEditor(String editor)
	{
		this.editor = editor;
	}

	@Override
	public String toString()
	{
		return "FirstShowBean [name=" + name + ", value=" + value + ", group=" + group + ", editor=" + editor + "]";
	}

}
