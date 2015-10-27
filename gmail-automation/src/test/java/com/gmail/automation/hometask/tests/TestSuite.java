package com.gmail.automation.hometask.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith (Suite.class)
@Suite.SuiteClasses({SendEmail.class, MoveEmailToSpam.class, SendEmail.class, CheckSpamFolder.class })

public class TestSuite {

}
