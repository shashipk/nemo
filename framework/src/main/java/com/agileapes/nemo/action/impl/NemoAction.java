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

package com.agileapes.nemo.action.impl;

import com.agileapes.nemo.action.Action;
import com.agileapes.nemo.api.Help;
import com.agileapes.nemo.api.Option;

import java.io.PrintStream;

/**
 * This action will simply print out an about message that will introduce Nemo&copy; as the
 * underlying framework.
 *
 * @author Mohammad Milad Naseri (m.m.naseri@gmail.com)
 * @since 1.0 (2013/6/4, 18:27)
 */
@Help(
        value = "Brings up a simple 'About Nemo (c)' message",
        description = "You can ask for more details using the '--verbose' option"
)
public class NemoAction extends Action {

    private boolean verbose;

    public boolean isVerbose() {
        return verbose;
    }

    @Option(alias = 'v')
    @Help(value = "This will give you more information about Nemo (c)")
    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public void perform(PrintStream output) throws Exception {
        output.println(" Nemo v1.0 -- CLI assistance framework");
        output.println("========================================");
        output.println("  brought to you by AgileApes, Ltd.");
        output.println("  http://projects.agileapes.com/nemo");
        output.println("  Copyright AgileApes, Ltd (c) 2013");
        if (verbose) {
            output.println("----------------------------------------");
            output.println("  Developed by: M. M. Naseri");
            output.println("                m.m.naseri@gmail.com");
        }
    }

}