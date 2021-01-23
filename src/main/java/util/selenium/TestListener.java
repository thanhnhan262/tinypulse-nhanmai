package util.selenium;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import util.logging.LogUtil;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {

    private long timeStart, timeEnd;
    private long totalTime;
    @Override
    public void onTestStart(ITestResult iTestResult) {
        LogUtil.info("");
        LogUtil.info("-------------------------------------------------------------------------------------");
        LogUtil.info("Start test case " + iTestResult.getTestClass().getName() + ": " + iTestResult.getMethod().getDescription());
        timeStart = System.currentTimeMillis();
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        timeEnd = System.currentTimeMillis();
        long eachTestElapsed = timeEnd - timeStart;
        LogUtil.info(">>> Result: Passed, Duration: " + String.format("%d minutes, %d seconds",
                TimeUnit.MILLISECONDS.toMinutes(eachTestElapsed),
                TimeUnit.MILLISECONDS.toSeconds(eachTestElapsed)));
        LogUtil.info("-------------------------------------------------------------------------------------");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        timeEnd = System.currentTimeMillis();
        long eachTestElapsed = timeEnd - timeStart;
        LogUtil.info(">>> Result: Failed, Duration: " + String.format("%d minutes, %d seconds",
                TimeUnit.MILLISECONDS.toMinutes(eachTestElapsed),
                TimeUnit.MILLISECONDS.toSeconds(eachTestElapsed)));
        LogUtil.info("-------------------------------------------------------------------------------------");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext result){
        totalTime = System.currentTimeMillis();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        long wholeTestElapsed = System.currentTimeMillis() - totalTime;
        LogUtil.info("");
        LogUtil.info("====================================");
        LogUtil.info("TOTAL RUN TIME: " + String.format("%d minutes, %d seconds",
                TimeUnit.MILLISECONDS.toMinutes(wholeTestElapsed),
                TimeUnit.MILLISECONDS.toSeconds(wholeTestElapsed)));
        LogUtil.info("====================================");
    }
}
