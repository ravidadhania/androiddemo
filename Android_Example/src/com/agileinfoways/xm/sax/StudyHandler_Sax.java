package com.agileinfoways.xm.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.agileinfoways.bean.Study;

public class StudyHandler_Sax extends DefaultHandler 
{
	// members
	private boolean isTopic;
	private boolean isContent;
	private boolean isAuthor;
	private boolean isDate;
	// 'Study' entity to parse
	private Study mStudy;
	// 'getter' is enough
	public Study getStudy() 
	{
		return mStudy;
	}
	
	@Override
	public void startDocument() throws SAXException 
	{
		// create new object
		mStudy = new Study();
	}
	
	@Override
	public void endDocument() throws SAXException
	{
		// nothing we need to do here
	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts)throws SAXException 
	{
		// if this element value equals "study"
		if(localName.equals(Study.STUDY)) 
		{
			// get id right away
			mStudy.mId = Integer.parseInt(atts.getValue(Study.ID));
		}
		// if this element value equals "topic"
		else if(localName.equals(Study.TOPIC)) 
		{
			// mark current element is "topic"
			isTopic = true;
		}
		// if this element value equals "content"
		else if(localName.equals(Study.CONTENT)) 
		{
			// mark current element is "content"
			isContent = true;
		}
		// if this element value equals "author"
		else if(localName.equals(Study.AUTHOR)) 
		{
			// mark current element is "author"
			isAuthor = true;
		}
		// if this element value equals "date"
		else if(localName.equals(Study.DATE)) 
		{
			// mark current element is "date"
			isDate = true;
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException 
	{
		if(localName.equals(Study.STUDY)) 
		{
		    // already get the attribute "id", nothing needs to do here
		}
		// if this element value equals "topic"
		else if(localName.equals(Study.TOPIC)) 
		{
			// uncheck marking
		    isTopic = false;
		}
		// if this element value equals "topic"
		else if(localName.equals(Study.CONTENT)) 
		{
			// uncheck marking
			isContent = false;
		}
		// if this element value equals "topic"
		else if(localName.equals(Study.AUTHOR)) 
		{
			// uncheck marking
			isAuthor = false;
		}
		// if this element value equals "topic"
		else if(localName.equals(Study.DATE)) 
		{
			// uncheck marking
			isDate = false;
		}
	}

	@Override
	public void characters(char ch[], int start, int length) 
	{
		// get all text value inside the element tag
		String chars = new String(ch, start, length);
	    chars = chars.trim(); // remove all white-space characters

	    // if this tag is "topic", set "topic" value
	    if(isTopic) mStudy.mTopic = chars;
	    // if this tag is "content", set "content" value
	    else if(isContent) mStudy.mContent = chars;
	    // if this tag is "author", set "author" value
	    else if(isAuthor) mStudy.mAuthor = chars;
	    // if this tag is "date", set "date" value
	    else if(isDate) mStudy.mDate = chars;
	}
}
