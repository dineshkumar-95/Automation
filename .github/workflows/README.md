# GitHub Actions Setup Guide

This document explains how to configure your TestNG UI automation tests to run in GitHub Actions.

## Prerequisites

1. Your repository must be hosted on GitHub
2. Your local tests should be working with the current DriverManager setup

## Workflow Configuration

The workflow file (`.github/workflows/testng-tests.yml`) supports:

### Automatic Triggers
- **Push events**: Runs on `main`, `master`, or `develop` branches with default Firefox settings
- **Pull requests**: Runs for PRs targeting main branches with default Firefox settings
- **Manual trigger**: Can be triggered manually from GitHub Actions tab with custom parameters

### Manual Trigger Parameters

When manually triggering the workflow, you can specify:

- **browserName**: Browser name (firefox, chrome, edge, safari) - Default: `firefox`
- **platformName**: Platform name (e.g., Windows 11, macOS, Linux) - Default: empty (local execution)
- **browserVersion**: Browser version (e.g., latest, 120, etc.) - Default: empty (local execution)

#### Local Execution (Default)
- Leave `platformName` and `browserVersion` empty
- Tests run locally in GitHub Actions using headless browsers
- Supports Firefox and Chrome

#### Cloud Execution (LambdaTest)
- Fill in `platformName` (e.g., "Windows 11")
- Fill in `browserVersion` (e.g., "latest")
- Requires LambdaTest credentials configured as GitHub secrets

## CI-Specific Setup

### Hardcoded Path Compatibility
The workflow automatically creates the directory structure to match your local hardcoded path:
- Creates `/Users/nilanid/work/Automation/` directory
- Creates symbolic link from GitHub Actions' geckodriver to your expected path
- This ensures your DriverManager.java works without code changes

### Headless Execution
- Browsers run in headless mode for CI environment
- Xvfb (virtual display) is set up for proper browser rendering
- `CI=true` environment variable enables headless mode in DriverManager

## Artifacts

After each run, the following artifacts are uploaded:
- **test-results-{browserName}**: TestNG surefire reports
- **extent-reports-{browserName}**: ExtentReports HTML reports
- **screenshots-{browserName}**: Failure screenshots

All artifacts are retained for 30 days. The artifact names include the browser name used for execution.

## Running Tests Locally vs CI

### Local Development
```bash
# Run with local Firefox
mvn test -DbrowserName=firefox

# Run with local Chrome
mvn test -DbrowserName=chrome
```

### CI Environment
Tests automatically run in headless mode when `CI` environment variable is detected.

## Troubleshooting

### Tests Fail in CI but Pass Locally
1. Check if headless mode is working properly
2. Verify all required dependencies are in pom.xml
3. Check test logs in GitHub Actions artifacts
4. Ensure the symbolic link creation step succeeded

### Browser Driver Issues
1. Ensure WebDriver setup actions are working in workflow
2. Check GitHub Actions logs for driver initialization errors
3. Verify the directory structure creation step completed successfully

### Timeout Issues
1. Increase wait times in test classes
2. Check if application is accessible from GitHub Actions network
3. Verify network connectivity to your test application

### Path Issues
If you see errors about the hardcoded path:
1. Check the "Create directory structure for hardcoded path" step in workflow logs
2. Ensure the symbolic link was created successfully
3. Verify geckodriver is properly installed by the setup action

## Next Steps

1. Push this workflow to your repository
2. Test the workflow by pushing to a monitored branch
3. Review test results and artifacts in GitHub Actions tab
4. Debug any issues using the uploaded artifacts and workflow logs