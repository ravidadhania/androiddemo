package com.agileinfoways.xml.pull;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import com.agileinfoways.bean.Study;

public class StudyParser_Pull 
{
	public static Study parse(InputStream is) 
	{
		// create new Study object to hold data
		Study study = null;

		try 
		{
			// get a new XmlPullParser object from Factory
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			// set input source
			parser.setInput(is, null);
			// get event type
			int eventType = parser.getEventType();
			// process tag while not reaching the end of document
			while(eventType != XmlPullParser.END_DOCUMENT) 
			{
				switch(eventType) 
				{
					// at start of document: START_DOCUMENT
					case XmlPullParser.START_DOCUMENT:
						study = new Study();
						break;

					// at start of a tag: START_TAG
					case XmlPullParser.START_TAG:
						// get tag name
						String tagName = parser.getName();
						// if <study>, get attribute: 'id'
						if(tagName.equalsIgnoreCase(Study.STUDY)) 
						{
							study.mId = Integer.parseInt(parser.getAttributeValue(null, Study.ID));
						}
						// if <content>
						else if(tagName.equalsIgnoreCase(Study.CONTENT)) 
						{
							study.mContent = parser.nextText();
						}
						// if <topic>
						else if(tagName.equalsIgnoreCase(Study.TOPIC)) 
						{
							study.mTopic = parser.nextText();
						}
						// if <author>
						else if(tagName.equalsIgnoreCase(Study.AUTHOR)) 
						{
							study.mAuthor = parser.nextText();
						}
						// if <date>
						else if(tagName.equalsIgnoreCase(Study.DATE)) 
						{
							study.mDate = parser.nextText();
						}
						break;
				}
				// jump to next event
				eventType = parser.next();
			}
		// exception stuffs
		} 
		catch (XmlPullParserException e) 
		{
			study = null;
		}
		catch (IOException e) 
		{
			study = null;
		}
		// return Study object
		return study;
	}
}
