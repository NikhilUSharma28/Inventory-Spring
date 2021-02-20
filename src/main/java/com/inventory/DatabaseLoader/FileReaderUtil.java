package com.inventory.DatabaseLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;

import com.inventory.service.InvenService;


public class FileReaderUtil {
	private static final Logger LOG = LogManager.getLogger(FileReaderUtil.class);  
	private static FileReaderUtil instance = new FileReaderUtil();
	static Properties p = new Properties();

	private FileReaderUtil() {
	}

	public static FileReaderUtil getInstance() {
		return instance;
	}

	public static String getQuery(String query) throws IOException {
		String queryString = null;
		try {
			InputStream input = InvenService.class.getClassLoader().getResourceAsStream("queries.sql");
			{
				p.load(input);
				queryString = p.getProperty(query);
			}
			input.close();
			return queryString;
		} catch (Exception e) {
			LOG.error("Queries can not be loaded",e);
		}
		return queryString;
	}
}
