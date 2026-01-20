package com.cognizant.banking.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@SelectPackages("com.cognizant.banking.models")
@IncludeTags("qa")
@Suite
public class CustomerTestSuite {

}
