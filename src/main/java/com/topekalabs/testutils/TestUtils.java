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
    public static final String PROPERTY_RESOURCE_MAIN_DIRECTORY = "java.testutils.resources.main";
    public static final String PROPERTY_RESOURCE_TEST_DIRECTORY = "java.testutils.resources.test";
    
    public static final String BUILD_DIR;
    public static final String RESOURCES_MAIN_DIR;
    public static final String RESOURCES_TEST_DIR;
    
    ////////////////////////////////////////////////////////////////////////////
    // TODO - Add annotations and set variables with a loop instead of manually
    // setting them.
    ////////////////////////////////////////////////////////////////////////////
    
    static
    {
        BUILD_DIR = System.getProperty(PROPERTY_BUILD_DIRECTORY);
        propertyNotSetException(PROPERTY_BUILD_DIRECTORY, BUILD_DIR);
        
        RESOURCES_MAIN_DIR = System.getProperty(PROPERTY_RESOURCE_MAIN_DIRECTORY);
        propertyNotSetException(PROPERTY_RESOURCE_MAIN_DIRECTORY, RESOURCES_MAIN_DIR);
        
        RESOURCES_TEST_DIR = System.getProperty(PROPERTY_RESOURCE_TEST_DIRECTORY);
        propertyNotSetException(PROPERTY_RESOURCE_TEST_DIRECTORY, RESOURCES_TEST_DIR);
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
