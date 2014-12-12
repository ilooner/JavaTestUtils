/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topekalabs.testutils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 *
 * @author Topeka Labs
 */
public class FileTestWatcher extends TestWatcher
{
    private File tempDir;
    private boolean deleteDir = true;
    
    public FileTestWatcher()
    {
    }
    
    public FileTestWatcher(boolean deleteDir)
    {
        setDeleteDir(deleteDir);
    }
    
    private void setDeleteDir(boolean deleteDir)
    {
        this.deleteDir = deleteDir;
    }
    
    public File getTempDir()
    {
        return tempDir;
    }
    
    @Override
    public void starting(Description description)
    {
        String fileName = TestUtils.BUILD_DIR + File.separator +
                          description.getClassName() + File.separator +
                          description.getMethodName();
        
        tempDir = new File(fileName);
        
        try
        {
            FileUtils.deleteDirectory(tempDir);
        }
        catch(IOException ex)
        {
            throw new RuntimeException(ex);
        }
        
        tempDir.mkdirs();
    }
    
    @Override
    public void finished(Description description)
    {
        if(deleteDir)
        {
            try
            {
                FileUtils.deleteDirectory(tempDir);
            }
            catch(IOException ex)
            {
                throw new RuntimeException(ex);
            }
        }
    }
}
