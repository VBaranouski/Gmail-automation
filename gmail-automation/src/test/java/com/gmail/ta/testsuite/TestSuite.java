package com.gmail.ta.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.gmail.ta.tests.CheckSpamFolderTest;
import com.gmail.ta.tests.MoveEmailToSpamTest;
import com.gmail.ta.tests.SendEmailTest;


@RunWith (Suite.class)
@Suite.SuiteClasses({SendEmailTest.class, MoveEmailToSpamTest.class, SendEmailTest.class, CheckSpamFolderTest.class })

public class TestSuite {

}
