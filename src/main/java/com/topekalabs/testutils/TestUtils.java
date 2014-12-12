/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topekalabs.testutils;

/**
 *
 * @author Topeka Labs
 */
public class TestUtils
{
    public static final String PROPERTY_BUILD_DIRECTORY = "java.testutils.build.dir";
    
    public static final String BUILD_DIR;
    
    static
    {
        BUILD_DIR = System.getProperty(PROPERTY_BUILD_DIRECTORY);
        propertyNotSetException(PROPERTY_BUILD_DIRECTORY, BUILD_DIR);
    }
    
    private TestUtils()
    {
        //Do Nothing
    }
    
    private static void propertyNotSetException(String property,
                                                String value)
    {
        if(value != null)
        {
            return;
        }
        
        throw new IllegalStateException("The value of " + property + " was not set.");
    }
            
}
