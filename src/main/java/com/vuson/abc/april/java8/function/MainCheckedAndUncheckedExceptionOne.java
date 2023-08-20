package com.vuson.abc.april.java8.function;

import javax.management.modelmbean.XMLParseException;
import java.io.IOException;

public class MainCheckedAndUncheckedExceptionOne {
    public static void main(String[] args) {
        try {
            doParseXML();
        } catch (XMLParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doParseXML() throws XMLParseException, IOException {
        doOpenXML();
        // Do parse XML. This method may be thrown a checked exception
    }

    private static void doOpenXML() throws IOException {
        // Do open XML. This method may be thrown a checked exception
    }
}
