/*
 * Copyright (c) 2013. AgileApes (http://www.agileapes.scom/), and
 * associated organization.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies
 * or substantial portions of the Software.
 */

package com.agileapes.nemo.demo;

import com.agileapes.nemo.action.Action;
import com.agileapes.nemo.api.Help;
import com.agileapes.nemo.api.Option;
import com.agileapes.nemo.util.output.Grid;

import java.io.File;

/**
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2013/6/4, 20:33)
 */
@Help(value = "Lists the files in the current directory")
public class ListAction extends Action {

    @Option(alias = 'x')
    @Help(value = "Prints sequential file numbers prior to file path")
    private boolean numbers;

    @Override
    public void execute() throws Exception {
        final File current = new File(".");
        final File[] files = current.listFiles();
        if (files == null) {
            throw new Exception("Could not get the list of files under current directory");
        }
        int i = 0;
        output.println("There are " + files.length + " files under " + current.getAbsolutePath());
        output.println();
        final Grid grid = new Grid(numbers ? "r5 l6 *" : "l6 *");
        if (numbers) {
            grid.add("#", "Size", "Name");
        } else {
            grid.add("Size", "Name");
        }
        grid.line();
        for (File file : files) {
            if (numbers) {
                grid.add(Integer.toString(++i), Long.toString(file.length()), file.getName());
            } else {
                grid.add(Long.toString(file.length()), file.getName());
            }
        }
        output.println(grid.draw());
    }
}
