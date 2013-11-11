package com.agileinfoways.xm.sax;

import java.io.InputStream;

import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.util.Log;

import com.agileinfoways.bean.Study;

public class StudyParser_Sax 
{
	public static Study parse(InputStream is) 
	{
		Study study = null;
		try 
		{
			// create a XMLReader from SAXParser
			XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
			// create a StudyHandler too
			StudyHandler_Sax studyHandler = new StudyHandler_Sax();
			// apply handler to the XMLReader
			xmlReader.setContentHandler(studyHandler);
			// the process starts
			xmlReader.parse(new InputSource(is));
			// get the target `Study`
			study = studyHandler.getStudy();
		} 
		catch(Exception ex) 
		{
			Log.d("XML", "StudyParser: parse() failed");
		}
		return study;
	}
}