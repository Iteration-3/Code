package utilities.structuredmap;

import static org.junit.Assert.*;

import org.junit.Test;

public class JsonReaderTest {
/*
	@Test
	public void test() {
		StructuredMap map = JsonReader.readJson("filename.txt");
		System.out.println(map.getJson());
	}
	*/
	@Test
	public void test2() {
		StructuredMap map = JsonReader.readJson("filetest.txt");
		System.out.println(map.getJson());
	}

}
