# GitHub Actions Setup Guide

This document explains how to configure your TestNG automation tests to run in GitHub Actions.

## Prerequisites

1. Your repository must be hosted on GitHub
2. You need admin access to configure repository secrets

## Setting Up GitHub Secrets

### Required Secrets for LambdaTest Cloud Execution

If you want to run tests on LambdaTest cloud:

1. Go to your GitHub repository
2. Navigate to **Settings** → **Secrets and variables** → **Actions**
3. Click **New repository secret**
4. Add the following secrets:

   - **LT_USERNAME**: Your LambdaTest username (`dineshkec95`)
   - **LT_ACCESS_KEY**: Your LambdaTest access key (`LT_Dv1wdYJwGCreRE1WmXl1BdTMhZpo8O8HxFBB1PssDGCjFMe`)

### Optional Environment Variables

You can also configure these in your repository settings under **Secrets and variables** → **Actions** → **Variables**:

- **API_BASE_URL**: Base URL for API tests (default: `https://dinesh-kumar-test.chargebee.com`)

## Workflow Configuration

The workflow file (`.github/workflows/testng-tests.yml`) supports:

### Automatic Triggers
- **Push events**: Runs on `main`, `master`, or `develop` branches
- **Pull requests**: Runs for PRs targeting main branches
- **Manual trigger**: Can be triggered manually from GitHub Actions tab

### Execution Modes

#### Local Browser Execution (Default)
Runs tests locally in GitHub Actions using headless browsers:
- Firefox (headless)
- Chrome (headless)

#### LambdaTest Cloud Execution (Manual)
To run tests on LambdaTest cloud:
1. Go to **Actions** tab in your repository
2. Select **TestNG Automation Tests** workflow
3. Click **Run workflow**
4. Select branch and use default options

## Browser Matrix

The workflow runs tests across multiple browsers:
- Firefox
- Chrome

## Artifacts

After each run, the following artifacts are uploaded:
- **test-results-{browser}**: TestNG surefire reports
- **extent-reports-{browser}**: ExtentReports HTML reports
- **screenshots-{browser}**: Failure screenshots
- **api-test-results**: API test results (if applicable)

## CI-Specific Code Changes

The `DriverManager.java` has been updated to:
- Automatically detect CI environment using `CI` environment variable
- Run browsers in headless mode when in CI
- Use WebDriver executables from system PATH in CI
- Maintain local development behavior with hardcoded paths

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

### LambdaTest Authentication Errors
1. Verify `LT_USERNAME` and `LT_ACCESS_KEY` secrets are set correctly
2. Ensure your LambdaTest account has sufficient credits

### Browser Driver Issues
1. Ensure WebDriver setup actions are working in workflow
2. Check GitHub Actions logs for driver initialization errors

### Timeout Issues
1. Increase wait times in test classes
2. Check if application is accessible from GitHub Actions network

## Next Steps

1. Push this workflow to your repository
2. Configure required secrets
3. Test the workflow by pushing to a monitored branch
4. Review test results and artifacts in GitHub Actions tab