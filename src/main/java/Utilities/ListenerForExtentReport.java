package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerForExtentReport extends ExtentReport implements ITestListener {
    ExtentReports extent=ReportGenerator();
    ExtentTest test;
    private static ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
    public void onTestStart(ITestResult result) {
        System.out.println("Start of Test"+ result.getName());
        test=extent.createTest(result.getName());
        extenttest.set(test);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Success of Test"+result.getName());
        extenttest.get().log(Status.PASS,"Successful");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failure of Test"+result.getName());
        extenttest.get().log(Status.FAIL,result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        extent.flush();
    }
}
